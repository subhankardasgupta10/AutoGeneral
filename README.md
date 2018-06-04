AutoGeneral Sample API
===============================

The goal of the project is to perform operations as per the given Swagger.

Endpoints Overview
========

1. **/tasks/validateBracket** - This endpoint will be give proper 200 response and 400 response in error scenarios.
Only added this endpoint to web security config. because, this has full implementation and can be tested.

The below endpoints are not added in the webSecurity config due to some missing info, like where the value will be saved, from where it will fetch. So generic
implementation is done with comments.

2. **/task/validateBrackets** - POST request, Accrding to the swagger, there is no specification to save the value anywhere,
we assume it will save the body payload. Hence, respective comments are added in the service class which will inline the implementation.

3. **/task/validateBrackets/{id}** - GET request, Retrieve a specific item by id. This inlines with POST method. Once, a data is stored
id can be used to retrieve it. Respective comments are added in the service class which will inline the implementation.

4. **/task/validateBrackets/{id}** - PATCH request, Modify an item. Id will be used to update the corresponding value. Respective 
comments are added in the service class which will inline the implementation.
 
5. **/integrationTest** - According to the swagger not required to implement.

6. **/status** - According to the swagger not required to implement.

How to Run
========

1. Import the workspace in Intellij editor.
2. Go to Run -> Edit configuration. Add Spring Boot application.
3. Point Main class to: sample.com.au.Application
4. Point Program Arguments to: --spring.profiles.active=local
5. Point the project path to working directory and classpath.
6. Click on Apply and run.
7. Open Postman and add this endpoint - "http://localhost:8080/task/validateBrackets?input=hell(test)o" and click send. Below 200 response will come.
{
    "input": "hell(test)o",
    "balanced": true
}
8. If you add this endpoint - and click send. Below 400 error code will come.
{
    "name": "ValidationError",
    "location": "uri=/task/validateBrackets",
    "param": "hell(test)o",
    "msg": "Must be between 1 and 100 chars long",
    "value": "400"
}

**Esxception Handling:**
It can be configured more generic and we can create another class and use ArrayList to 
segragate details as a JSON Array, as given in the swagger.