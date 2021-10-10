<pre>

- access swagger at: http://localhost:7070/indi-shop/swagger-ui/#

- if project is running in-memory data base is available at: http://localhost:7070/indi-shop/h2-console/
       Driver Class: org.h2.Driver
       JDBC URL: jdbc:h2:mem:testdb
       DB username: sa
       DB password: password


- if you want to build and run project in your IDE:
   1 - the project lombok plugin is needed: Eclipse - https://projectlombok.org/setup/eclipse or IntelliJ IDEA - https://projectlombok.org/setup/intellij
   2 - since we use mapstruct processor make sure you have annotation processing enabled in your IDE for this project
   
   
- or just cd to project directory and run it from CLI with:  mvn spring-boot:run


- JUnit tests are implemented for requirement's doc use cases.


- to see sql queries while JUnit tests are executed p6spy is used(only for junit tests)
  just execute  mvn clean install, for example, to see those queries.
</pre>
  