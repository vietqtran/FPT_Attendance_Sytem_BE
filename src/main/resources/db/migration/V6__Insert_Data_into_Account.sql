INSERT INTO fas.account (id, email, password, role_id, campus_id)
VALUES
    (UUID_TO_BIN(UUID()), 'manh@gmail.com', '$2a$10$GEQeoTQT0f4KGQtZrqk13.hy5vWwRhdPxMrYm.pYH8vvA/3XaMHBi', 1, 1),
    (UUID_TO_BIN(UUID()), 'dat@gmail.com', '$2a$10$iZAyic9Z/pe/NAKqP7mmveH7XnKvoMaPhse1oiBg6Y08N2mknTT6e', 2, 1),
    (UUID_TO_BIN(UUID()), 'cuong@gmail.com', '$2a$10$ZlrmgxkFTBCi2RbgN.AxZembDzoFbveU51/Tolvcr.fbxsjWIMh/e', 3, 1),
    (UUID_TO_BIN(UUID()), 'viet@gmail.com', '$2a$10$0FHtWVa.FgXYABMheN2zmuJ7eNRnouFYJs5OkKV8uUKIDYulXsOXq', 4, 1);
