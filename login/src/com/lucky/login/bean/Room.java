package com.lucky.login.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Room {
	private int roomNo;
	private int floorNO;
	private RoomType roomType;

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getFloorNO() {
		return floorNO;
	}

	public void setFloorNO(int floorNO) {
		this.floorNO = floorNO;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public String toString() {
		return "Room [roomNo=" + roomNo + ", floorNO=" + floorNO + ", roomType=" + roomType + "]";
	}

}
