CREATE TABLE IF NOT EXISTS `form_pregnancycdss_diseases` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dis_name` varchar(100) COLLATE utf8_general_ci DEFAULT NULL,
  `dis_note` varchar(255) COLLATE utf8_general_ci DEFAULT NULL,
  `dos_icd10` varchar(255) COLLATE utf8_general_ci DEFAULT NULL,
  `p` float DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci AUTO_INCREMENT=3 ;

