# What is this?

This is an example Spring Boot web application backed by a PostgreSQL database. Feel free to do whatever you want with it.

# Launching application

## Docker

- Configure the `.env` file to your needs
- Execute `docker compose up -d` and the app will be running in a few seconds

## Manual launching

I haven't tried these steps myself but I imagine they are correct.

- Configure the `src/main/resources/application.properties` file to your needs
- Build the project with `mvn clean package`
- Execute `java -jar target/enterprise-example-application.jar` and the app will be running in a few seconds

# API reference

## Get all coffee machines
https://github.com/ncmprbll/enterprise-example-application/labels/GET /api/coffee_machines

## Create a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/POST /api/coffee_machines

### Body parameters
- **brand** *string*
- **model** *string*
- **countryOfOrigin** *string*
- **price** *number*

## Update a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/PUT /api/coffee_machines

### Body parameters
- **id** *number*
- **brand** *string*
- **model** *string*
- **countryOfOrigin** *string*
- **price** *number*

## Delete a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/DELETE /api/coffee_machines/{id}

### Path parameters
- **id** *number*
