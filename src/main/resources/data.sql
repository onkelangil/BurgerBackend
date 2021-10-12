INSERT INTO burger_user (id, first_name, last_name, premium_member) VALUES ('fakeUserToken', 'john', 'doe', true);
INSERT INTO burger_restaurant (id, name, latitude, longitude, score) VALUES ('fakeRestaurantId', 'Koedstaden', 11.11, 11.11, 5);
INSERT INTO burger_menu (id, burger_restaurant_id, name, description) VALUES ('fakeMenuId', 'fakeRestaurantId', 'cheeseburger', 'burger with cheese');
INSERT INTO burger_opening_hours (id, burger_restaurant_id, weekday, start_time, end_time) VALUES ('fakeOpeningHourId','fakeRestaurantId', 'MONDAY', '08.00', '23.00');