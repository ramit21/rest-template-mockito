package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rest.demo.domain.DataModel;
import com.rest.demo.service.FetchDataService;

@Controller
public class DataRestController {
	
	@Autowired
	private FetchDataService fetchDataService;
	
	@RequestMapping(value="/")
	@ResponseBody
	public String homePage(){
		return "Hello SpringBoot";
	}
	
	@RequestMapping(value="/fetch")
	@ResponseBody
	public DataModel[] getAndSaveData(){
		return fetchDataService.fetchAndSaveJsonData();
	}
	
	//http://localhost:8080/find?userId=1   returns userId=1 data
	//http://localhost:8080/find			returns all data
	@RequestMapping(value="/find")
	@ResponseBody
	public List<DataModel> findByUserId(@RequestParam(value="userId", required=false) Integer userId){
		if(userId!=null){
			return fetchDataService.findByUserId(userId);
		}
		return fetchDataService.findAll();
	}
}
