CREATE TABLE `user` (
  `id` mediumint(9) NOT NULL AUTO_INCREMENT,
  `isAdmin` bit(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `createdDate` timestamp NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO test.user (id, isAdmin, age, createdDate, name) VALUES (2, false, 2, '2016-02-16 15:18:30', 'user2');
INSERT INTO test.user (id, isAdmin, age, createdDate, name) VALUES (5, true, 33, '2016-02-16 15:27:25', 'user3');
INSERT INTO test.user (id, isAdmin, age, createdDate, name) VALUES (6, null, 11, '2016-02-15 14:18:46', 'user1');
INSERT INTO test.user (id, isAdmin, age, createdDate, name) VALUES (9, true, 25, '2016-02-15 14:35:08', 'user5');
INSERT INTO test.user (id, isAdmin, age, createdDate, name) VALUES (10, true, 44, '2016-02-16 15:26:37', 'user4');
