CREATE TABLE app_user (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  first_name VARCHAR(250),
  last_name VARCHAR(250),
  company_name VARCHAR(250),
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL
);