INSERT INTO users(id, name, birth_date)
VALUES (1001, 'fatiq', CURRENT_DATE());

INSERT INTO users(id, name, birth_date)
VALUES (1002, 'ali', CURRENT_DATE());

INSERT INTO users(id, name, birth_date)
VALUES (1003, 'muhammad', CURRENT_DATE());


INSERT INTO post(id, user_id, description)
VALUES (2001, 1001, 'I want to learn AWS');

INSERT INTO post(id, user_id, description)
VALUES (2002, 1001, 'I want to learn Azure');

INSERT INTO post(id, user_id, description)
VALUES (2003, 1002, 'I want to learn Devops');

INSERT INTO post(id, user_id, description)
VALUES (2004, 1003, 'I want to learn AWS');
