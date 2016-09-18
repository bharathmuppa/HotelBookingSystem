package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookRooms {
	
private int roomNo;
private int customerId;
private String bookedFrom;
private String bookedTo;
private int days;
private int price;
private int transid;
public int getTransid() {
	return transid;
}
public void setTransid(int transid) {
	this.transid = transid;
}
public int getRoomNo() {
	return roomNo;
}
public void setRoomNo(int roomNo) {
	this.roomNo = roomNo;
}
public int getCustomerId() {
	return customerId;
}
public void setCustomerId(int customerId) {
	this.customerId = customerId;
}
public String getBookedFrom() {
	return bookedFrom;
}
public void setBookedFrom(String bookedFrom) {
	this.bookedFrom = bookedFrom;
}
public String getBookedTo() {
	return bookedTo;
}
public void setBookedTo(String bookedTo) {
	this.bookedTo = bookedTo;
}
public int getDays() {
	return days;
}
public void setDays(int days) {
	this.days = days;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
@Override
public String toString() {
	return "BookRooms [roomNo=" + roomNo + ", customerId=" + customerId + ", bookedFrom=" + bookedFrom + ", bookedTo="
			+ bookedTo + ", days=" + days + ", price=" + price + ", transid=" + transid + "]";
}




}
