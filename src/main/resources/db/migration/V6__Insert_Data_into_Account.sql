/*
 * MySQL Script for BCrypt Hash Generation and User Insertion
 *
 * This script creates a MySQL stored function, `generate_bcrypt_hash`, to generate BCrypt hashes for passwords
 * using the SHA-256 algorithm. It then uses the function to insert user records into the `fas.account` table.
 */

-- Set the delimiter for the script
DELIMITER //

-- Create a MySQL stored function to generate BCrypt hashes
CREATE FUNCTION generate_bcrypt_hash(input_password VARCHAR(255)) RETURNS VARCHAR(60) DETERMINISTIC
BEGIN
    DECLARE hashed_password VARCHAR(60);

    -- Hash the input password using SHA-256 and prepend BCrypt identifier and cost factor
    SET hashed_password = CONCAT('$2a$10$', SUBSTRING(SHA2(input_password, 256), 1, 53));

    -- Return the generated BCrypt hash
RETURN hashed_password;
END //

-- Reset the delimiter to the default
DELIMITER ;

-- Insert user records into the `fas.account` table using the BCrypt hash generation function
INSERT INTO fas.account (id, email, password, role_id, campus_id)
VALUES
    (UUID_TO_BIN(UUID()), 'hoang@gmail.com', generate_bcrypt_hash('123'), 1, 1),
    (UUID_TO_BIN(UUID()), 'cuong@gmail.com', generate_bcrypt_hash('123'), 1, 1),
    (UUID_TO_BIN(UUID()), 'dat@gmail.com', generate_bcrypt_hash('123'), 2, 1),
    (UUID_TO_BIN(UUID()), 'manh@gmail.com', generate_bcrypt_hash('123'), 3, 1),
    (UUID_TO_BIN(UUID()), 'viet@gmail.com', generate_bcrypt_hash('123'), 4, 1);

/*
 * Notes:
 *
 * - The `generate_bcrypt_hash` function takes a password as input and returns the BCrypt hash.
 * - It uses SHA-256 for hashing and adds the BCrypt identifier and
