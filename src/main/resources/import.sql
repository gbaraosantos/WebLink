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