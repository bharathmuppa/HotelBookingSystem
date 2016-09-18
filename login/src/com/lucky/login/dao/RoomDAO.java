package com.lucky.login.dao;

import com.lucky.login.bean.*;
import com.lucky.login.util.ConnectionPool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

public class RoomDAO {
	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	int updateStatus;

	public ArrayList<RoomResult> getRoomsList(String date1) {

		try {
			connection = ConnectionPool.getConnection();

			// connection=ConnectionFactory.getConnection();
			System.out.println("Connection established" + connection);
			ArrayList<RoomResult> result = new ArrayList<RoomResult>();
			if (connection != null) {

				String qry = "select a.roomNo , c.area, c.ac, c.kitchen,c.price from room as a LEFT OUTER JOIN roomType as c on a.typeId = c.typeId where a.roomNo not in (select roomNo from bookedRooms where bookedOn ='"
						+ date1 + "')";

				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				while (resultset.next()) {
					RoomResult roomResult = new RoomResult();
					roomResult.setRoomNo(resultset.getInt(1));
					roomResult.setArea(resultset.getString(2));
					roomResult.setAc(resultset.getBoolean(3));
					roomResult.setKitchen(resultset.getBoolean(4));
					roomResult.setPrice(resultset.getInt(5));
					result.add(roomResult);
				}
				return result;
			}

		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;

	}

	public RoomType getRoomType(int typeId) {
		try {
			connection = ConnectionPool.getConnection();
			if (connection != null) {
				String qry = "select * from roomType where typeId=" + typeId;
				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				RoomType result = new RoomType();
				if (resultset.next()) {
					result.setTypeId(resultset.getInt(1));
					result.setSize(resultset.getString(2));
					result.setAc(resultset.getString(3));
					result.setKitchen(resultset.getString(4));
					result.setPrice(resultset.getInt(5));
				}
				return result;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;

	}

	public RoomType getRoomDetails(String roomNo) {
		try {
			connection = ConnectionPool.getConnection();
			if (connection != null) {
				String qry = "select typeId from room where roomNo=" + roomNo;
				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				RoomType result = new RoomType();
				if (resultset.next()) {
					result = getRoomType(resultset.getInt(1));
				}
				return result;
			}
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return null;
	}

	public ArrayList<BookRooms> getBookedRooms(int id, String role) {

		try {
			connection = ConnectionPool.getConnection();

			// connection=ConnectionFactory.getConnection();
			System.out.println("Connection established" + connection);
			ArrayList<BookRooms> result = new ArrayList<BookRooms>();
			if (connection != null) {
				

				 if (role.equalsIgnoreCase("M")) {
                     id=0;
				 }
              
				 String qry = "CALL checkoutlist("+id+")";
				System.out.println(qry);
				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				while (resultset.next()) {
					BookRooms roomResult = new BookRooms();
					roomResult.setRoomNo(resultset.getInt(1));
					roomResult.setBookedFrom(resultset.getString(2));
					roomResult.setDays(resultset.getInt(4));
					roomResult.setBookedTo(resultset.getString(3));
					roomResult.setCustomerId(resultset.getInt(5));
					roomResult.setPrice(resultset.getInt(6));
					roomResult.setTransid(resultset.getInt(7));
					result.add(roomResult);
				}
				return result;
			}

		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;

	}

	public int getMaxTransId() {
		try {
			connection = ConnectionPool.getConnection();
			if (connection != null) {
				String qry = "select max(transid)+1 from bookedRooms";
				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				int maxTransId=1;
				if (resultset.next()) {
					maxTransId= resultset.getInt(1);
				}
				
				return maxTransId;
			}
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		return 0;
          
	}

	public boolean bookRoom(int customerId, int roomNo, String date, int j) {
		// TODO Auto-generated method stub
		try {
			connection = ConnectionPool.getConnection();

			// connection=ConnectionFactory.getConnection();
			System.out.println("Connection established" + connection);
			ArrayList<BookRooms> result = new ArrayList<BookRooms>();
			if (connection != null) {
				String qry="insert into bookedRooms values";
				
				int maxTransId=getMaxTransId();
				if(maxTransId==0){
					System.out.println("Unable to connect to db for max transid");
					return false;
				}
				
				for(int i=0;i<j;i++){
					String dt = date;  // Start date
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Calendar c = Calendar.getInstance();
					c.setTime(sdf.parse(dt));
					c.add(Calendar.DATE, i);  // number of days to add
					dt = sdf.format(c.getTime());
					qry=qry+"("+roomNo+",'"+dt+"',"+customerId+","+maxTransId+"),";
				}
				qry=qry.substring(0,qry.length()-1);
				//String qry="insert into bookedRooms values("+101+","+(CURDATE()+1)+","+5+","+10+")";
				statement = connection.createStatement();
				updateStatus = statement.executeUpdate(qry);
				// Customer customer1=new Customer();
				if (updateStatus > 0) {
					return true;
				} else
					return false;
			}			

		} catch (Exception e) {
			System.out.println("exception occured" + e);
			return false;
		}
		return false;
	}

	public boolean checkOutRoom(int transId) {
		// TODO Auto-generated method stub
				try {
					connection = ConnectionPool.getConnection();

					// connection=ConnectionFactory.getConnection();
					System.out.println("Connection established" + connection);
					ArrayList<BookRooms> result = new ArrayList<BookRooms>();
					if (connection != null) {
						String qry="delete from bookedRooms where transID="+transId;
					    statement = connection.createStatement();
						updateStatus = statement.executeUpdate(qry);
						// Customer customer1=new Customer();
						if (updateStatus > 0) {
							return true;
						} else
							return false;
					}			

				} catch (Exception e) {
					System.out.println("exception occured" + e);
					return false;
				}
				return false;

	}

	// insert into bookedRooms values(101,CURDATE()+1,5,10)
}
