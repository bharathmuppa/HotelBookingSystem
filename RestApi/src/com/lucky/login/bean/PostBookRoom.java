package com.lucky.login.bean;

public class PostBookRoom {
    private int roomNo;
	private int customerId;
    private String date;
    private int days;
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "PostBookRoom [roomNo=" + roomNo + ", customerId=" + customerId + ", date=" + date + ", days=" + days
				+ "]";
	}
}
