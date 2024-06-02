DROP DATABASE biludlejning;
CREATE DATABASE IF NOT EXISTS Biludlejning;
USE Biludlejning;
CREATE TABLE IF NOT EXISTS Cars(
                                   vehicleNumber INT PRIMARY KEY AUTO_INCREMENT,
                                   model VARCHAR(255) NOT NULL,
                                   serialNumber INT NOT NULL,
                                   licensePlate VARCHAR(255) NOT NULL,
                                   brand VARCHAR(255) NOT NULL,
                                   vehiclestatus VARCHAR(255) NOT NULL,
                                   enviromentlabel CHAR NOT NULL,
                                   Car_year INT NOT NULL
);
CREATE TABLE IF NOT EXISTS RentalAgreements(
                                               RentalAgreement_ID INT PRIMARY KEY AUTO_INCREMENT,
                                               rental_type VARCHAR(255) NOT NULL,
                                               duration INT NOT NULL,
                                               price INT NOT NULL,
                                               car_id INT NOT NULL,
                                               customer_id INT NOT NULL,
                                               FOREIGN KEY (customer_id) REFERENCES customer(customer_id),
                                               FOREIGN KEY (car_id) REFERENCES Cars(vehicleNumber)
);
CREATE TABLE IF NOT EXISTS users(
                                    idusers INT PRIMARY KEY AUTO_INCREMENT,
                                    email VARCHAR(255) NOT NULL,
                                    username VARCHAR(255) NOT NULL,
                                    password VARCHAR(255) NOT NULL
);
INSERT INTO users (email, username, password) VALUES(
                                                        'bigman@hotmail.com', 'Denstoremand', 'bigbig23'
                                                    );
