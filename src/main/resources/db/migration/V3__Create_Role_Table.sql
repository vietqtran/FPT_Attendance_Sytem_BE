-- Create Role table
CREATE TABLE IF NOT EXISTS role (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(255) NOT NULL,
    create_at DATETIME NOT NULL,
    update_at DATETIME NOT NULL
);
