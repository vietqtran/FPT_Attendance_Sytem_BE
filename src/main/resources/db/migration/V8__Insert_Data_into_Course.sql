INSERT INTO course (id, code, name, description, no_credit, status, created_at, updated_at)
VALUES
    (UUID_TO_BIN('a82586a3-d07d-11ee-a242-106530543950'), 'CSE101', 'Introduction to Computer Science',
     'A beginner course covering basic concepts of computer science', 3, true, CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),
    (UUID_TO_BIN('52d25e1b-d087-11ee-a242-106530543950'), 'MAT202', 'Advanced Mathematics',
     'An advanced course covering complex mathematical concepts', 4, true, CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),
    (UUID_TO_BIN('5be141b6-d087-11ee-a242-106530543950'), 'PHY303', 'Quantum Physics',
     'A course delving into the principles of quantum mechanics', 5, true, CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),
    (UUID_TO_BIN('663fe3e3-d087-11ee-a242-106530543950'), 'ENG201', 'English Literature',
     'A course exploring classic and contemporary works of English literature', 3, true, CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP),
    (UUID_TO_BIN('6d588124-d087-11ee-a242-106530543950'), 'HIS101', 'World History',
     'A comprehensive survey of major historical events and civilizations', 4, true, CURRENT_TIMESTAMP,
     CURRENT_TIMESTAMP);

