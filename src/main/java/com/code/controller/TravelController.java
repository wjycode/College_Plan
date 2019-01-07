package com.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.code.dao.TravelDao;
import com.code.model.Travel;

@RestController
@RequestMapping("/travel")
public class TravelController {

	@Autowired
	private TravelDao travelDao;
	
	@RequestMapping("/getTravelList")
	public List<Travel> getTravelList(){
		return travelDao.getTravelList();
	}
}
