CREATE TABLE Role (
     id int,
     role_name varchar(50),
     created_date timestamp,
     updated_date timestamp,
     PRIMARY KEY (id)
);

CREATE TABLE User(
    id int PRIMARY KEY AUTO_INCREMENT,
    username varchar(100) NOT NULL,
    email varchar(255) NOT NULL,
    password varchar(255) NOT NULL,
    is_active boolean NOT NULL,
    created_date timestamp,
    updated_date timestamp,
    img_link varchar(255) NOT NULL,
    role_id int NOT NULL,
    FOREIGN KEY (role_id) REFERENCES Role(id)
)

