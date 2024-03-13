CREATE TABLE `bankaccount` (
	`account_id` SERIAL NOT NULL COMMENT '会員IÐ',
	`user_name` VARCHAR(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '会員名',
	`password` TEXT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'パスワード',
	`balance` INT unsigned NOT NULL COMMENT '初期残高',
	`update_at` DATE NOT NULL COMMENT '更新日',
	`create_at` DATE NOT NULL COMMENT '作成日',
	PRIMARY KEY (`account_id`)
) ENGINE=InnoDB;