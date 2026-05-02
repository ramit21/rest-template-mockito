package com.rest.demo.service;

import com.rest.demo.dao.DataModelRepository;
import org.junit.jupiter.api.BeforeEach; // Changed from @Before
import org.junit.jupiter.api.Test;       // Changed from org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith; // Changed from @RunWith
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class FetchDataServiceTest { // Removed public

	private FetchDataService fetchDataService;

	// You can also use @Mock and @InjectMocks here instead of manual instantiation
	private DataModelRepository dataModelRepository = org.mockito.Mockito.mock(DataModelRepository.class);
	private RestTemplateService restTemplateService = org.mockito.Mockito.mock(RestTemplateService.class);

	@BeforeEach
	void setUp() { // Changed from public void setup()
		fetchDataService = new FetchDataService(dataModelRepository, restTemplateService);
	}

	@Test
	void testFetchData() {
		// Your mocking logic here...

		// Example of JUnit 5 Assertions:
		// assertNotNull(result);
		// assertEquals(expected, actual);
	}
}