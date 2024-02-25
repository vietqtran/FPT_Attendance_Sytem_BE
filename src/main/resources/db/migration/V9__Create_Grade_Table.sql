CREATE TABLE IF NOT EXISTS Grade (
    id BINARY(16) PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,
    campus_id BIGINT,
    major_id BINARY(16)
);
