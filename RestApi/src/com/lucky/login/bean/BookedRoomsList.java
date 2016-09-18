package com.lucky.login.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BookedRoomsList {
ArrayList<BookRooms> bookedRoomsResult;

@Override
public String toString() {
	return "BookedRoomsList [bookedRoomsResult=" + bookedRoomsResult + "]";
}

public ArrayList<BookRooms> getBookedRoomsResult() {
	return bookedRoomsResult;
}

public void setBookedRoomsResult(ArrayList<BookRooms> bookedRoomsResult) {
	this.bookedRoomsResult = bookedRoomsResult;
}

}
