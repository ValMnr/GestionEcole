CREATE TABLE `Ecole` (
	`id_ecole` INT NOT NULL AUTO_INCREMENT,
	`nom_ecole` varchar(255) NOT NULL,
	PRIMARY KEY (`id_ecole`)
);

CREATE TABLE `AnneeScolaire` (
	`id` BINARY NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Trimestre` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`numero` INT NOT NULL,
	`debut` DATE NOT NULL,
	`fin` DATE NOT NULL,
	`anneescolaireId` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Niveau` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Classe` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	`ecoleId` INT NOT NULL,
	`niveauId` INT NOT NULL,
	`AnneeScolaireId` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Discipline` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Personne` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`nom` varchar(255) NOT NULL,
	`prenom` varchar(255) NOT NULL,
	`type` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Enseignement` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`ClasseId` INT NOT NULL,
	`DisciplineId` INT NOT NULL,
	`PersonneId` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Inscription` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`classeId` INT NOT NULL,
	`PersonneId` INT NOT NULL,
	PRIMARY KEY (`id`)
);


CREATE TABLE `Bulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`TrismestreId` INT NOT NULL,
	`InscriptionId` INT NOT NULL,
	`appreciation` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `DetailBulletin` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`BulletinId` INT NOT NULL,
	`EnseignementId` INT NOT NULL,
	`appreciation` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Evaluation` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`DetailBulletinId` INT NOT NULL,
	`note` INT NOT NULL,
	`appreciation` varchar(255) NOT NULL,
	PRIMARY KEY (`id`)
);
-- FOREIGN KEY : Trimestre
ALTER TABLE `AnneeScolaire` ADD CONSTRAINT `AnneeScolaire_fk0` FOREIGN KEY (`id`) REFERENCES `Trimestre`(`anneescolaireId`);

-- FOREIGN KEY : Classe
ALTER TABLE `Ecole` ADD CONSTRAINT `Ecole_fk0` FOREIGN KEY (`id_ecole`) REFERENCES `Classe`(`ecoleId`);

ALTER TABLE `Niveau` ADD CONSTRAINT `Niveau_fk0` FOREIGN KEY (`id`) REFERENCES `Classe`(`niveauId`);

ALTER TABLE `AnneeScolaire` ADD CONSTRAINT `AnneeScolaire_fk1` FOREIGN KEY (`id`) REFERENCES `Classe`(`AnneeScolaireId`);

-- FOREIGN KEY : Enseignement
ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk0` FOREIGN KEY (`id`) REFERENCES `Enseignement`(`classeId`);

ALTER TABLE `Discipline` ADD CONSTRAINT `Discipline_fk0` FOREIGN KEY (`id`) REFERENCES `Enseignement`(`disciplineId`);

ALTER TABLE `Personne` ADD CONSTRAINT `Personne_fk0` FOREIGN KEY (`id`) REFERENCES `Enseignement`(`PersonneId`);

-- FOREIGN KEY : Inscription
ALTER TABLE `Classe` ADD CONSTRAINT `Classe_fk1` FOREIGN KEY (`id`) REFERENCES `Inscription`(`classeId`);

ALTER TABLE `Personne` ADD CONSTRAINT `Personne_fk1` FOREIGN KEY (`id`) REFERENCES `Inscription`(`PersonneId`);

-- FOREIGN KEY : Bulletin
ALTER TABLE `Trimestre` ADD CONSTRAINT `Trimestre_fk0` FOREIGN KEY (`id`) REFERENCES `bulletin`(`trimestreId`);

ALTER TABLE `Inscription` ADD CONSTRAINT `Inscription_fk0` FOREIGN KEY (`id`) REFERENCES `Bulletin`(`InscriptionId`);

-- FOREIGN KEY : DétailBulletin
ALTER TABLE `Bulletin` ADD CONSTRAINT `Bulletin_fk0` FOREIGN KEY (`id`) REFERENCES `DetailBulletin`(`BulletinId`);

ALTER TABLE `Enseignement` ADD CONSTRAINT `Enseignement_fk0` FOREIGN KEY (`id`) REFERENCES `DetailBulletin`(`EnseignementId`);

-- FOREIGN KEY : Evaluation
ALTER TABLE `DetailBulletin` ADD CONSTRAINT `DetailBulletin_fk0` FOREIGN KEY (`id`) REFERENCES `Evaluation`(`DetailBulletinId`);
