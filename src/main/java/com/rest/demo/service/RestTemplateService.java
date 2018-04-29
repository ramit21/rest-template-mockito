package com.rest.demo.service;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.demo.domain.DataModel;

@Service
//For the sake of mocking http request in Fetch Data service
public class RestTemplateService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public DataModel[] httpGetJsonData(String url){
		return restTemplate.exchange(url, HttpMethod.GET, null, DataModel[].class).getBody(); 
	}
	
}
