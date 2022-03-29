drop schema if exists cs206;
create schema if not exists cs206;
use cs206;


drop table if exists `User`;
create table `User`
(
    `user_id` int auto_increment primary key,
    `name` varchar(255),
    `email` varchar(255),
    `password` varchar(255),
    `instagram` varchar(255),
    `role` varchar(255),
    `location` varchar(255)
);

drop table if exists `Skills`;
create table `Skills`
(
    `skill_id` int auto_increment primary key,
    `name` varchar(255),
    `difficulty` varchar(255),
    `price` decimal(3,2),
    `user_id` int,
    foreign key(`user_id`) references `User`(`user_id`)
);

drop table if exists `Community`;
create table `Community`
(
    `community_id` int auto_increment primary key,
    `name` varchar(255),
    `description` varchar(255)
);

drop table if exists `User_Communities`;
create table `User_Communities`
(
    `user_communities_id` int auto_increment primary key,
    `user_id` int,
    `community_id` int
);

drop table if exists `Post`;
create table `Post`
(
    `post_id` int auto_increment primary key,
    `content` varchar(255),
    `community_id` int
);



