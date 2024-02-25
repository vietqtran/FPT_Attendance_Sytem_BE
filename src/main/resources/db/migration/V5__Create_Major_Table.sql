CREATE TABLE IF NOT EXISTS major (
    id BINARY(16) PRIMARY KEY,
    code VARCHAR(255),
    name VARCHAR(255),
    status BOOLEAN,
    create_at DATETIME,
    update_at DATETIME
);
