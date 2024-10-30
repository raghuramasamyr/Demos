package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repo.SaveEntity;
import com.example.demo.repo.SaveRepo;

@Service
public class ServiceLayer {

	@Autowired
	private SaveRepo save;
	
	public SaveEntity addValues(SaveDet sav) { 
		
		SaveEntity d = new SaveEntity();
		d.setId(sav.getId());
		d.setName(sav.getName());
		d.setColumn(sav.getCompany());
		
		try {
			save.save(d);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return save.save(d);
	}

	public List<SaveDet> getValues(String id) {
		
		List<SaveEntity> sav = save.findAll();
		
		List<SaveDet> ds = sav.stream().map(se-> new SaveDet(se.getId(),se.getName(),se.getColumn()) )
				.collect(Collectors.toList());
		
		
		
		return ds;
	}
	
}
