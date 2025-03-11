package com.app.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Address {
    @NotBlank(message = "Detailed address cannot be blank")
    private String detailedAddress;
    
    @NotBlank(message = "City cannot be blank")
    private String city;
    
    @NotBlank(message = "State cannot be blank")
    private String state;
    
    @NotBlank
    @Pattern(regexp = "^\\d{6}$", message = "Invalid pincode format")
    private String pincode;

	public Address() {
		super();
	}

	public Address(String detailedAddress, String city, String state, String pincode) {
		super();
		this.detailedAddress = detailedAddress;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getDetailedAddress() {
		return detailedAddress;
	}

	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [detailedAddress=" + detailedAddress + ", city=" + city + ", state=" + state + ", pincode="
				+ pincode + "]";
	}
}
