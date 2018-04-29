package com.rest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.demo.dao.DataModelRepository;
import com.rest.demo.domain.DataModel;

@Service
public class FetchDataService {
	
	private DataModelRepository dataModelRepository;
	private RestTemplateService restTemplateService;

	@Autowired
	public FetchDataService(DataModelRepository dataModelRepository,
							RestTemplateService restTemplateService){
		this.dataModelRepository = dataModelRepository;
		this.restTemplateService = restTemplateService;
	}

	private String url = "https://jsonplaceholder.typicode.com/posts";
	
	public DataModel[] fetchAndSaveJsonData(){
		DataModel[] dataArray = restTemplateService.httpGetJsonData(url); 
		for(DataModel dm : dataArray){
			dataModelRepository.save(dm);
			dataModelRepository.flush();
		}
		System.out.println("Records fetched and saved: "+dataArray.length);
		return dataArray;
	}
	
	public List<DataModel> findByUserId(Integer id){
		return dataModelRepository.findByUserId(id);
	}
	
	public List<DataModel> findAll(){
		return dataModelRepository.findAll();
	}
}
