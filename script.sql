delete from `comment`;
delete from `note`;
delete from `idea`;
delete from `User`;
delete from `Group`;


-- CREATE TABLE IF NOT EXISTS `Group` (
--   `id_group` int(11) NOT NULL AUTO_INCREMENT,
--   `name_group` String(100) NOT NULL,
--   `service_group` text NOT NULL,

insert into `Group` (id_group, name_group, service_group) values(1, 'SI','service informatique');
insert into `Group` (id_group, name_group, service_group) values(2, 'management','commerce et marketing');
insert into `Group` (id_group, name_group, service_group) values(3, 'DSI','sys informatique et technologie');
insert into `Group` (id_group, name_group, service_group) values(4, 'MOA','conseil');
insert into `Group` (id_group, name_group, service_group) values(5, 'MOE','développement');

-- CREATE TABLE IF NOT EXISTS `User` (
--   `id_user` int(11) NOT NULL AUTO_INCREMENT,
--   `login` varchar(20) NOT NULL,
--   `firstname` varchar(20) NOT NULL,
--   `lastname` varchar(20) NOT NULL,
--   `id_group` int(11) NOT NULL,

insert into `User` (id_user, login, firstname, lastname, id_group) values(0, 'admin','admin','admin', 1);
insert into `User` (id_user, login, firstname, lastname, id_group) values(1, 'jjack','john','jack', 1);
insert into `User` (id_user, login, firstname, lastname, id_group) values(2, 'sbell','sam','bell', 2);
insert into `User` (id_user, login, firstname, lastname, id_group) values(3, 'bjean','brel','jean', 2);
insert into `User` (id_user, login, firstname, lastname, id_group) values(4, 'mlepen','marie','lepen', 2);
insert into `User` (id_user, login, firstname, lastname, id_group) values(5, 'eali','eman','ali', 3);
insert into `User` (id_user, login, firstname, lastname, id_group) values(6, 'afouad','ahmed','fouad', 5);
insert into `User` (id_user, login, firstname, lastname, id_group) values(7, 'isophie','iman','sophie', 5);
insert into `User` (id_user, login, firstname, lastname, id_group) values(8, 'fgon','fred','gon', 5);	

-- CREATE TABLE IF NOT EXISTS `idea` (
--   `id_idea` int(11) NOT NULL AUTO_INCREMENT,
--   `text_idea` text NOT NULL,
--   `title_idea` varchar(100) NOT NULL,
--   `id_user` int(11) NOT NULL,

insert into `idea` (id_idea, text_idea, title_idea, id_user) values(1, 'idea 1','title idea 1',1);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(2, 'idea 2','title idea 2',1);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(3, 'idea 3','title idea 3',1);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(4, 'idea 4','title idea 4',2);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(5, 'idea 5','title idea 5',2);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(6, 'idea 6','title idea 6',6);	
insert into `idea` (id_idea, text_idea, title_idea, id_user) values(7, 'idea 7','title idea 7',7);		

-- CREATE TABLE IF NOT EXISTS `note` (
--   `id_note` int(11) NOT NULL AUTO_INCREMENT,
--   `nbr_stars` int(1) NOT NULL,
--   `id_idea` int(11) NOT NULL,
--   `id_user` int(11) NOT NULL,

insert into `note` (id_note, nbr_stars, id_idea, id_user) values(1, 4, 1, 1);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(2, 2, 1, 2);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(3, 3, 1, 2);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(4, 1, 3, 2);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(5, 0, 4, 7);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(6, 1, 4, 0);	
insert into `note` (id_note, nbr_stars, id_idea, id_user) values(7, 5, 7, 3);		

-- CREATE TABLE IF NOT EXISTS `comment` (
--   `id_comment` int(11) NOT NULL AUTO_INCREMENT,
--   `text_comment` text NOT NULL,
--   `id_idea` int(11) NOT NULL,
--   `id_user` int(11) NOT NULL,

insert into `comment` (id_comment, text_comment, id_idea, id_user) values(1, 'comment1',1, 1);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(2, 'comment2',1, 2);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(3, 'comment3',1, 2);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(4, 'comment4',1, 2);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(5, 'comment5',2, 3);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(6, 'comment6',2, 5);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(7, 'comment7',6, 7);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(8, 'comment8',1, 0);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(9, 'comment9',7, 0);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(10, 'comment10',4, 3);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(11, 'comment11',5, 6);	
insert into `comment` (id_comment, text_comment, id_idea, id_user) values(12, 'comment12',7, 6);	




