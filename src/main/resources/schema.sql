DROP TABLE IF EXISTS TBL_CARS;
  
CREATE TABLE TBL_CARS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  make VARCHAR(250) NOT NULL,
  model VARCHAR(250) NOT NULL,
  type VARCHAR(250) NOT NULL,
  variant VARCHAR(250) NOT NULL,
  fuel VARCHAR(250) NOT NULL,
  mfgyear VARCHAR(250) NOT NULL,
  color VARCHAR(250) NOT NULL
);