CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Olivia Green', 'olivia.green@example.com', '444 Pine St', '555-3333', '{"isPremium": true, "favoriteHotels": ["Westin", "Four Seasons"], "secondName": "Smith", "hasDiscount": true, "age": 28, "hobbies": ["yoga", "reading"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Noah Clark', 'noah.clark@example.com', '555 Cedar St', '555-4444', '{"isPremium": false, "favoriteHotels": ["Holiday Inn", "Days Inn"], "secondName": "Lee", "hasDiscount": false, "age": 32, "hobbies": ["golf", "traveling"], "pets": ["cat"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Sophia Rodriguez', 'sophia.rodriguez@example.com', '666 Oak St', '555-5555', '{"isPremium": true, "favoriteHotels": ["Ritz Carlton", "W Hotel"], "secondName": "Garcia", "hasDiscount": true, "age": 24, "hobbies": ["cooking", "painting"], "pets": ["bird"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'William Davis', 'william.davis@example.com', '777 Elm St', '555-6666', '{"isPremium": false, "favoriteHotels": ["Comfort Inn", "Red Roof Inn"], "secondName": "Jones", "hasDiscount": false, "age": 38, "hobbies": ["hiking", "photography"], "pets": ["fish"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Isabella Martinez', 'isabella.martinez@example.com', '888 Pine St', '555-7777', '{"isPremium": true, "favoriteHotels": ["InterContinental", "Grand Hyatt"], "secondName": "Hernandez", "hasDiscount": true, "age": 29, "hobbies": ["dancing", "singing"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'James Wright', 'james.wright@example.com', '999 Cedar St', '555-8888', '{"isPremium": false, "favoriteHotels": ["La Quinta", "Super 8"], "secondName": "Jackson", "hasDiscount": false, "age": 44, "hobbies": ["fishing", "camping"], "pets": ["cat"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Emma Baker', 'emma.baker@example.com', '1010 Oak St', '555-9999', '{"isPremium": true, "favoriteHotels": ["Fairmont", "JW Marriott"], "secondName": "Johnson", "hasDiscount": true, "age": 31, "hobbies": ["running", "yoga"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Ethan Carter', 'ethan.carter@example.com', '1111 Elm St', '555-1111', '{"isPremium": false, "favoriteHotels": ["Hampton Inn", "Holiday Inn Express"], "secondName": "Brown", "hasDiscount": false, "age": 27, "hobbies": ["basketball", "video games"], "pets": ["fish"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Ava Flores', 'ava.flores@example.com', '1212 Pine St', '555-1212', '{"isPremium": true, "favoriteHotels": ["Hyatt Regency", "Mandarin Oriental"], "secondName": "Gonzalez", "hasDiscount": true, "age": 33, "hobbies": ["baking", "reading"], "pets": ["cat"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Mason Cooper', 'mason.cooper@example.com', '1313 Cedar St', '555-1313', '{"isPremium": false, "favoriteHotels": ["Best Western", "Travelodge"], "secondName": "Allen", "hasDiscount": false, "age": 36, "hobbies": ["gaming", "skiing"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Charlotte Richardson', 'charlotte.richardson@example.com', '1414 Oak St', '555-1414', '{"isPremium": true, "favoriteHotels": ["Four Points", "Hilton Garden Inn"], "secondName": "Taylor", "hasDiscount": true, "age": 26, "hobbies": ["knitting", "painting"], "pets": ["bird"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Liam Wood', 'liam.wood@example.com', '1515 Elm St', '555-1515', '{"isPremium": false, "favoriteHotels": ["Days Inn", "Hampton Inn"], "secondName": "Brown", "hasDiscount": false, "age": 30, "hobbies": ["hiking", "biking"], "pets": ["cat"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Amelia West', 'amelia.west@example.com', '1616 Pine St', '555-1616', '{"isPremium": true, "favoriteHotels": ["Westin", "Ritz Carlton"], "secondName": "Hill", "hasDiscount": true, "age": 28, "hobbies": ["yoga", "reading"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Elijah Hayes', 'elijah.hayes@example.com', '1717 Cedar St', '555-1717', '{"isPremium": false, "favoriteHotels": ["Holiday Inn", "Comfort Inn"], "secondName": "Lee", "hasDiscount": false, "age": 32, "hobbies": ["golf", "fishing"], "pets": ["bird"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Avery Rogers', 'avery.rogers@example.com', '1818 Oak St', '555-1818', '{"isPremium": true, "favoriteHotels": ["Marriott", "Intercontinental"], "secondName": "Walker", "hasDiscount": true, "age": 25, "hobbies": ["swimming", "traveling"], "pets": ["cat", "dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Carter Cooper', 'carter.cooper@example.com', '1919 Elm St', '555-1919', '{"isPremium": false, "favoriteHotels": ["Red Roof Inn", "Econo Lodge"], "secondName": "Lopez", "hasDiscount": false, "age": 29, "hobbies": ["hiking", "camping"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Isabella Diaz', 'isabella.diaz@example.com', '2020 Pine St', '555-2020', '{"isPremium": true, "favoriteHotels": ["Hilton", "Sheraton"], "secondName": "Garcia", "hasDiscount": true, "age": 31, "hobbies": ["cooking", "dancing"], "pets": ["bird", "cat"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Lucas Carter', 'lucas.carter@example.com', '2121 Cedar St', '555-2121', '{"isPremium": false, "favoriteHotels": ["Super 8", "Howard Johnson"], "secondName": "Johnson", "hasDiscount": false, "age": 34, "hobbies": ["running", "photography"], "pets": ["dog"]}');

INSERT INTO person (id, name, email, address, phone, custom_attributes_json)
VALUES (uuid_generate_v4(), 'Evelyn Anderson', 'evelyn.anderson@example.com', '2222 Oak St', '555-2222', '{"isPremium": true, "favoriteHotels": ["Renaissance", "Fairmont"], "secondName": "Wilson", "hasDiscount": true, "age": 27, "hobbies": ["painting", "hiking"], "pets": ["cat"]}');
