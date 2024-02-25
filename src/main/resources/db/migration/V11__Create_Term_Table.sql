CREATE TABLE IF NOT EXISTS term (
                                    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255),
    start_at TIMESTAMP,
    end_at TIMESTAMP,
    status BOOLEAN,
    create_at TIMESTAMP,
    update_at TIMESTAMP
    );