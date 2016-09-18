package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Register {
	private String firstName;
	private String lastName;
	private String password;
	private int pincode;
	private String country;
	private String state;
	private String city;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Register [firstName=" + firstName + ", lastName=" + lastName + ", password=" + password + ", pincode="
				+ pincode + ", country=" + country + ", state=" + state + ", city=" + city + "]";
	}

}
