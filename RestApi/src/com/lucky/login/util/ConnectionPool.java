package com.lucky.login.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool 
{
	private static DataSource dataSource;
	private static Connection connection=null;
 public static Connection getConnection() throws NamingException,SQLException
 {
	     // Get DataSource
         Context initContext  = new InitialContext();
         Context envContext  = (Context)initContext.lookup("java:/comp/env");
         dataSource = (DataSource)envContext.lookup("jdbc/login");
         //get connection
         connection=dataSource.getConnection();
         return connection;
 }
 public static void closeConnection(ArrayList<Connection> alc,ArrayList<Statement> als,ArrayList<ResultSet> alr) throws SQLException
 {
 	try
 	{
 	for(ResultSet resultSet:alr)
     	if(resultSet!=null)resultSet.close();
 	for(Statement statement:als)
 		if(statement!=null)statement.close();
 	for(Connection connection:alc)
 		if(connection!=null)connection.close();
 	
 	}
 	catch(SQLException e)
 	{
 		System.out.println("PROBLEM IN LOGIN");
			e.printStackTrace();
			throw e;	
 	}
 }
}
