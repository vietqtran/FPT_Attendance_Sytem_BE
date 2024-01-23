CREATE TABLE IF NOT EXISTS account (
     id VARBINARY(16) PRIMARY KEY,
     email VARCHAR(255),
     password VARCHAR(255),
     role_id INT,
     campus_id INT
);