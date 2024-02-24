CREATE TABLE IF NOT EXISTS course
(
    id          BINARY(16) PRIMARY KEY,
    code        VARCHAR(255),
    name        VARCHAR(255),
    description VARCHAR(255),
    no_credit   INT,
    status      BOOLEAN ,
    create_at   DATETIME,
    update_at   DATETIME
);
