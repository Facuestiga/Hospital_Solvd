-- MySQL Workbench Synchronization
-- Generated: 2022-09-15 10:09
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Facu

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

ALTER SCHEMA `mydb`  DEFAULT CHARACTER SET utf8  DEFAULT COLLATE utf8_general_ci ;

ALTER TABLE `mydb`.`Patients` 
DROP FOREIGN KEY `fk_Patients_Doctors1`,
DROP FOREIGN KEY `fk_Patients_Medicines1`,
DROP FOREIGN KEY `fk_patients_social_services1`;

ALTER TABLE `mydb`.`Doctors` 
DROP FOREIGN KEY `fk_doctors_specialties1`;

ALTER TABLE `mydb`.`Medical_histories` 
DROP FOREIGN KEY `fk_Medical_histories_Patients1`;

ALTER TABLE `mydb`.`Payments` 
DROP FOREIGN KEY `fk_payment_medical_history1`,
DROP FOREIGN KEY `patients_id`;

ALTER TABLE `mydb`.`Ambulances` 
DROP FOREIGN KEY `fk_ambulances_drivers1`,
DROP FOREIGN KEY `fk_Ambulances_Patients1`;

ALTER TABLE `mydb`.`Areas` 
DROP FOREIGN KEY `fk_areas_specialty1`;

ALTER TABLE `mydb`.`Nurses` 
DROP FOREIGN KEY `fk_nurses_doctors1`;

ALTER TABLE `mydb`.`Nurse_has_areas` 
DROP FOREIGN KEY `fk_nurse_has_areas_areas1`;

ALTER TABLE `mydb`.`Beds` 
DROP FOREIGN KEY `fk_Beds_Patients1`;

ALTER TABLE `mydb`.`Doctors_has_payments` 
DROP FOREIGN KEY `fk_doctors_has_payments_doctors1`,
DROP FOREIGN KEY `fk_doctors_has_payments_payments1`;

ALTER TABLE `mydb`.`Nurses_has_rooms` 
DROP FOREIGN KEY `fk_nurses_has_rooms_nurses1`,
DROP FOREIGN KEY `fk_nurses_has_rooms_rooms1`;

ALTER TABLE `mydb`.`Travels` 
DROP FOREIGN KEY `fk_travels_patients1`;

ALTER TABLE `mydb`.`Users` 
DROP FOREIGN KEY `fk_users_payments1`;

ALTER TABLE `mydb`.`Travels_has_ambulances` 
DROP FOREIGN KEY `fk_travels_has_ambulances_ambulances1`;

ALTER TABLE `mydb`.`Doctor_licenses` 
DROP FOREIGN KEY `fk_Doctor_licenses_Doctors1`;

ALTER TABLE `mydb`.`Medicines_has_Payments` 
DROP FOREIGN KEY `fk_Medicines_has_Payments_Medicines1`,
DROP FOREIGN KEY `fk_Medicines_has_Payments_Payments1`;

ALTER TABLE `mydb`.`Prescriptions` 
DROP FOREIGN KEY `fk_Prescriptions_Doctors1`;

ALTER TABLE `mydb`.`Patients` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `weight` `weight` DECIMAL(2) NOT NULL ,
CHANGE COLUMN `height` `height` DECIMAL(2) NOT NULL ,
DROP INDEX `fk_patients_social_services1_idx` ;
;

ALTER TABLE `mydb`.`Doctors` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Medical_histories` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Payments` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
CHANGE COLUMN `price` `price` DECIMAL(2) NOT NULL ;

