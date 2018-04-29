package com.rest.demo.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.rest.demo.dao.DataModelRepository;
import com.rest.demo.domain.DataModel;

@RunWith(MockitoJUnitRunner.class)
public class FetchDataServiceTest {

	private FetchDataService service;
	
	private DataModelRepository dataModelRepository = Mockito.mock(DataModelRepository.class);
	private RestTemplateService restTemplateService = Mockito.mock(RestTemplateService.class);

	@Before
	public void setUp(){
		service = new FetchDataService(dataModelRepository, restTemplateService);
	}
	
	@Test
	public void testFetchData(){
		Mockito.when(restTemplateService.httpGetJsonData(Mockito.any())).thenReturn(getMockedJsonData());
		DataModel[] response = service.fetchAndSaveJsonData();
		Assert.assertNotNull(response);
		Assert.assertEquals(2, response.length);
	}
	
	private DataModel[] getMockedJsonData(){
		DataModel[] data = new DataModel[2];
		return data;
	}

}
