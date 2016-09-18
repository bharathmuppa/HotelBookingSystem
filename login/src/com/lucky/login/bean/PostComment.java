package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PostComment {
private String name;
private String number;
private String message;
@Override
public String toString() {
	return "PostComment [name=" + name + ", number=" + number + ", message=" + message + "]";
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNumber() {
	return number;
}
public void setNumber(String number) {
	this.number = number;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
