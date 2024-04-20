CREATE TABLE IF NOT EXISTS Brands (
    ID_brand INT Auto_Increment PRIMARY KEY,
    brand_name VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Models(
    ID_model INT Auto_Increment PRIMARY KEY,
    brand_id INT NOT NULL,
    model_name VARCHAR(35) NOT NULL UNIQUE,

    FOREIGN KEY (brand_id) REFERENCES Brands(ID_brand)
);

CREATE TABLE IF NOT EXISTS Transmissions(
    ID_transmission INT Auto_Increment PRIMARY KEY,
    type VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Fuel_Types(
    ID_fuel_type INT Auto_Increment PRIMARY KEY,
    type VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS  Colors(
    ID_color INT Auto_Increment PRIMARY KEY,
    color VARCHAR(15) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Cars(
    ID_car INT Auto_Increment Primary Key,
    VIN VARCHAR(17) NOT NULL UNIQUE,
    model_id INT NOT NULL,
    transmission_id INT NOT NULL,
    fuel_type_id INT NOT NULL,
    interior_color_id INT NOT NULL,
    exterior_color_id INT NOT NULL,
    number_of_doors INT NOT NULL,
    mileage INT NOT NULL,
    year_of_production INT NOT NULL,
    description TEXT,
    price DECIMAL(10,2) NOT NULL,


    FOREIGN KEY (model_id) REFERENCES Models(ID_model),
    FOREIGN KEY (transmission_id) REFERENCES Transmissions(ID_transmission),
    FOREIGN KEY (fuel_type_id) REFERENCES Fuel_Types(ID_fuel_type),
    FOREIGN KEY (interior_color_id) REFERENCES Colors(ID_color),
    FOREIGN KEY (exterior_color_id) REFERENCES Colors(ID_color)
);

CREATE TABLE IF NOT EXISTS Features(
    ID_feature INT Auto_Increment PRIMARY KEY,
    feature VARCHAR(35) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS Cars_Features(
    ID_car_feature INT Auto_Increment PRIMARY KEY,
    car_id INT NOT NULL,
    feature_id INT NOT NULL,

    FOREIGN KEY (car_id) REFERENCES Cars(ID_car),
    FOREIGN KEY (feature_id) REFERENCES Features(ID_feature)
);

CREATE TABLE IF NOT EXISTS Images(
    ID_image INT Auto_Increment PRIMARY KEY,
    car_id INT NOT NULL,
    image_name VARCHAR(35) NOT NULL,
    image_type VARCHAR(15) NOT NULL,
    image_path VARCHAR(255) NOT NULL,
    image BLOB,

    FOREIGN KEY (car_id) REFERENCES Cars(ID_car)
);
--Тази таблица е само за тестване
CREATE TABLE IF NOT EXISTS Testing(
    ID INT Auto_Increment PRIMARY KEY,
    name VARCHAR(35),
    type VARCHAR(15),
    path VARCHAR(255),
    url VARCHAR(255),
    image BLOB

);