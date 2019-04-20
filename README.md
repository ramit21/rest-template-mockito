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

Use RestTemplate to hit the url, and fetch data as array of a datamodel:
```
restTemplate.exchange(url, HttpMethod.GET, null, DataModel[].class).getBody()
```
JPA Repository interface has @Repository annotation

Notice the FetchDataServiceTest.java:
```
1. @RunWith(MockitoJUnitRunner.class)
2. Create service with mocked services and repositories. 
Look how constructor auto-wiring is used in the service for passing the mock objects in test case.
3. Mock function calls:
  Mockito.when(mockedObect.someFunc( Mockito.any() ).thenReturn(someData) ; 
  ```
In Controllers, default verb is GET. To give post:
```
@RequestMapping(value = "/save", method = RequestMethod.POST)
```