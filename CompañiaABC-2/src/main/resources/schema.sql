DROP TABLE IF EXISTS `users`
CREATE TABLE `users`
(
    idUser  VARCHAR(100) NOT NULL,
    name VARCHAR(100)NOT NULL,
    email VARCHAR(100) NULL,
    password TEXT NOT NULL,
    date_Created TIMESTAMP,
    PRIMARY KEY (idUser)
);

DROP TABLE IF EXISTS `campaing`
CREATE TABLE `campaing`
(
    idcampaing INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    idUser  VARCHAR(100) NULL,
    subject VARCHAR(200) NULL,
    numberOfRecipients INT,
    status BOOLEAN,
    date_Created TIMESTAMP,
);