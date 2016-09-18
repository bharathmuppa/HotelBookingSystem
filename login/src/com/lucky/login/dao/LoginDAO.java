package com.lucky.login.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.NamingException;

import com.lucky.login.bean.Customer;
import com.lucky.login.bean.Login;
import com.lucky.login.bean.PostComment;
import com.lucky.login.util.ConnectionPool;

public class LoginDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultset = null;
	int updateStatus;

	public Customer Register(Customer customer) {
		try {
			connection = ConnectionPool.getConnection();
			if (connection != null) {
				String qry = "insert into customers values(null,'" + customer.getFirstName() + "','"
						+ customer.getLastName() + "','" + customer.getPassword() + "','" + customer.getCountry()
						+ "','" + customer.getState() + "','" + customer.getCity() + "','" + customer.getMobileNo()
						+ "','C','" + customer.getEmail() + "')";

				System.out.println(qry);
				statement = connection.createStatement();
				updateStatus = statement.executeUpdate(qry);
				// Customer customer1=new Customer();
				if (updateStatus > 0) {
					Login lg = new Login();
					lg.setEmail(customer.getEmail());
					lg.setPassword(customer.getPassword());
					Customer customer1 = login(lg);
					return customer1;
				} else
					return customer;
			}
			return null;

		} catch (Exception e) {

		}
		return null;
	}

	public Customer login(Login login) {

		try {
			connection = ConnectionPool.getConnection();

			// connection=ConnectionFactory.getConnection();
			System.out.println("Connection established" + connection);

			if (connection != null) {
				String qry = "select * from customers where email='" + login.getEmail() + "' and pWord='"
						+ login.getPassword() + "'";

				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				Customer customer = new Customer();
				if (resultset.next()) {

					customer.setCustomerId(resultset.getInt(1));
					customer.setEmail(resultset.getString(10));
					customer.setFirstName(resultset.getString(2));
					customer.setRole(resultset.getString(9));
					return customer;
				} else
					return customer;
			}
			return null;

		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return null;

	}

	public int getAmount(String username) {
		try {
			connection = ConnectionPool.getConnection();

			// connection=ConnectionFactory.getConnection();
			System.out.println("Connection established" + connection);

			if (connection != null) {
				String qry = "select amount from login where username='" + username + "'";
				statement = connection.createStatement();
				resultset = statement.executeQuery(qry);
				if (resultset.next())
					return resultset.getInt("amount");
				else

					return 0;
			}
			return 0;

		} catch (Exception e) {
			System.out.println("exception occured" + e);
		}
		return 0;
	}

	public boolean sendMsg(String name, String number, String message)  {
		// TODO Auto-generated method stub
		
		try{
			
		connection=ConnectionPool.getConnection();
		if(connection!=null){
			String query="insert into comments values('"+name+"','"+number+"','"+message+"')";
            statement=connection.createStatement();
            updateStatus = statement.executeUpdate(query);
			// Customer customer1=new Customer();
			if (updateStatus > 0) {
				return true;
			} else
				return false;
		}
		}
		catch(Exception e){
			return false;
		}
		return false;
	}

	public ArrayList<PostComment> getMsg() {

		try{
		connection=ConnectionPool.getConnection();
		if(connection!=null){
			String query="select * from comments";
            statement=connection.createStatement();
            resultset = statement.executeQuery(query);
			// Customer customer1=new Customer();
            ArrayList<PostComment> pcl=new ArrayList<PostComment>();
			while(resultset.next()) {
				PostComment pc=new PostComment();
				pc.setName(resultset.getString(1));
				pc.setNumber(resultset.getString(2));
				pc.setMessage(resultset.getString(3));
				pcl.add(pc);
			} 
			return pcl;
		}
		}
		catch(Exception e){
			return null;
		}
		return null;
	}
}
