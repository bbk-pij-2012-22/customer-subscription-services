
INSERT INTO `tournament`(`tournament_id`, `tournament_name`, `start_date`) VALUES (1, 'Australian Open 2021', '2021-10-01');

INSERT INTO `player`(`player_id`, `player_name`) VALUES (1, 'K.Anderson');

INSERT INTO `player`(`player_id`, `player_name`) VALUES (2, 'M.Berrettini');

INSERT INTO `player`(`player_id`, `player_name`) VALUES (3, 'S.Querrey');

INSERT INTO `player`(`player_id`, `player_name`) VALUES (4, 'L.Sonego');

INSERT INTO `match_event`(`match_id`, `tournament_id`, start_date, player_a_id, player_b_id) VALUES (1, 1, '2021-02-08 14:00:00', 1, 2);

INSERT INTO `match_event`(`match_id`, `tournament_id`, start_date, player_a_id, player_b_id) VALUES (2, 1, '2021-02-09 16:30:00', 3, 4);

INSERT INTO `customer`(`customer_id`, `customer_name`) VALUES (1, 'Bet365');

INSERT INTO `customer`(`customer_id`, `customer_name`) VALUES (2, 'SkySports');

INSERT INTO `customer_match_licence`(`customer_match_licence_id`, `customer_id`, `match_id`) VALUES (1, 1, 1);

INSERT INTO `customer_match_licence`(`customer_match_licence_id`, `customer_id`, `match_id`) VALUES (2, 1, 2);