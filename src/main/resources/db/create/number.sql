CREATE TABLE `number`(
                         `id_number` INT NOT NULL AUTO_INCREMENT,
                         `id_contact` INT NOT NULL,
                         `phone_number` VARCHAR(13) NOT NULL,
                         PRIMARY KEY(`id_number`),
                         FOREIGN KEY(`id_contact`) REFERENCES `contact`(`id_contact`)
)