CREATE DATABASE mailsystem;

CREATE TABLE users (
                                  id SERIAL PRIMARY KEY,
                                  firstname VARCHAR(255),
                                  lastname VARCHAR(255),
                                  password VARCHAR(255),
                                  company VARCHAR(255),
                                  department VARCHAR(255),
                                  email_company VARCHAR(255),
                                  second_email VARCHAR(255),
                                  sms_number VARCHAR(20)
);