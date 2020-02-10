package com.ccsu.jobcollection.service.impl;

import com.ccsu.jobcollection.mapper.WxInfoMapper;
import com.ccsu.jobcollection.pojo.WxInfo;
import com.ccsu.jobcollection.service.UserService;
import java.util.Base64;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @Description
 * @auther DuanXiaoping
 * @create 2020-01-28 13:33
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private WxInfoMapper wxInfoMapper;

    @Override
    public void saveWxInfo(WxInfo wxInfo) {
        wxInfoMapper.insert(wxInfo);
    }

    @Override
    public WxInfo getWxInfoByOpenid(String openid) {
        WxInfo wxInfo = wxInfoMapper.selectByOpenid(openid);
        return wxInfo;
    }

    @Override
    public WxInfo decipher(String encry, String iv, String sessionkey) {

//        byte[] encrypData = Base64.decode(encry);
        byte[] encrypData = Base64.getDecoder().decode(encry);
        byte[] ivData = Base64.getDecoder().decode(iv);
        byte[] sessionKey = Base64.getDecoder().decode(sessionkey);
        String str = "";
        try {
            str = decrypt(sessionKey, ivData, encrypData);
        } catch (Exception e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(str);
        JSONObject json = new JSONObject(str);
//        {"openId":"oqUDj5GJCEVNpI5zF5VuN-POPCSk","nickName":"平","gender":1,"language":"zh_CN","city":"Chenzhou","province":"Hunan","country":"China","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/rZEIzYRP1QsnqfLR7Viciaeyhzo51SbUNJRhIlJzlpla2WJicyVibb9DFbHOgCOAzyeQUBAD8NFyQ1tZhNlHF1e9Tw/132","watermark":{"timestamp":1580903283,"appid":"wx85ba6df0e1434c0a"}}
        WxInfo wxInfo = getWxInfoFromJson(json);
        if (wxInfoMapper.selectByOpenid(wxInfo.getOpenid()) == null) {
            wxInfoMapper.insert(wxInfo);
        }else {
            wxInfoMapper.update(wxInfo);
        }
        return wxInfo;
    }

    public String decrypt(byte[] key, byte[] iv, byte[] encData) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(iv);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        //解析解密后的字符串  
        return new String(cipher.doFinal(encData), "UTF-8");
    }

    public WxInfo getWxInfoFromJson(JSONObject json){
        WxInfo wxInfo = new WxInfo();
        wxInfo.setOpenid(json.getString("openId"));
        wxInfo.setNickName(json.getString("nickName"));
        wxInfo.setGender(json.getInt("gender"));
        wxInfo.setLanguage(json.getString("language"));
        wxInfo.setCity(json.getString("city"));
        wxInfo.setProvince(json.getString("province"));
        wxInfo.setCountry(json.getString("country"));
        wxInfo.setAvatarUrl(json.getString("avatarUrl"));
        return wxInfo;
    }
}
