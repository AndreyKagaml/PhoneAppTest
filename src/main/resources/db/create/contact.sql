CREATE TABLE `contact`(
                          `id_contact` INT NOT NULL AUTO_INCREMENT,
                          `id_user` INT NOT NULL,
                          `name` VARCHAR(50) NOT NULL UNIQUE,
                          PRIMARY KEY(`id_contact`),
                          FOREIGN KEY(`id_user`) REFERENCES `user`(`id_user`)
)