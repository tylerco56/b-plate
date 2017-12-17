# b-plate

#### The java boiler you've been looking for.

B-plate is full-stack Java web-application boilerplate for the most common use cases. It is meant as a starting point to allow developers to focus their time on unique functionality and speed up development.

The following features are provided by b-plate "out-of-the-box" in and MVC pattern:
- User authentication with SMS 2-factor
- User roles & permissions
- Account management (registration, password reset, etc.)
- Private personal user data and page
- Public pages for landing-pages and help content
- Email server with SendGrid
- Persistence with MySQL example
- Front-end HTML and CSS



##### Back-end:
- Spring
- Gradle
- JPA with MySQL
- Spring Security
- Thymeleaf

##### Front-end:
- Materialize


## Installation
1. Fork the repository, and clone to your workspace, install in your chosen IDE.

2. Create a MySQL database on your local installation.

3. Create 'application.properties' in the top-level directory of the project and enter your database credentials.  This is the code you are looking for:


```
# Database connection settings
spring.datasource.url = jdbc:mysql://localhost:8889/databasename
spring.datasource.username = username
spring.datasource.password = password

## Keep the connection alive if idle for a long time (needed in production)
#spring.datasource.testWhileIdle = true
#spring.datasource.validationQuery = SELECT 1

# Specify the DBMS
spring.jpa.database = MYSQL

# Show or not log for each sql query
spring.jpa.show-sql = false

# Hibernate ddl auto (create, create-drop, update)
spring.jpa.hibernate.ddl-auto = update

# Use spring.jpa.properties.* for Hibernate native properties (the prefix is
# stripped before adding them to the entity manager)
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

# Turn off security protocol requiring login to run app
security.basic.enabled=false

spring.mail.host = smtp.sendgrid.net
spring.mail.port = 25 
spring.mail.username = apikey
spring.mail.password = 
spring.mail.protocol = smtp
#spring.mail.defaultEncoding = UTF-8
``` 



## License & Usage
You may use b-plate freely for personal, non-commercial purposes only. Please contact me on Linkedin to discuss commercial use.



