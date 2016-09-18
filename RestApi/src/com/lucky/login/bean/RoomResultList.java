package com.lucky.login.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoomResultList {

	private ArrayList<RoomResult> roomResults;

	@Override
	public String toString() {
		return "RoomResultList [roomResults=" + roomResults + "]";
	}

	public ArrayList<RoomResult> getRoomResults() {
		return roomResults;
	}

	public void setRoomResults(ArrayList<RoomResult> roomResults) {
		this.roomResults = roomResults;
	}
	
	
	
	
}
