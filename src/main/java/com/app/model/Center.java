package com.app.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Document(collection = "training center") // Specifies the MongoDB collection name
public class Center {

	@Id // Marks this field as the primary key in MongoDB
	private String id;

	@NotBlank // Ensures the field is not null or empty
	@Size(max = 40) // Restricts the maximum length of center name
	private String centerName;

	@NotBlank
	@Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center code must be exactly 12 alphanumeric characters")
	private String centerCode;

	@NotNull // Ensures the address field is not null
	@Valid // Ensures validation rules for the Address class are applied
	private Address address;

	@Min(value = 1, message = "Student capacity must be at least 1")
	private int studentCapacity;

	private List<String> coursesOffered; // Stores the list of courses available at the center

	private LocalDateTime createdOn; // Stores the timestamp when the center is created

	@Email(message = "Invalid email format")
	private String contactEmail;

	@NotBlank
	@Pattern(regexp = "^\\d{10}$", message = "Invalid phone number")
	private String contactPhone;

	public Center() {
	}

	// Constructor to initialize fields
	public Center(String centerName, String centerCode, Address address, int studentCapacity,
			List<String> coursesOffered, LocalDateTime createdOn, String contactEmail, String contactPhone) {
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}

	// Getters and Setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public String getCenterCode() {
		return centerCode;
	}

	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public int getStudentCapacity() {
		return studentCapacity;
	}

	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}

	public List<String> getCoursesOffered() {
		return coursesOffered;
	}

	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	@Override
	public String toString() {
		return "Center [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode + ", address=" + address
				+ ", studentCapacity=" + studentCapacity + ", coursesOffered=" + coursesOffered + ", createdOn="
				+ createdOn + ", contactEmail=" + contactEmail + ", contactPhone=" + contactPhone + "]";
	}
}
