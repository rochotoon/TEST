# Kenzan - SpringBoot project

************************************** Basic Info ************************************************

* Employee proyect.- This is an small project to handle employees information.


Run project - There are 3 ways to run this project:

                      1) within the kenzan folder  run mvn spring-boot:run 
                      
                      2) within an IDE , look for  kenzanApplication.java class and run it.
                      
                      3) within the kenzan folder run mvn clean install , then after folder target is generated just  go there
                          look for a file called : interview-0.0.1-SNAPSHOT.war  and within a terminar execute : java -jar interview-0.0.1-SNAPSHOT.war
                          
***************************************** Access ***************************************************

Access URL :  http://localhost:8080/kenzan

Access UI    :  http://localhost:8080/kenzan/swagger-ui.html


**************************************** Execution *************************************************

Within this project you are going to be able to execute operations like:

                        a) Get employees by an ID     - Ex: GET     http://localhost:8080/kenzan/employee/{id}   
                        
                        b) Get all employees          - Ex: GET     http://localhost:8080/kenzan/employee/all
                        
                        c) Create new employees  
                        
                        
                        - Ex: POST  curl -X POST "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateOfBirth\": \"2001-01-01\", \"dateOfEmployment\": \"2019-10-12T16:38:20.612Z\", \"employeeId\": 0, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"
                        
                        
                        d) Update existing employees  
                        
                        - Ex: PUT curl -X PUT "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"dateOfBirth\": \"2001-02-23\", \"dateOfEmployment\": \"2019-10-12T16:39:58.741Z\", \"employeeId\": 0, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"    
                        
                        
                        
                        e) Delete employees . NOTE: Authentication definition at application.properties.
                     
                     - Ex: DELETE  curl -X DELETE "http://localhost:8080/kenzan/employee" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"employeeId\": 5, \"firstName\": \"string\", \"lastName\": \"string\", \"middleInitial\": \"string\", \"status\": \"ACTIVE\"}"
           
************************************** Technical info ****************************************
                     

# Technologies
- Java 1.8
- Spring Boot
- Spring data
- Spring security
- Spring Test
- Spring Rest
- Lombok

# Design patterns
- Singleton
- Builder
- Domain driven design
- Adapter/Marshallers
- FunctionalInterfaces/lambdas








