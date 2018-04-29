package com.rest.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.demo.domain.DataModel;

@Repository
public interface DataModelRepository extends JpaRepository<DataModel, Integer>{
	
	List<DataModel> findByUserId(Integer userId);
}
