INSERT INTO sort (id, name, description) VALUES (1, 'Merlot', 'Merlot is a red wine grape variety known for its softness, medium body, and ripe fruit flavors. It often exhibits notes of blackberries, plums, and chocolate, with a smooth and velvety texture.');
INSERT INTO sort (id, name, description) VALUES (2, 'Cabernet Sauvignon', 'Cabernet Sauvignon is a popular red wine grape variety with bold flavors of blackcurrant, dark cherry, and cedar. It is characterized by its full body, firm tannins, and aging potential.');
INSERT INTO sort (id, name, description) VALUES (3, 'Pinot Noir', 'Pinot Noir is a red wine grape variety renowned for its delicate and complex nature. It typically showcases flavors of red berries, cherries, and earthy notes. Pinot Noir wines can vary in style, ranging from light and fruity to rich and structured.');
INSERT INTO sort (id, name, description) VALUES (4, 'Sauvignon Blanc', 'Sauvignon Blanc is a white wine grape variety known for its vibrant acidity and refreshing character. It exhibits flavors of citrus fruits, green apple, gooseberry, and sometimes grassy or herbal notes.');
INSERT INTO sort (id, name, description) VALUES (5, 'Syrah', 'Syrah (also known as Shiraz) is a red wine grape variety that produces full-bodied wines with intense flavors of blackberries, black pepper, and spices. It often has a rich and velvety texture.');

INSERT INTO wine (id, name, harvest, alcohol_percentage, maltster, quality, vineyard, temperature_of_serving, gastro_recommendation, description, price, sort_id)VALUES (1, 'Chardonnay', 2021, 13.5, 'Dry', 'High', 'Vineyard XYZ', 10.0, 'Perfect with seafood', 'Chardonnay is a versatile white wine...', 29.99, 1);
INSERT INTO wine (id, name, harvest, alcohol_percentage, maltster, quality, vineyard, temperature_of_serving, gastro_recommendation, description, price, sort_id)VALUES (2, 'Merlot', 2020, 14.2, 'Semi Dry', 'Medium', 'Vineyard ABC', 16.0, 'Pairs well with red meat', 'Merlot is a red wine known for its...', 39.99, 2);
INSERT INTO wine (id, name, harvest, alcohol_percentage, maltster, quality, vineyard, temperature_of_serving, gastro_recommendation, description, price, sort_id)VALUES (3, 'Pinot Noir', 2019, 12.8, 'Semi Sweet', 'High', 'Vineyard LMN', 14.0, 'Great with grilled salmon', 'Pinot Noir is a delicate red wine...', 34.99, 3);
INSERT INTO wine (id, name, harvest, alcohol_percentage, maltster, quality, vineyard, temperature_of_serving, gastro_recommendation, description, price, sort_id)VALUES (4, 'Sauvignon Blanc', 2022, 11.5, 'Dry', 'Medium', 'Vineyard PQR', 8.0, 'Refreshing with salads', 'Sauvignon Blanc is a crisp white wine...', 24.99, 1);
INSERT INTO wine (id, name, harvest, alcohol_percentage, maltster, quality, vineyard, temperature_of_serving, gastro_recommendation, description, price, sort_id)VALUES (5, 'Syrah', 2018, 14.8, 'Dry', 'High', 'Vineyard DEF', 18.0, 'Pairs well with spicy dishes', 'Syrah (or Shiraz) is a bold red wine...', 42.99, 2);


INSERT INTO wine_order (id, order_status, total_price, payment_method, creation_timestamp) VALUES (1, 'CREATED', 39.99, 'CARD', CURRENT_TIMESTAMP);
INSERT INTO wine_order (id, order_status, total_price, payment_method, creation_timestamp) VALUES (2, 'PROCESSING', 49.99, 'CASH', CURRENT_TIMESTAMP);
INSERT INTO wine_order (id, order_status, total_price, payment_method, creation_timestamp) VALUES (3, 'DELIVERED', 79.99, 'CARD', CURRENT_TIMESTAMP);
INSERT INTO wine_order (id, order_status, total_price, payment_method, creation_timestamp) VALUES (4, 'DELIVERED', 99.99, 'CARD', CURRENT_TIMESTAMP);
INSERT INTO wine_order (id, order_status, total_price, payment_method, creation_timestamp) VALUES (5, 'CANCELED', 29.99, 'CASH', CURRENT_TIMESTAMP);

INSERT INTO wineorder_wine (order_id, wine_id) VALUES (1, 2);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (1, 3);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (1, 4);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (2, 1);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (2, 2);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (2, 2);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (2, 4);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (3, 3);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (4, 3);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (4, 3);
INSERT INTO wineorder_wine (order_id, wine_id) VALUES (5, 5);