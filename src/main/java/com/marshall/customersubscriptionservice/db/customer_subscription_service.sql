

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
    CONSTRAINT `MEK1` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`),
    CONSTRAINT `MEFK2` FOREIGN KEY (`player_a_id`) REFERENCES `player` (`player_id`),
    CONSTRAINT `MEFK3` FOREIGN KEY (`player_b_id`) REFERENCES `player` (`player_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`(
    customer_id BIGINT(20) UNSIGNED NOT NULL,
    customer_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (`customer_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `customer_match_licence`;
CREATE TABLE `customer_match_licence`(
    customer_match_licence_id BIGINT(20) UNSIGNED NOT NULL,
    customer_id BIGINT(20) UNSIGNED NOT NULL,
    match_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`customer_match_licence_id`),
    CONSTRAINT `UMLFK1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
    CONSTRAINT `UMLFK2` FOREIGN KEY (`match_id`) REFERENCES `match_event` (`match_id`)
) ENGINE = InnoDB;

DROP TABLE IF EXISTS `customer_tournament_licence`;
CREATE TABLE `customer_tournament_licence`(
    customer_tournament_licence_id BIGINT(20) UNSIGNED NOT NULL,
    customer_id BIGINT(20) UNSIGNED NOT NULL,
    tournament_id BIGINT(20) UNSIGNED NOT NULL,
    PRIMARY KEY (`customer_tournament_licence_id`),
    CONSTRAINT `UTLFK1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`customer_id`),
    CONSTRAINT `UTLFK2` FOREIGN KEY (`tournament_id`) REFERENCES `tournament` (`tournament_id`)
) ENGINE = InnoDB;

