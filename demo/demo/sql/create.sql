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

insert into user values(1, "William", "william@gmail.com", "william", null, "Teacher", "Jurong");
insert into user values(2, "Emma", "emma@gmail.com", "emma", null, "Teacher", "Buona Vista");
insert into user values(3, "Oliver", "oliver@gmail.com", "oliver", null, "Teacher", "Bugis");
insert into user values(4, "Ava", "ava@gmail.com", "ava", null, "Teacher", "Farrer Park");
insert into user values(5, "Harper", "harper@gmail.com", "harper", null, "Teacher", "Farrer Park");

drop table if exists `Skills`;
create table `Skills`
(
    `skill_id` int auto_increment primary key,
    `name` varchar(255),
    `difficulty` varchar(255),
    `price` decimal(4,2),
    `user_id` int,
    foreign key(`user_id`) references `User`(`user_id`)
);

insert into skills values (1, "Skating", "Expert", 20.00, 1);
insert into skills values (2, "Gardening", "Beginner", 30.00, 1);
insert into skills values (3, "Woodworking", "Intermediate", 40.00, 2);
insert into skills values (4, "Handicraft", "Expert", 27.00, 3);
insert into skills values (5, "Knitting", "Intermediate", 20.00, 3);
insert into skills values (6, "Pottery", "Beginner", 55.00, 3);
insert into skills values (7, "Archery", "Intermediate", 65.00, 4);
insert into skills values (8, "Photography", "Beginner", 15.00, 4);
insert into skills values (9, "Baking", "Expert", 40.00, 5);

drop table if exists `Community`;
create table `Community`
(
    `community_id` int auto_increment primary key,
    `name` varchar(255),
    `description` varchar(255)
);

insert into community values(1, "Baking", "We hope you love all things sweet");
insert into community values(2, "The Sweet Scents", "For people who love experimenting and creating new wonders with scents");
insert into community values(3, "Archer's Den", "All is welcomed no matter the experience");
insert into community values(4, "Arts and Craft", "A community for those who love arts and craft");

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
    `content` varchar(500),
    `community_id` int
);

insert into post values(1, "In cookie recipes, it’s difficult to find the balance of enough liquid flavor without ruining the cookie’s texture and spreadability.", 1);
insert into post values(2, "Ever since I received a preloved Zojirushi bread machine, I have been baking homemade bread regularly.", 1);
insert into post values(3, "Brownies are one of my family's all time favourite baked goods. They take very little time to prepare and are so simple that 
anyone can bake a batch with ease.", 1);
insert into post values(4, "Fragrance-lovers and collectors the world over look forward with glee to the launch of the 
latest Guerlain limited edition Bee Bottle perfumes.", 2);
insert into post values(5, "Celebrating International Women’s Day, in previous years we’ve flagged up female perfumers who’ve shaped the scent world.", 2);
insert into post values(7, "Just-launched, this Dream Scents Discovery Box is SO perfect for right now because love is in the air", 2);
insert into post values(8, "New fragrance trends can be tricky to forecast, but a huge clue is the secret ingredients known as ‘captives’ 
or ‘captive molecules’.", 2);
insert into post values(9, "Whether you’re inspired by bow-wielding heroes in fantasy flicks or just want to try a unique activity or alternative date idea, archery is worth a shot.", 3);
insert into post values(10, "When you have a niece that is getting into holiday crafting, you encourage her. At least that is what I do with my niece! 
I want her to follow her aunt’s footsteps.", 4);
insert into post values(11, "Here is a spring garland DIY I made recently with yarn carrots. 
This was partially inspired by Laura’s yarn pumpkin garland, which I think is super cute.", 4);
insert into post values(12, "If a tapestry is displayed in my home, it is somehow framed. I 
love how it turns a handwoven piece into a modern work of art.", 4);
insert into post values(13, "It was a rainbow of acrylic chain links that inspired me to DIY my own case – 
equipped with its own strap and all.", 4);



