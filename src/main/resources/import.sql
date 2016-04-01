/* Populate USER_PROFILE Table */
INSERT INTO UserProfile(type) VALUES ("User");
INSERT INTO UserProfile(type) VALUES ("Teacher");
INSERT INTO UserProfile(type) VALUES ("Coordinator");
INSERT INTO UserProfile(type) VALUES ("Admin");

/* Populate User Table */
INSERT INTO Users(name,avatarLocation, password,address , Nationality, email, state, dateBirth,postal1,postal2,regDate,lastChangeDate) VALUES ("Konkrets, Lda","/home/filesystem/User/1/profilepic.jpg","$2a$10$fH1P.ZgzBvvgA3imet1rYeuHCTRMsgtMnPRFe/xjzVCjBerlDLteO", "Lousa","Portuguese","konkrets@konkrets.com", "Active", DATE(now()),1991,234,DATE(now()),DATE(now()));
INSERT INTO Users(name,avatarLocation, password,address , Nationality, email, state, dateBirth,postal1,postal2,regDate,lastChangeDate) VALUES ("Guilherme Santos","/home/filesystem/User/2/profilepic.jpg","$2a$10$fH1P.ZgzBvvgA3imet1rYeuHCTRMsgtMnPRFe/xjzVCjBerlDLteO", "Lousa","Portuguese","g.baraosantos@gmail.com", "Active", DATE(now()),1991,234,DATE(now()),DATE(now()));
INSERT INTO Users(name,avatarLocation, password,address , Nationality, email, state, dateBirth,postal1,postal2,regDate,lastChangeDate) VALUES ("John Doe","/resources/images/Common/nopic.jpg","$2a$10$fH1P.ZgzBvvgA3imet1rYeuHCTRMsgtMnPRFe/xjzVCjBerlDLteO", "Lousa","Portuguese","johnDoe@hotmail.com", "Active", DATE(now()),1991,234,DATE(now()),DATE(now()));


INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Admin";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Coordinator";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Teacher";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="User";

INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=2 and profile.type="Teacher";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=2 and profile.type="User";

INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=3 and profile.type="User";

INSERT INTO Course(creationDate,area, description,icon , lastChangeDate, name, price,reTryPrice,synch,tClass,createdBy) VALUES (DATE(now()),"Informatica","Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ", "fa-key",DATE(now()),"App Development", 60,20,"Synch",15,1);
INSERT INTO Course(creationDate,area, description,icon , lastChangeDate, name, price,reTryPrice,synch,tClass,createdBy) VALUES (DATE(now()),"Medicine","Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ", "fa-times",DATE(now()),"Dental", 60,20,"Synch",15,1);
INSERT INTO Course(creationDate,area, description,icon , lastChangeDate, name, price,reTryPrice,synch,tClass,createdBy) VALUES (DATE(now()),"Engineering","Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ", "fa-cog",DATE(now()),"Mechanics", 60,20,"Synch",15,1);
INSERT INTO Course(creationDate,area, description,icon , lastChangeDate, name, price,reTryPrice,synch,tClass,createdBy) VALUES (DATE(now()),"Engineering","Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ", "fa-cog",DATE(now()),"Civil", 60,20,"Synch",15,1);

INSERT INTO Action(creationDate,discount, endDate,finalPrice , lastChangeDate, startDate, visible, course_id, createdBy) VALUES (DATE(now()),0,null, 60,DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),false, 1,1);
INSERT INTO Action(creationDate,discount, endDate,finalPrice , lastChangeDate, startDate, visible, course_id, createdBy) VALUES (DATE(now()),0,null, 60,DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),false, 2,1);
INSERT INTO Action(creationDate,discount, endDate,finalPrice , lastChangeDate, startDate, visible, course_id, createdBy) VALUES (DATE(now()),0,null, 60,DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),false, 3,1);
INSERT INTO Action(creationDate,discount, endDate,finalPrice , lastChangeDate, startDate, visible, course_id, createdBy) VALUES (DATE(now()),0,null, 60,DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),false, 4,1);

INSERT INTO Module(startDate, creationDate, description,lastChangeDate,endDate, name, percentage,position,createdBy,course_id) VALUES (STR_TO_DATE('5-06-2017', '%d-%m-%Y'),DATE(now()),"Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ",DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),"Civil 1.0", 25, 1,1,4);
INSERT INTO Module(startDate, creationDate, description,lastChangeDate,endDate, name, percentage,position,createdBy,course_id) VALUES (STR_TO_DATE('20-06-2017', '%d-%m-%Y'),DATE(now()),"Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ",DATE(now()),STR_TO_DATE('25-06-2017', '%d-%m-%Y'),"Civil 2.0", 25, 2,1,4);


