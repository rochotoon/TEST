# Kenzan - SpringBoot project


* Employee proyect.- This is an small project to handle employees information.


Run project - There are 3 ways to run this project:

                      1) within the kenzan folder  run mvn spring-boot:run 
                      
                      2) within an IDE , look for  kenzanApplication.java class and run it as "java application console".
                      
                      3) within the kenzan folder run mvn clean install , then after folder target is generated just  go there
                          look for a file called : interview-0.0.1-SNAPSHOT.war  and within a terminar execute : java -jar interview-0.0.1-SNAPSHOT.war
                          
# Access 

Access URL        :  http://localhost:8080/kenzan

Access UI         :  http://localhost:8080/kenzan/swagger-ui.html

Access runtime DB : http://localhost:8080/kenzan/h2

# UI
You can use the swagger UI to test this app.
![image](https://user-images.githubusercontent.com/24998574/66705176-4e2a5900-ecd8-11e9-89dc-3167af9f4e51.png)


# Execution 

Within this project you are going to be able to execute operations like:

                        a) Get employees by an ID     - Ex: GET     http://localhost:8080/kenzan/employee/{id}   
                        
                        b) Get all employees          - Ex: GET     http://localhost:8080/kenzan/employee/all
                        
                        c) Create new employees  
                        
                        
                        - Ex: POST  curl -X POST "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateOfBirth\": \"2001-01-01\", \"dateOfEmployment\": \"2019-10-12T16:38:20.612Z\", \"employeeId\": 0, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"
                        
                        
                        d) Update existing employees  
                        
                        - Ex: PUT curl -X PUT "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateOfBirth\": \"2001-02-23\", \"dateOfEmployment\": \"2019-10-12T16:39:58.741Z\", \"employeeId\": 0, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"    
                        
                        
                        
                        e) Delete employees . NOTE: Authentication definition at application.properties.
                     
                     - Ex: DELETE  curl -X DELETE "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"employeeId\": 5, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"                     

# Technologies
- Java 1.8
- Spring core
- Spring Boot
- Spring data
- Spring security
- Spring Test
- Spring Rest
- Lombok
- swagger

# Design patterns
- Singleton                    : To avoid unesesary instances.
- Builder                      : use of immutable instances and encapsulate logic.   
- Domain driven design         : Business logic should reside within their corresponding model representation.
- Adapter/Marshallers          : Translators to move information thru applications layers as corresponding.
- FunctionalInterfaces/lambdas : decrease the use of boiler plate code and improve code readiability .








