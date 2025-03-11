package com.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Center;
import com.app.repo.CenterRepo;

@Service
public class CenterService {

	@Autowired
	private CenterRepo centerRepo;

	public Center addTrainingCenter(Center center) {
		center.setCreatedOn(LocalDateTime.now());
		return centerRepo.save(center);
	}

	public List<Center> getAllTrainingCenter() {
		return centerRepo.findAll();
	}

	public List<Center> getFilteredCenters(String centerName, String city, String state, Integer studentCapacity,
			String course, String contactPhone, String centerCode, String contactEmail, String pincode) {

		List<Center> centers = centerRepo.findAll();

		return centers.stream().filter(c -> (centerName == null
				|| (c.getCenterName() != null && c.getCenterName().toLowerCase().contains(centerName.toLowerCase()))))
				.filter(c -> (city == null || (c.getAddress() != null && c.getAddress().getCity() != null
						&& c.getAddress().getCity().toLowerCase().contains(city.toLowerCase()))))
				.filter(c -> (state == null || (c.getAddress() != null && c.getAddress().getState() != null
						&& c.getAddress().getState().toLowerCase().contains(state.toLowerCase()))))
				.filter(c -> (pincode == null || (c.getAddress() != null && c.getAddress().getPincode() != null
						&& c.getAddress().getPincode().contains(pincode))))
				.filter(c -> (studentCapacity == null
						|| (c.getStudentCapacity() != 0 && c.getStudentCapacity() >= studentCapacity)))
				.filter(c -> (course == null || (c.getCoursesOffered() != null && c.getCoursesOffered().stream()
						.anyMatch(crs -> crs.toLowerCase().contains(course.toLowerCase())))))
				.filter(c -> (contactPhone == null
						|| (c.getContactPhone() != null && c.getContactPhone().contains(contactPhone))))
				.filter(c -> (centerCode == null || (c.getCenterCode() != null
						&& c.getCenterCode().toLowerCase().contains(centerCode.toLowerCase()))))
				.filter(c -> (contactEmail == null || (c.getContactEmail() != null
						&& c.getContactEmail().toLowerCase().contains(contactEmail.toLowerCase()))))
				.collect(Collectors.toList());
	}

}