ALTER TABLE `mydb`.`Ambulances` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Drivers` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Specialties` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Areas` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Nurses` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Nurse_has_areas` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Beds` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Doctors_has_payments` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Nurses_has_rooms` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Travels` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Users` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Users_types` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Travels_has_ambulances` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Doctor_licenses` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Medicines` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Medicines_has_Payments` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ;

ALTER TABLE `mydb`.`Prescriptions` 
CHARACTER SET = utf8 , COLLATE = utf8_general_ci ,
ADD COLUMN `Medical_histories_id` INT(11) NOT NULL AFTER `Doctors_id`,
ADD INDEX `fk_Prescriptions_Medical_histories1_idx` (`Medical_histories_id` ASC) VISIBLE;
;

DROP TABLE IF EXISTS `mydb`.`welfare_works_has_social_services` ;

DROP TABLE IF EXISTS `mydb`.`social_services` ;

ALTER TABLE `mydb`.`Patients` 
DROP FOREIGN KEY `fk_patients_rooms1`;

ALTER TABLE `mydb`.`Patients` ADD CONSTRAINT `fk_patients_rooms1`
  FOREIGN KEY (`rooms_id`)
  REFERENCES `mydb`.`Rooms` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Patients_Doctors1`
  FOREIGN KEY (`doctors_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Patients_Medicines1`
  FOREIGN KEY (`Medicines_id`)
  REFERENCES `mydb`.`Medicines` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Doctors` 
DROP FOREIGN KEY `fk_doctors_welfare_works1`;

ALTER TABLE `mydb`.`Doctors` ADD CONSTRAINT `fk_doctors_welfare_works1`
  FOREIGN KEY (`welfare_works_id`)
  REFERENCES `mydb`.`Welfare_works` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_doctors_specialties1`
  FOREIGN KEY (`specialties_id`)
  REFERENCES `mydb`.`Specialties` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Medical_histories` 
DROP FOREIGN KEY `fk_medical_history_doctor1`;

ALTER TABLE `mydb`.`Medical_histories` ADD CONSTRAINT `fk_medical_history_doctor1`
  FOREIGN KEY (`doctor_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Medical_histories_Patients1`
  FOREIGN KEY (`Patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Payments` 
ADD CONSTRAINT `fk_payment_medical_history1`
  FOREIGN KEY (`medical_history_id`)
  REFERENCES `mydb`.`Medical_histories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `patients_id`
  FOREIGN KEY (`patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Ambulances` 
ADD CONSTRAINT `fk_ambulances_drivers1`
  FOREIGN KEY (`drivers_id1`)
  REFERENCES `mydb`.`Drivers` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Ambulances_Patients1`
  FOREIGN KEY (`Patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE RESTRICT
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Areas` 
ADD CONSTRAINT `fk_areas_specialty1`
  FOREIGN KEY (`specialty_id`)
  REFERENCES `mydb`.`Specialties` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Nurses` 
ADD CONSTRAINT `fk_nurses_doctors1`
  FOREIGN KEY (`doctors_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Nurse_has_areas` 
DROP FOREIGN KEY `fk_nurse_has_areas_nurse`;

ALTER TABLE `mydb`.`Nurse_has_areas` ADD CONSTRAINT `fk_nurse_has_areas_nurse`
  FOREIGN KEY (`nurse_id`)
  REFERENCES `mydb`.`Nurses` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_nurse_has_areas_areas1`
  FOREIGN KEY (`areas_id`)
  REFERENCES `mydb`.`Areas` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Beds` 
DROP FOREIGN KEY `fk_beds_rooms1`;

ALTER TABLE `mydb`.`Beds` ADD CONSTRAINT `fk_beds_rooms1`
  FOREIGN KEY (`rooms_id`)
  REFERENCES `mydb`.`Rooms` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Beds_Patients1`
  FOREIGN KEY (`patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Doctors_has_payments` 
ADD CONSTRAINT `fk_doctors_has_payments_doctors1`
  FOREIGN KEY (`doctors_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_doctors_has_payments_payments1`
  FOREIGN KEY (`payments_id`)
  REFERENCES `mydb`.`Payments` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Nurses_has_rooms` 
ADD CONSTRAINT `fk_nurses_has_rooms_nurses1`
  FOREIGN KEY (`nurses_id`)
  REFERENCES `mydb`.`Nurses` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_nurses_has_rooms_rooms1`
  FOREIGN KEY (`rooms_id`)
  REFERENCES `mydb`.`Rooms` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Travels` 
ADD CONSTRAINT `fk_travels_patients1`
  FOREIGN KEY (`patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Users` 
DROP FOREIGN KEY `fk_users_users_types1`;

ALTER TABLE `mydb`.`Users` ADD CONSTRAINT `fk_users_users_types1`
  FOREIGN KEY (`users_types_id`)
  REFERENCES `mydb`.`Users_types` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_users_payments1`
  FOREIGN KEY (`payments_id`)
  REFERENCES `mydb`.`Payments` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Travels_has_ambulances` 
DROP FOREIGN KEY `fk_travels_has_ambulances_travels1`;

ALTER TABLE `mydb`.`Travels_has_ambulances` ADD CONSTRAINT `fk_travels_has_ambulances_travels1`
  FOREIGN KEY (`travels_id`)
  REFERENCES `mydb`.`Travels` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_travels_has_ambulances_ambulances1`
  FOREIGN KEY (`ambulances_id`)
  REFERENCES `mydb`.`Ambulances` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Doctor_licenses` 
ADD CONSTRAINT `fk_Doctor_licenses_Doctors1`
  FOREIGN KEY (`Doctors_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Medicines_has_Payments` 
ADD CONSTRAINT `fk_Medicines_has_Payments_Medicines1`
  FOREIGN KEY (`medicines_id`)
  REFERENCES `mydb`.`Medicines` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Medicines_has_Payments_Payments1`
  FOREIGN KEY (`payments_id`)
  REFERENCES `mydb`.`Payments` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `mydb`.`Prescriptions` 
DROP FOREIGN KEY `fk_Prescriptions_Patients1`;

ALTER TABLE `mydb`.`Prescriptions` ADD CONSTRAINT `fk_Prescriptions_Patients1`
  FOREIGN KEY (`Patients_id`)
  REFERENCES `mydb`.`Patients` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Prescriptions_Doctors1`
  FOREIGN KEY (`Doctors_id`)
  REFERENCES `mydb`.`Doctors` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_Prescriptions_Medical_histories1`
  FOREIGN KEY (`Medical_histories_id`)
  REFERENCES `mydb`.`Medical_histories` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
