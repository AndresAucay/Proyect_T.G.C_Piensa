CREATE TABLE IF NOT EXISTS dayli_entry (
    id SERIAL,
    user_id VARCHAR(100) NOT NULL,
    register_id VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS _user (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password INT NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS register (
    id SERIAL,
    garbage_cans_id VARCHAR(100) NOT NULL,
    personal_id VARCHAR(100) NOT NULL,
    date_hour INT NOT NULL,
    client_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (garbage_cans_id) REFERENCES garbage_cans_id,
    FOREIGN KEY (personal_id) REFERENCES personal_id
    );
CREATE TABLE IF NOT EXISTS personal (
    id SERIAL,
    fullname VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );
CREATE TABLE IF NOT EXISTS garbage_cans (
    id SERIAL,
    code_text VARCHAR(100) NOT NULL,
    location VARCHAR(100) NOT NULL,
    last_emptying VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
    );