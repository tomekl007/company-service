To start service on your local machine:
``./mvnw spring-boot:run`` 

To create new company:
``curl -X POST -H "Content-Type: application/json" -d @exampleCompany.json http://localhost:8080/company``

To get company:
``curl -i -H "Accept: application/json" http://localhost:8080/company/1``

To get all companies:
``curl -i -H "Accept: application/json" http://localhost:8080/companies``

To add beneficial owner for the company:
``curl -X POST -H "Content-Type: application/json" -d @beneficialOwner.json http://localhost:8080/company/1/beneficial-owner``

 