DROP TABLE IF EXISTS poll_service;


CREATE TABLE poll_service (
    customer_id int(11) unsigned NOT NULL,
    first_question varchar(300) NOT NULL DEFAULT '',
    second_question varchar(300) NOT NULL DEFAULT '',
    third_question varchar(300) NOT NULL DEFAULT '',
    fourth_question varchar(300) NOT NULL DEFAULT '',
    PRIMARY KEY (customer_id)
    );

