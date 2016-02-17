/* Populate USER_PROFILE Table */
INSERT INTO UserProfile(type) VALUES ("User");
INSERT INTO UserProfile(type) VALUES ("Teacher");
INSERT INTO UserProfile(type) VALUES ("Coordinator");
INSERT INTO UserProfile(type) VALUES ("Admin");

/* Populate User Table */
INSERT INTO Users(name, password,address , Nationality, email, state, dateBirth,postal1,postal2,avatarLocation,regDate,lastChangeDate) VALUES ("Konkrets","konkrets123", "Lousa","Portuguese","konkrets@konkrets.com", "Active", DATE(now()),1991,234,null,DATE(now()),DATE(now()));

INSERT INTO UserPermissions (userID, ProfileID) SELECT user.id, profile.id FROM Users user, UserProfile profile where user.id=1 and profile.type="User"