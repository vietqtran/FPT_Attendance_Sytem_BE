CREATE TABLE IF NOT EXISTS Grade (
                                     id BINARY(16) PRIMARY KEY,
    code VARCHAR(255) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    createdAt DATETIME NOT NULL,
    updatedAt DATETIME NOT NULL
    );
