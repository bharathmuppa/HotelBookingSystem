package com.lucky.login.bean;

public class RoomResult {
	private int roomNo;
	private String area;
	private boolean ac;
	private boolean kitchen;
	private int price;
	@Override
	public String toString() {
		return "RoomResult [roomNo=" + roomNo + ", area=" + area + ", ac=" + ac + ", kitchen=" + kitchen + ", price="
				+ price + "]";
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public boolean isAc() {
		return ac;
	}
	public void setAc(boolean ac) {
		this.ac = ac;
	}
	public boolean isKitchen() {
		return kitchen;
	}
	public void setKitchen(boolean kitchen) {
		this.kitchen = kitchen;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	
}
