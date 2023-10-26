#DATABASE:

drop database if exists school;
use school;

drop table if exists users;
drop table if exists authorities;

create table users(
	id int not null auto_increment primary key,
    username varchar(100) not null,
    password varchar(255) not null
);

create table authorities(
	id int not null auto_increment primary key,
    name varchar(45) not null,
    user int not null
);

INSERT IGNORE INTO users VALUES(NULL, 'admin', '$2a$10$SlibA2mjUye1dqOSCnC39ejiX/U/1TRpFxfP2iddCSbr68QUtIx3O');
INSERT IGNORE INTO authorities VALUES(NULL, 'READ', 1);
INSERT IGNORE INTO authorities VALUES(NULL, 'WRITE', 1);
INSERT IGNORE INTO authorities VALUES(NULL, 'READ', 2);
INSERT IGNORE INTO authorities VALUES(NULL, 'WRITE', 2);
