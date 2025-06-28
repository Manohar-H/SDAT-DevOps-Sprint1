SET FOREIGN_KEY_CHECKS = 0;
DELETE FROM passenger_aircraft;
DELETE FROM aircraft_airport;
DELETE FROM aircraft;
DELETE FROM airport;
DELETE FROM passenger;
DELETE FROM city;
SET FOREIGN_KEY_CHECKS = 1;


-- Insert Cities
INSERT INTO city (id, name, state, population) VALUES (1, 'New York', 'NY', 8000000);
INSERT INTO city (id, name, state, population) VALUES (2, 'San Francisco', 'CA', 870000);

-- Insert Airports
INSERT INTO airport (id, name, code, city_id) VALUES (1, 'JFK International', 'JFK', 1);
INSERT INTO airport (id, name, code, city_id) VALUES (2, 'LaGuardia', 'LGA', 1);
INSERT INTO airport (id, name, code, city_id) VALUES (3, 'SFO International', 'SFO', 2);

-- Insert Passengers
INSERT INTO passenger (id, first_name, last_name, phone_number, city_id) 
VALUES (1, 'Alice', 'Johnson', '123-456-7890', 1);
INSERT INTO passenger (id, first_name, last_name, phone_number, city_id) 
VALUES (2, 'Bob', 'Smith', '987-654-3210', 2);

-- Insert Aircraft
INSERT INTO aircraft (id, type, airline_name, number_of_passengers) 
VALUES (1, 'Boeing 737', 'Delta', 200);
INSERT INTO aircraft (id, type, airline_name, number_of_passengers) 
VALUES (2, 'Airbus A320', 'United', 180);

-- Join tables
INSERT INTO passenger_aircraft (passenger_id, aircraft_id) VALUES (1, 1), (2, 2);
INSERT INTO passenger_airport (passenger_id, airport_id) VALUES (1, 1), (2, 2);
INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES (1, 1), (2, 2);
INSERT INTO aircraft_airport (aircraft_id, airport_id) VALUES (1, 1), (2, 2);