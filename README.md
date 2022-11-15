# What is this?

This is an example application running on a Spring Boot and PostgreSQL. Feel free to do whatever you want with it.

# API reference

## Get all coffee machines
https://github.com/ncmprbll/enterprise-example-application/labels/GET /api/coffee_machines

## Create a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/POST /api/coffee_machines

### Body parameters
* **brand** *string*
* **model** *string*
* **countryOfOrigin** *string*
* **price** *number*

## Update a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/PUT /api/coffee_machines

### Body parameters
* **id** *number*
* **brand** *string*
* **model** *string*
* **countryOfOrigin** *string*
* **price** *number*

## Delete a coffee machine record
https://github.com/ncmprbll/enterprise-example-application/labels/DELETE /api/coffee_machines/{id}

### Path parameters
* **id** *number*
