BEGIN
USE Airport;

INSERT INTO cities (city, state, code) VALUES ("Charlotte", "NC", "CLT");
INSERT INTO cities (city, state, code) VALUES ("Indianapolis", "IN", "IND");
INSERT INTO cities (city, state, code) VALUES ("Los Angeles", "CA", "LAX");
INSERT INTO cities (city, state, code) VALUES ("Detroit", "MI", "DTW");
INSERT INTO cities (city, state, code) VALUES ("New York", "NY", "JFK");
INSERT INTO cities (city, state, code) VALUES ("San Francisco", "CA", "SFO");
INSERT INTO cities (city, state, code) VALUES ("Chicago", "IL", "ORD");
INSERT INTO cities (city, state, code) VALUES ("Salt Lake City", "UT", "SLC");
INSERT INTO cities (city, state, code) VALUES ("Houston", "TX", "IAH");
INSERT INTO cities (city, state, code) VALUES ("Washington", "DC", "IAD");
INSERT INTO cities (city, state, code) VALUES ("Orlando", "FL", "MCO");
INSERT INTO cities (city, state, code) VALUES ("Dallas/Fort Worth", "TX", "DFW");
INSERT INTO cities (city, state, code) VALUES ("Denver", "CO", "DEN");

INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Jason", "Smith", "Password1", 9999);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Michael", "Eads", "pAssword2", 1414);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Advaith", "Iyer", "paSsword3", 7417);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("James", "Brown", "pasSword4", 4567);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Devon", "Michaels", "passWord5", 1267);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Mackenzie", "Fraker", "passwOrd6", 2203);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Marty", "Gras", "passwoRd7", 1220);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Jose", "Ramirez", "passworD8", 8478);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Regina", "Brown", "Password9", 2638);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("John", "Ringo", "pAssword10", 8719);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("David", "Drake", "paSsword111", 3454);
INSERT INTO users (first_name, last_name, password, ssn) VALUES ("Amanda", "Smith", "pasSword12", 8039);

INSERT INTO flight (flight_number, departure_code, destination_code, departureCode, destinationCode) VALUES (100, "CLT", "IND", "CLT", "IND");
INSERT INTO flight (flight_number, departure_code, destination_code, departureCode, destinationCode) VALUES (101, "MCO", "DEN", "MCO", "DEN");

INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (9999, 9999, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (9999, 9999, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (1414, 1414, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (7417, 7417, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (4567, 4567, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (1267, 1267, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (2203, 2203, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (1220, 1220, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (8478, 8478, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (2638, 2638, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (8719, 8719, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (3454, 3454, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (3454, 3454, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (3454, 3454, false, 100, 100);
INSERT INTO booking (user_ssn, ssn_book, check_in, flight_number, flight_id) VALUES (8039, 8039, false, 100, 100);
END