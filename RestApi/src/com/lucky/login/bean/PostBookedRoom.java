package com.lucky.login.bean;

public class PostBookedRoom {
private int customerId;
private String role;
@Override
public String toString() {
	return "PostBookedRoom [customerId=" + customerId + ", role=" + role + "]";
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
