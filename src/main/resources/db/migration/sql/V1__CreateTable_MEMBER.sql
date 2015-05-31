USE parttimejob;

CREATE TABLE `member` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '회원 시퀀스 ID',
  `email` varchar(60) COLLATE utf8_bin NOT NULL COMMENT '회원 email계정',
  `password` varchar(60) COLLATE utf8_bin NOT NULL COMMENT '회원 비밀번호',
  `name` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '회원 이름',
  `nickName` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '회원 별명',
  `grade` varchar(10) COLLATE utf8_bin NOT NULL COMMENT '회원 등급',
  `updatedAt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '회원 정보 수정일시',
  `registedAt` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '회원 등록일시',
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `nick_name_UNIQUE` (`nick_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

