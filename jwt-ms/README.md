# jwt-apigateway-security

# Launch projects
- zomato-service-registry
- identity-service
- zomato-gateway
- zomato-app
- restaurant-service


## After launching the appas You can use Postman or curl to make api calls
## Register an user
* Note: use service specific port number  or apigateway portnumber 
* Postman
```
API: http://localhost:8080/auth/register
Method: POST
Request Body:
{
    "name":"venkat",
    "password":"Pwd1",
    "email":"venkat@gmail.com"
}
```

```
curl --location --request POST 'http://localhost:8080/auth/register' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D' \
--data-raw '{
    "name":"venkat",
    "password":"Pwd1",
    "email":"venkat@gmail.com"
}'

```

## Generate token/Login
* After the authentication find token in response
* Postman
```
API: http://localhost:9898/auth/token
Method: POST
Request Body:
{
    "username":"venkat",
    "password":"Pwd1"
}
```

```
curl --location --request POST 'http://localhost:9898/auth/token' \
--header 'Content-Type: application/json' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D' \
--data-raw '{
    "username":"venkat",
    "password":"Pwd1"
}'
```

## Access zomato-app manually with token. 
* To get the order status status we need to authenticate with token. Use the token from previous request
* Postman
* http://localhost:8080/zomato/{orderId}

```
API: http://localhost:8080/zomato/37jbd832
Method: GET
Headers: 
Authorization: Bearer Paste the token here

Ex-: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU4MDIsImV4cCI6MTY3OTA1NzYwMn0.Q0bwS5_16q1Z8K-p_flpmyRoJNFCyOhU2AMKSNYh66o

```

```
curl --location --request GET 'http://localhost:8080/zomato/37jbd832' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU4MDIsImV4cCI6MTY3OTA1NzYwMn0.Q0bwS5_16q1Z8K-p_flpmyRoJNFCyOhU2AMKSNYh66o' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D'
```

## Access Restaurant-service manually with token. 

```
API: http://localhost:8080/restaurant/orders/status/37jbd832
Method: GET
Headers: 
Authorization: Bearer Paste the token here

Ex-: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU4MDIsImV4cCI6MTY3OTA1NzYwMn0.Q0bwS5_16q1Z8K-p_flpmyRoJNFCyOhU2AMKSNYh66o

```
curl --location --request GET 'http://localhost:8080/restaurant/orders/status/37jbd832' \
--header 'Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXNhbnQiLCJpYXQiOjE2NzkwNTU1MDcsImV4cCI6MTY3OTA1NzMwN30.9nNAW1rx8RoTIrhn5Abtzg7RplvT9_d-U5EOwUcJZq8' \
--header 'Cookie: JSESSIONID=7CE91EE75A65277C0DCB6C5736C5DF5D'
```
