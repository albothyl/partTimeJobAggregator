CREATE DATABASE partTimeJob DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'wowman'@'%' IDENTIFIED BY '1q2w3e!';

CREATE DATABASE sonar DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
CREATE USER 'sonar'@'%' IDENTIFIED BY 'sonar';

USE mysql;

-- DB 별 권한 부여
INSERT INTO db (HOST,Db,USER,Select_priv,Insert_priv,Update_priv,Delete_priv,Create_priv,Drop_priv,Index_priv, Alter_priv) VALUES('%','partTimeJob','wowman','Y','Y','Y','Y','Y','Y','Y','Y');
GRANT ALL PRIVILEGES ON *.* TO 'sonar'@'%';

-- 마무리.
FLUSH PRIVILEGES;