CREATE TABLE IF NOT EXISTS DamageReport (
                                            id INT AUTO_INCREMENT PRIMARY KEY,
                                            rentalAgreementId INT,
                                            damageDescription VARCHAR(255),
                                            price DOUBLE,
                                            FOREIGN KEY (rentalAgreementId) REFERENCES rentalagreements(RentalAgreement_ID) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS customer(
                                       customer_id INT PRIMARY KEY AUTO_INCREMENT,
                                       first_name VARCHAR(255),
                                       last_name VARCHAR(255),
                                       driverslicense_number INT
);



INSERT INTO Cars (model, serialNumber, licensePlate, brand, vehiclestatus, enviromentlabel, Car_year) VALUES
                                                                                                          ('Civic', 123456, 'ABC123', 'Honda', 'available', 'A', 2022),
                                                                                                          ('Accord', 234567, 'DEF456', 'Honda', 'available', 'B', 2021),
                                                                                                          ('Camry', 345678, 'GHI789', 'Toyota', 'available', 'C', 2023),
                                                                                                          ('Corolla', 456789, 'JKL012', 'Toyota', 'available', 'A', 2022),
                                                                                                          ('F-150', 567890, 'MNO345', 'Ford', 'available', 'B', 2022),
                                                                                                          ('Mustang', 678901, 'PQR678', 'Ford', 'available', 'C', 2021),
                                                                                                          ('C-Class', 789012, 'STU901', 'Mercedes-Benz', 'available', 'A', 2023),
                                                                                                          ('E-Class', 890123, 'VWX234', 'Mercedes-Benz', 'available', 'B', 2022),
                                                                                                          ('3 Series', 901234, 'YZA567', 'BMW', 'available', 'C', 2021),
                                                                                                          ('5 Series', 123401, 'BCD890', 'BMW', 'available', 'A', 2023),
                                                                                                          ('A3', 234012, 'EFG123', 'Audi', 'available', 'B', 2022),
                                                                                                          ('A6', 340123, 'HIJ456', 'Audi', 'available', 'C', 2021),
                                                                                                          ('Sonata', 401234, 'KLM789', 'Hyundai', 'available', 'A', 2022),
                                                                                                          ('Elantra', 512345, 'NOP012', 'Hyundai', 'available', 'B', 2023),
                                                                                                          ('Rogue', 601234, 'QRS345', 'Nissan', 'available', 'C', 2021),
                                                                                                          ('Altima', 712345, 'TUV678', 'Nissan', 'available', 'A', 2022),
                                                                                                          ('Cruze', 823456, 'WXY901', 'Chevrolet', 'available', 'B', 2023),
                                                                                                          ('Malibu', 934567, 'ZAB234', 'Chevrolet', 'available', 'C', 2022),
                                                                                                          ('Sentra', 401234, 'BCD567', 'Nissan', 'available', 'A', 2021),
                                                                                                          ('Maxima', 512345, 'EFG890', 'Nissan', 'available', 'B', 2023),
                                                                                                          ('Focus', 601234, 'HIJ123', 'Ford', 'available', 'C', 2022),
                                                                                                          ('Escape', 712345, 'KLM456', 'Ford', 'available', 'A', 2021),
                                                                                                          ('Tucson', 823456, 'NOP789', 'Hyundai', 'available', 'B', 2022),
                                                                                                          ('Santa Fe', 934567, 'QRS012', 'Hyundai', 'available', 'C', 2023),
                                                                                                          ('Optima', 401234, 'TUV345', 'Kia', 'available', 'A', 2021),
                                                                                                          ('Soul', 512345, 'WXY678', 'Kia', 'available', 'B', 2023),
                                                                                                          ('Fusion', 601234, 'ZAB901', 'Ford', 'available', 'C', 2022),
                                                                                                          ('Explorer', 712345, 'BCD234', 'Ford', 'available', 'A', 2021),
                                                                                                          ('Wrangler', 823456, 'EFG567', 'Jeep', 'available', 'B', 2023),
                                                                                                          ('Cherokee', 934567, 'HIJ890', 'Jeep', 'available', 'C', 2022),
                                                                                                          ('Impreza', 401234, 'KLM123', 'Subaru', 'available', 'A', 2021),
                                                                                                          ('Outback', 512345, 'NOP456', 'Subaru', 'available', 'B', 2022),
                                                                                                          ('Civic', 601234, 'QRS789', 'Honda', 'available', 'C', 2023),
                                                                                                          ('Pilot', 712345, 'TUV012', 'Honda', 'available', 'A', 2022),
                                                                                                          ('HR-V', 823456, 'WXY345', 'Honda', 'available', 'B', 2021),
                                                                                                          ('CR-V', 934567, 'ZAB678', 'Honda', 'available', 'C', 2023),
                                                                                                          ('Tacoma', 401234, 'BCD901', 'Toyota', 'available', 'A', 2022),
                                                                                                          ('Tundra', 512345, 'EFG234', 'Toyota', 'available', 'B', 2021),
                                                                                                          ('Q50', 601234, 'HIJ567', 'Infiniti', 'available', 'C', 2023),
                                                                                                          ('QX60', 712345, 'KLM890', 'Infiniti', 'available', 'A', 2022),
                                                                                                          ('G70', 823456, 'NOP123', 'Genesis', 'available', 'B', 2021),
                                                                                                          ('G80', 934567, 'QRS456', 'Genesis', 'available', 'C', 2023),
                                                                                                          ('Camaro', 401234, 'TUV789', 'Chevrolet', 'available', 'A', 2022),
                                                                                                          ('Equinox', 512345, 'WXY012', 'Chevrolet', 'available', 'B', 2021),
                                                                                                          ('Escape', 601234, 'ZAB345', 'Ford', 'available', 'C', 2023),
                                                                                                          ('F-150', 712345, 'BCD678', 'Ford', 'available', 'A', 2022),
                                                                                                          ('Tahoe', 823456, 'EFG901', 'Chevrolet', 'available', 'B', 2021),
                                                                                                          ('Suburban', 934567, 'HIJ234', 'Chevrolet', 'available', 'C', 2023);
