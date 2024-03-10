CREATE TABLE IF NOT EXISTS `users`
(
    `id`         bigint     NOT NULL AUTO_INCREMENT,
    `email`      varchar(25) NOT NULL,
    `nickname`   varchar(10) NOT NULL,
    `status`     varchar(10) NOT NULL,
    `created_at` datetime    NOT NULL,
    `updated_at` datetime    NOT NULL,
    PRIMARY KEY (`id`)
);

INSERT INTO `users` (`id`, `email`, `nickname`, `status`, `created_at`, `updated_at`)
VALUES (1, 'test@test.com', 'test', 'ACTIVE', now(), now());
