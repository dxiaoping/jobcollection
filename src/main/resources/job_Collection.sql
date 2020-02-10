use job_collection;
create database job_collection;
DROP TABLE IF EXISTS `wxinfo`;
create table `wxinfo` (
  `id` int auto_increment not null primary key,
  `nick_name` varchar(20) not null,
  `avatar_url` varchar(200) not null,
  `city` varchar(20),
  `country` varchar(20),
  `gender` int not null,
  `language` varchar(20),
  `province` varchar(10)
)
  engine = MyISAM;

DROP TABLE IF EXISTS `wxinfo`;
create table `jobinfo` (
  `company` varchar(50),
  `address` varchar(50),
  `start_time` datetime,
  `face_college` varchar(255),
  `detail_url` varchar(255) unique
);
