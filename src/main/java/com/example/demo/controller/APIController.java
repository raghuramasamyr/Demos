package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.BasicTest;
import com.example.demo.service.SaveDet;
import com.example.demo.service.ServiceLayer;

@RestController
public class APIController {
	
	
	@Autowired
	private ServiceLayer saveLayer;
	
	@Autowired
	private BasicTest bt;
	
	@GetMapping("/saveDet") 
	public String postAPI(@RequestBody SaveDet saveDet) {
		System.out.println(saveDet);
		
		try {
			//bt.saveTest();
		 System.out.println(saveLayer.addValues(saveDet).getName()); 
		}catch (Exception e) {
			e.printStackTrace();
			return "Saving failed";
		}
		return "saved succesfully";
		
	}

	@PostMapping("/getDet") 
	public ResponseEntity<List<SaveDet>> getDataAPI(@RequestParam String id) {
		System.out.println(id);
		List<SaveDet> sv ;
		try {
			sv = saveLayer.getValues(id); 
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<SaveDet>>(sv, HttpStatus.OK);
		
	}
	
	@PostMapping("/testAPI") 
	public String getDataAPI() {
		System.out.println("Hello world");
		
		
		return "Hello World";
		
	}
}
