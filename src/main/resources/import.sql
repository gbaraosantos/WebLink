/* Populate USER_PROFILE Table */
INSERT INTO UserProfile(type) VALUES ("User");
INSERT INTO UserProfile(type) VALUES ("Teacher");
INSERT INTO UserProfile(type) VALUES ("Coordinator");
INSERT INTO UserProfile(type) VALUES ("Admin");

/* Populate User Table */
INSERT INTO Users(name,avatarLocation, password,address , Nationality, email, state, dateBirth,postal1,postal2,regDate,lastChangeDate) VALUES ("Konkrets","/resources/images/Common/nopic.jpg","$2a$10$fH1P.ZgzBvvgA3imet1rYeuHCTRMsgtMnPRFe/xjzVCjBerlDLteO", "Lousa","Portuguese","konkrets@konkrets.com", "Active", DATE(now()),1991,234,DATE(now()),DATE(now()));

INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Admin";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Coordinator";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="Teacher";
INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="User";


INSERT INTO Course(creationDate,area, description,icon , lastChangeDate, name, numClasses, numberModules,price,reTryPrice,synch,tClass) VALUES (DATE(now()),"Informatica","Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem Ipsy Lorem ", "fa-key",DATE(now()),"App Development",7, 5, 60,20,"Synch",15);
INSERT INTO Action(creationDate,discount, endDate,finalPrice , lastChangeDate, startDate, visible, course_id) VALUES (DATE(now()),0,null, 60,DATE(now()),STR_TO_DATE('18-06-2017', '%d-%m-%Y'),false, 1);