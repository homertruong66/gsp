SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` VARCHAR(50) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  `token` varchar(50),
  `created` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`)
);

INSERT INTO `users` VALUES (1, 'Homer', 'Truong', 'homer@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (2, 'Tri', 'Tran', 'tri@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (3, 'Tuan', 'Mac', 'tuan@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-07 23:16:05');
INSERT INTO `users` VALUES (4, 'Thuyen', 'Nguyen', 'thuyen@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-21 09:48:09');
INSERT INTO `users` VALUES (5, 'Sang', 'Cao', 'sang@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-21 09:48:37');
INSERT INTO `users` VALUES (6, 'Truc', 'Nguyen', 'truc@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-21 09:49:13');
INSERT INTO `users` VALUES (7, 'Cuong', 'Phan', 'cuong@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-21 09:49:50');
INSERT INTO `users` VALUES (8, 'Dung', 'Nguyen', 'dung@gsp.com', '12345678', 'ADMIN', NULL, '2019-11-21 09:50:21');

SET FOREIGN_KEY_CHECKS = 1;
