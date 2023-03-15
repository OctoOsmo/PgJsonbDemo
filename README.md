## PgJsonbDemo

This project provides an example of storing, processing a searchig on not-relational data in PostgreSQL through JPA and Hibernate technologies.
Java annotation processor that generates static list of field names for annotated classes.

### Usage

To run this priject follow these steps:
* setup postgres
  * run postgres
  * create empty database
  * specify connection string, user and password in properties.yml
* Assuming you have JDK 17 run ./gradlew clean assembe command
* Find location of newely built jar file and execute this command: java -jar PgJsonbDemo-0.0.1-SNAPSHOT.jar
* Open swagger at http://localhost:8080/swagger-ui/index.html

### Json support in postgres
* [JSON in PostgreSQL](https://bitnine.net/blog-postgresql/postgresql-internals-jsonb-type-and-its-indexes/)
* [Why Store JSON in PostgreSQL?](https://dzone.com/articles/using-jsonb-in-postgresql-how-to-effectively-store)

### Indexes
* [PostgreSQL internals: JSONB type and its indexes](https://bitnine.net/blog-postgresql/postgresql-internals-jsonb-type-and-its-indexes/?ckattempt=2)
* [GIN index](http://www.sai.msu.su/~megera/wiki/Gin)

### Json syntax
* [Json functions](https://www.postgresql.org/docs/current/functions-json.html)
* [Postgres functions](https://www.postgresql.org/docs/current/functions-json.html)
* [SQL support for JavaScript Object Notation (JSON). First Edition. 2017.](https://www.iso.org/standard/78937.html)
 
### Hibernate Types
* [hypersistence-utils repository](https://github.com/vladmihalcea/hypersistence-utils)
* [hypersistence-utils installation Guide](https://github.com/vladmihalcea/hypersistence-utils#installation-guide) 
* [How to map JSON objects using generic Hibernate Types](https://vladmihalcea.com/how-to-map-json-objects-using-generic-hibernate-types/)
* [A Guide to the Hibernate Types Library](https://www.baeldung.com/hibernate-types-library)

### Java
* [java-spi](https://www.baeldung.com/)
