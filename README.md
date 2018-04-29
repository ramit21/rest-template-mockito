# rest-template-mockito
Problem involving rest template with mocked unit testing in spring boot


Problem Statement:
Scaffold a spring boot project, make call to url given below, which gives back JSON data.
Store this data into in memory database, and expose it via controllers with unit test cases.
https://jsonplaceholder.typicode.com/posts

Steps:

Scaffold project from https://start.spring.io/
Add dependencies for H2, JPA, Web
Create project and download the project zip
unzip and run following on terminal:
mvn install eclipse:eclipse
Then import the existing maven project into workspace
Use RestTemplate to hit the url, and fetch data as array of a datamodel
JPA Repository has @Repository annotation
Notice the FetchDataServiceTest.java:
  1. @RunWith(MockitoJUnitRunner.class)
2. Create service with mocked services and repositories
  3. Mock function calls:
  Mockito.when(mockedObect.someFunc( Mockito.any() ).thenReturn(someData) ; 
