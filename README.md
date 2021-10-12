#burger backend

For testing you can run the following curl to add a review

`curl --location --request POST 'localhost:8080/api/v1/review' \
--header 'jwt: jwt' \
--header 'Content-Type: application/json' \
--data-raw '{
"burgerRestaurantId": "testId2",
"tasteScore": 5,
"textureScore": 7,
"visualScore": 3
}`


`curl --location --request GET 'localhost:8080/api/v1/restaurants?latitude=11.00&longitude=11.00' \
--header 'jwt: jwt' \
--header 'Content-Type: application/json' \
--data-raw '{
"burgerRestaurantId": "testId2",
"tasteScore": 5,
"textureScore": 7,
"visualScore": 3
}'`