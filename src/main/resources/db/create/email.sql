CREATE TABLE `emails`(
                         `id_email` INT NOT NULL AUTO_INCREMENT,
                         `id_contact` INT NOT NULL,
                         `email` VARCHAR(100) NOT NULL,
                         PRIMARY KEY(`id_email`),
                         FOREIGN KEY(`id_contact`) REFERENCES `contact`(`id_contact`)
)