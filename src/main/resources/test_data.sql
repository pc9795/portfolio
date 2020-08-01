insert into listitem values('1',NULL,'casual_1','casual');
insert into listitem values('2',NULL,'casual_2','casual');
insert into listitem values('3',NULL,'tech_1','technical');
insert into listitem values('4',NULL,'tech_2','technical');
insert into listitem values('5',NULL,'gaming_1','gaming');
insert into listitem values('6',NULL,'gaming_2','gaming');


insert into blogtag values('1','java'), ('2','python');

insert into tutorialtag values('1','java'), ('2','python');

insert into blogitem(id,content,timestamp,description,heading) values('1','blog_content_1','2018-09-01 00:00:00','blog_description_1','blog_heading_1');
insert into blogitem(id,content,timestamp,description,heading) values('2','blog_content_2','2017-09-01 00:00:00','blog_description_2','blog_heading_2');
insert into blogitem(id,content,timestamp,description,heading) values('3','blog_content_3','2018-01-01 00:00:00','blog_description_3','blog_heading_3');
insert into blogitem(id,content,timestamp,description,heading) values('4','blog_content_4','2018-01-01 12:00:00','blog_description_4','blog_heading_4');
insert into blogitem(id,content,timestamp,description,heading) values('5','blog_content_5','2018-02-01 00:00:00','blog_description_5','blog_heading_5');
insert into blogitem(id,content,timestamp,description,heading) values('6','blog_content_6','2018-02-01 12:00:00','blog_description_6','blog_heading_6');
insert into blogitem(id,content,timestamp,description,heading) values('7','blog_content_7','2018-03-01 00:00:00','blog_description_7','blog_heading_7');
insert into blogitem(id,content,timestamp,description,heading) values('8','blog_content_8','2018-03-01 12:00:00','blog_description_8','blog_heading_8');
insert into blogitem(id,content,timestamp,description,heading) values('9','blog_content_9','2018-04-01 00:00:00','blog_description_9','blog_heading_9');
insert into blogitem(id,content,timestamp,description,heading) values('10','blog_content_10','2018-04-01 12:00:00','blog_description_10','blog_heading_10');

insert into tutorialitem(id,content,timestamp,description,heading) values('1','tutorial_content_1','2018-09-01 00:00:00','tutorial_description_1','how_to_do_1');
insert into tutorialitem(id,content,timestamp,description,heading) values('2','tutorial_content_2','2017-09-01 00:00:00','tutorial_description_2','how_to_do_2');
insert into tutorialitem(id,content,timestamp,description,heading) values('3','tutorial_content_3','2018-01-01 00:00:00','tutorial_description_3','how_to_do_3');
insert into tutorialitem(id,content,timestamp,description,heading) values('4','tutorial_content_4','2018-01-01 12:00:00','tutorial_description_4','how_to_do_4');
insert into tutorialitem(id,content,timestamp,description,heading) values('5','tutorial_content_5','2018-02-01 00:00:00','tutorial_description_5','how_to_do_5');
insert into tutorialitem(id,content,timestamp,description,heading) values('6','tutorial_content_6','2018-02-01 12:00:00','tutorial_description_6','how_to_do_6');
insert into tutorialitem(id,content,timestamp,description,heading) values('7','tutorial_content_7','2018-03-01 00:00:00','tutorial_description_7','how_to_do_7');
insert into tutorialitem(id,content,timestamp,description,heading) values('8','tutorial_content_8','2018-03-01 12:00:00','tutorial_description_8','how_to_do_8');
insert into tutorialitem(id,content,timestamp,description,heading) values('9','tutorial_content_9','2018-04-01 00:00:00','tutorial_description_9','how_to_do_9');
insert into tutorialitem(id,content,timestamp,description,heading) values('10','tutorial_content_10','2018-04-01 12:00:00','tutorial_description_10','how_to_do_10');

insert into blogtag_blogitem values('1','1'), ('1','2'),('2','1'),('2','3'),('2','5'),('1','4');

insert into tutorialtag_tutorialitem values('1','1'), ('1','2'),('2','1'),('2','3'),('2','5'),('1','4');


insert into workitem(id,link,timestamp,description,heading) values('1','work_link_1','2018-09-01 00:00:00','work_description_1','work_heading_1');
insert into workitem(id,link,timestamp,description,heading) values('2','work_link_2','2017-09-01 00:00:00','work_description_2','work_heading_2');
insert into workitem(id,link,timestamp,description,heading) values('3','work_link_3','2018-01-01 00:00:00','work_description_3','work_heading_3');