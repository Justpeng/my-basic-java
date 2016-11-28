USE test;
DROP TABLE  testint;
CREATE TABLE testint (
  tiny TINYINT,
  small SMALLINT,
  mediu MEDIUMINT,
  intt INT,
  bigi BIGINT,
  id1 INT(6),
  id2 INT(6) ZEROFILL
);
INSERT  INTO testint VALUES (123,123,123,123,123,123,123);

SELECT  * from testint;

use test;
CREATE TABLE testfloat(
  id1 FLOAT(4,2),
  id2 DOUBLE(4,2),
  id3 DECIMAL(4,2),
  id4 BOOL
);
INSERT  INTO testfloat VALUES (99,12.22,12.25,true);
INSERT  INTO testfloat VALUES (99,12.22,12.25,FALSE );
SELECT * from testfloat;


use test;
show TABLES  from test;

create table teststr(
 id  char(12),
 genger  ENUM('m','f'),
 sets  SET('A','B','C','D')
);
INSERT  INTO teststr VALUES('FAF','M','a,b,c');
select * from teststr;

create table testdate(
  birthday DATE,
  birthday1 TIMESTAMP,
  birthday2 DATETIME,
  birthday3 TIMESTAMP
);
INSERT  INTO testdate VALUES ('20150101','20150101','20150101','20150101');
INSERT  INTO testdate VALUES ('2015-01-01','20150101','20150101',null);
SELECT * from testdate;










