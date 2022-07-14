CREATE TABLE `rule` (
    `id` bigint (20) NOT NULL,
    `code` varchar(64),
    `name` varchar(32) NOT NULL,
    `description` varchar(128),
    `type` varchar(32) NOT NULL,
    `condition` TEXT,
    `calculator` TEXT,
    `active` tinyint (1)NOT NULL DEFAULT 1,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;