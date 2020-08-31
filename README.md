# url-shortener

## API's - 

#### 1) To get short url for a long url -

  * curl --location --request GET 'localhost:8080/get-short-url?longUrl=https://www.facebook.com/my-profile' \
--header 'Client-id: 55940791-1f39-4756-bdc6-683dafd0e54c'
  * Client id should be a valid uuid id after adding it to supported clients

#### 2) To get original url -

  * curl --location --request GET 'localhost:8080/get-original-url?shortUrl=10000000'

#### 3) To get hit count - 

  * curl --location --request GET 'localhost:8080/get-hit-count?shortUrl=10000000'

#### 4) To add a valid client - 

  * curl --location --request POST 'localhost:8080/admin/add-client?clientName=google'
  * clientName should be unique
  * Returns a UUID which acts as a client id for subsequent interaction with service
