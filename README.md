#spring-boot-mybatis-xml-mapper

Demo project to show case my batis xml-mapper integration with Spring boot

MY SQL is used as database for this example
Lombok library is used to avoid writing repetitive code

mvn install
mvn spring-boot:run

Rest endpoints is exposed to test the example
1. http://localhost:8082/api/addressbook (create an item in adress book)
2. http://localhost:8082/api/addressbook/{id} (update an item in adress book)
3. http://localhost:8082/api/addressbook/{id} (delete an item in adress book)
4. http://localhost:8082/api/addressbook (retrieve all entries of address book)
5. http://localhost:8082/api/addressbook/{emailid} (retrieve address book entry by email id)
6. http://localhost:8082/api/addressbook/firstnameanddateofbirth?firstName=Aleksandr&dateOfBirth=1991-02-23 (retrieve by firstname and date of birth)