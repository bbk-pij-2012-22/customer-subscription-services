

DROP TABLE IF EXISTS `tournament`;
CREATE TABLE `tournament`(
    tournament_id BIGINT(20) UNSIGNED NOT NULL,
    tournament_name VARCHAR(200) NOT NULL,
    start_date TIMESTAMP NOT NULL,
    PRIMARY KEY (`tournament_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `player`;
CREATE TABLE `player`(
    player_id BIGINT(20) UNSIGNED NOT NULL,
    player_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (`player_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `match_event`;
CREATE TABLE `match_event`(
    match_id BIGINT(20) UNSIGNED NOT NULL,
    tournament_id BIGINT(20) UNSIGNED NOT NULL,
    start_date TIMESTAMP NOT NULL,
    player_a_id BIGINT(20) UNSIGNED NOT NULL,
    player_b_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`match_id`),
    CONSTRAINT `MFK1` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`),
    CONSTRAINT `MKFK2` FOREIGN KEY (`player_a_id`) REFERENCES `player` (`player_id`),
    CONSTRAINT `MKFK3` FOREIGN KEY (`player_b_id`) REFERENCES `player` (`player_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
    user_id BIGINT(20) UNSIGNED NOT NULL,
    username VARCHAR(200) NOT NULL,
    PRIMARY KEY (`user_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `user_match_licence`;
CREATE TABLE `user_match_licence`(
    user_match_licence_id BIGINT(20) UNSIGNED NOT NULL,
    user_id BIGINT(20) UNSIGNED NOT NULL,
    match_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`user_match_licence_id`),
    CONSTRAINT `UMLFK1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    CONSTRAINT `UMLFK2` FOREIGN KEY (`match_id`) REFERENCES `match_event` (`match_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `user_tournament_licence`;
CREATE TABLE `user_tournament_licence`(
    user_tournament_licence_id BIGINT(20) UNSIGNED NOT NULL,
    user_id BIGINT(20) UNSIGNED NOT NULL,
    tournament_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`user_tournament_licence_id`),
    CONSTRAINT `UTLFK1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
    CONSTRAINT `UTLFK2` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`)
) ENGINE = InnoDB;

