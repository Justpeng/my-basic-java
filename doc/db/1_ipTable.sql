# 创建ip表
use just_test;
create TABLE ip_table(
  id int(11) PRIMARY KEY ,
  ip VARCHAR(15),
  port VARCHAR(15),
  country VARCHAR(15),
  province VARCHAR(15),
  city VARCHAR(15),
  isp VARCHAR(15),
  findTime DATETIME
);

INSERT into ip_table VALUES (1,'111','8080','中国','广东','东莞','电信','2016-06-08 23:53:17');
INSERT into ip_table VALUES (2,'122','8080','中国','广东','东莞','电信','2016-06-08 23:53:17');
INSERT into ip_table VALUES (3,'133','8080','中国','北京','朝阳','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (4,'144','8080','中国','北京','朝阳','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (5,'155','8080','中国','北京','朝阳','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (6,'166','8080','中国','北京','朝阳','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (7,'177','8080','中国','北京','海淀','联通','2016-06-08 23:53:17');
INSERT into ip_table VALUES (8,'188','8080','中国','北京','海淀','联通','2016-06-08 23:53:17');
INSERT into ip_table VALUES (9,'199','8080','中国','河北','石家庄','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (10,'221','8080','中国','河北','石家庄','联通','2016-06-08 23:53:17');
INSERT into ip_table VALUES (11,'231','8080','中国','河北','石家庄','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (12,'241','8080','中国','河北','石家庄','联通','2016-06-08 23:53:17');
INSERT into ip_table VALUES (13,'251','8080','中国','河北','石家庄','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (14,'261','8080','中国','河北','石家庄','移动','2016-06-08 23:53:17');
INSERT into ip_table VALUES (15,'271','8080','中国','山东','青岛','联通','2016-06-08 23:53:17');
INSERT into ip_table VALUES (16,'281','8080','中国','山西','太原','电信','2016-06-08 23:53:17');
INSERT INTO ip_table VALUES (17, '282', '8080', '中国', '山西', '太原', '电信', '2016-06-08 23:53:17');
INSERT INTO ip_table VALUES (18, '284', '8080', '中国', '山西', '太原', '电信', '2016-06-08 23:53:17');

