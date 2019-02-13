CREATE SEQUENCE USER_ID;
CREATE SEQUENCE QUESTION_ID;
CREATE SEQUENCE ANSWER_ID;
CREATE SEQUENCE COMMENT_ID;
CREATE TABLE USER_PROFILE (
    user_id BIGINT DEFAULT nextval('USER_ID'),
    mail_address TEXT,
    password TEXT,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    image_name TEXT,
    role VARCHAR(20),
    PRIMARY KEY(user_id)
);
CREATE TABLE QUESTION (
    question_id BIGINT DEFAULT nextval('QUESTION_ID'),
    title TEXT,
    content TEXT,
    create_time TIMESTAMP,
    update_time TIMESTAMP,
    create_user_id BIGINT,
    PRIMARY KEY(question_id)
);
CREATE TABLE ANSWER (
    answer_id BIGINT DEFAULT nextval('ANSWER_ID'),
    content TEXT,
    create_time TIMESTAMP,
    update_time TIMESTAMP,
    create_user_id BIGINT,
    question_id BIGINT,
    PRIMARY KEY(answer_id)
);
CREATE TABLE COMMENT (
    comment_id BIGINT DEFAULT nextval('COMMENT_ID'),
    content TEXT,
    create_time TIMESTAMP,
    update_time TIMESTAMP,
    comment_type INTEGER,
    create_user_id BIGINT,
    parent_id BIGINT,
    PRIMARY KEY(comment_id)
);