package com.lucky.login.service;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBElement;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.lucky.login.bean.*;
import com.lucky.login.dao.RoomDAO;

@Path("/Rooms")
public class RoomResource {
	@Path("/getRooms/{date}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)

	public RoomResultList getRooms(@Context HttpServletRequest request,@Context HttpServletResponse servletResponse, @PathParam("date") String date) throws JSONException {
		RoomDAO roomDAO = new RoomDAO();
		System.out.println(date);
		//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
			//Date sqlDate = Date.valueOf(date);
		
		ArrayList<RoomResult> roomsList = roomDAO.getRoomsList(date);
		
		RoomResultList rl = new RoomResultList();
		rl.setRoomResults(roomsList);
		//JSONObject js1=new JSONObject();
		//js1.put("getRooms", roomsList);
		return rl;
	}

	@Path("/getRooms")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
	public RoomResultList getPostRooms(@Context HttpServletRequest request,@Context HttpServletResponse servletResponse, JAXBElement<PostDate> date) throws JSONException {
		PostDate jo=date.getValue();
		String date1 = jo.getDate();
		RoomDAO roomDAO = new RoomDAO();
		System.out.println(date);
		//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		//Date sqlDate = Date.valueOf(date);
		
		ArrayList<RoomResult> roomsList = roomDAO.getRoomsList(date1);
		
		RoomResultList rl = new RoomResultList();
		rl.setRoomResults(roomsList);
		//JSONObject js1=new JSONObject();
		//js1.put("getRooms", roomsList);
		return rl;
	}
	@Path("/getBookedRooms")
	@POST
	@Produces("application/json")
	public BookedRoomsList getBookedRooms(JAXBElement<PostBookedRoom> bookedRoom){
	PostBookedRoom jo=bookedRoom.getValue();
	System.out.println(jo.getCustomerId());
	System.out.println(jo.getRole());
	RoomDAO roomDAO=new RoomDAO();
	ArrayList<BookRooms> roomsList = roomDAO.getBookedRooms(jo.getCustomerId(),jo.getRole());
	BookedRoomsList brl=new BookedRoomsList();
	brl.setBookedRoomsResult(roomsList);
	return brl;
	
	}
	@Path("/checkout/{transId}")
	@GET
	public PostStatus getBookedRooms(@PathParam("transId") int transId){
		//PostBookedRoom jo=bookedRoom.getValue();
		System.out.println(transId);
		RoomDAO roomDAO=new RoomDAO();
		PostStatus ps=new PostStatus();
		ps.setStatus(roomDAO.checkOutRoom(transId));
		return ps;
		
		}
	@Path("/getRoomDetails/{roomNo}")
	@GET
	@Produces("application/json")
	public RoomType getRoomType(@PathParam("roomNo") String roomNo){
	//PostBookedRoom jo=bookedRoom.getValue();
	RoomDAO roomDAO=new RoomDAO();
	RoomType rt = roomDAO.getRoomDetails(roomNo);
	return rt;
	
	}

	@Path("/bookRoom")
	@POST
	@Produces("application/json")
	public  PostStatus bookRoomType(JAXBElement<PostBookRoom> bookRoom){
	PostBookRoom jo=bookRoom.getValue();
	RoomDAO roomDAO=new RoomDAO();
	PostStatus ps=new PostStatus();
	ps.setStatus(roomDAO.bookRoom(jo.getCustomerId(),jo.getRoomNo(),jo.getDate(),jo.getDays()));
	return ps;
	
	}



}
