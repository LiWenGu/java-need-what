CREATE TABLE IF NOT EXISTS `job_desc` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `title` varchar (128) NOT NULL,
  `salary` varchar(16) NOT NULL,
  `city` varchar(128) NOT NULL,
  `require` varchar(2048)NOT NULL,
  `source` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;