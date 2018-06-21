### To start service on your local machine:
``./mvnw spring-boot:run``

To start all tests:
``./mvnw clean test`` 

## CURL
To create new company:
``curl -X POST -H "Content-Type: application/json" -d @exampleCompany.json https://company-micro-service.herokuapp.com/company``

To get company:
``curl -i -H "Accept: application/json" http://localhost:8080/company/1``

To get all companies:
``curl -i -H "Accept: application/json" http://localhost:8080/companies``

To add beneficial owner for the company:
``curl -X POST -H "Content-Type: application/json" -d @beneficialOwner.json http://localhost:8080/company/1/beneficial-owner``

## Application is deployed to heroku: 
host:
``https://company-micro-service.herokuapp.com/`` 

So you all curl queries could be executed against that host, for example:
``curl -X POST -H "Content-Type: application/json" -d @exampleCompany.json https://company-micro-service.herokuapp.com/company``
and
``curl -i -H "Accept: application/json" https://company-micro-service.herokuapp.com/company/100``


## Authentication:
For Authentication I would use OAuth2.  
Client will use client_secret and client_id to get token.
Backend will provide client with the token.
Next, token will be used and passed as the Authentication header with every https request.
The Authentication token will have expiration time. 
When expiration time will elapsed client will request for renewal of token and
the process will repeat.  

Every request should be done via HTTPs

## How can you make the service redundant? What considerations should you do?
1. We should deploy our application to multiple nodes(hosts). 
Then when one host will have problems we can redirect whole traffic to other hosts.
Between clients and our backend services should be a load balancer (e.g. varnish) that is routing traffic
to only healthy instances.
2. If we are using i.e. AWS for our infrastructure we can deploy 
some instances in one zone(dc) i.e. europe and other in other dc to reduce 
probability of failure if one dc is down  


## Assumptions made
I've created the ``CompanyRepository`` interface that is an abstraction for data storage.
For a case of simplicity of an exercise I've implemented in-memory storage ``CompanyRepositoryInMemory``
In the production ready application the ``CompanyRepository`` interface should be implement as
database backed storage.
