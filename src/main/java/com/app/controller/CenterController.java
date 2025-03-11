package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Center;
import com.app.service.CenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/training-center")
public class CenterController {

	@Autowired
	private CenterService centerService;
	
	@PostMapping
	public ResponseEntity<Center> addTrainingCenter(@Valid @RequestBody Center center){
		return new ResponseEntity<Center>(centerService.addTrainingCenter(center),HttpStatus.CREATED);
	}
	
	@GetMapping
    public ResponseEntity<List<Center>> getAllTrainingCenters(
            @RequestParam(required = false) String centerName,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) Integer studentCapacity,
            @RequestParam(required = false) String course,
            @RequestParam(required = false) String contactPhone,
            @RequestParam(required = false) String centerCode,
            @RequestParam(required = false) String contactEmail,
            @RequestParam(required = false) String pincode) {

        List<Center> centers = centerService.getFilteredCenters(centerName, city, state, studentCapacity, course, contactPhone, centerCode, contactEmail, pincode);
        return new ResponseEntity<>(centers, HttpStatus.OK);
    }
}
