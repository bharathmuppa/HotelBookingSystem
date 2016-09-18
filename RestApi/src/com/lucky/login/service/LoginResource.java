package com.lucky.login.service;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.xml.bind.JAXBElement;

import com.lucky.login.bean.CommentsList;
import com.lucky.login.bean.Customer;
import com.lucky.login.bean.Login;
import com.lucky.login.bean.PostComment;
import com.lucky.login.bean.PostStatus;
import com.lucky.login.dao.LoginDAO;

@Path("login")
public class LoginResource {

	@Path("getLogin")
	@POST
	@Produces("application/json")

	public Customer getLogin(@Context HttpServletRequest request, @Context HttpServletResponse servletResponse,
			JAXBElement<Login> jaxLogin) {
		Login login = jaxLogin.getValue();
		LoginDAO loginDAO = new LoginDAO();

		Customer customer = loginDAO.login(login);
		if (customer.getCustomerId() != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", login.getEmail());
			System.out.println("session created with session ID" + session);
			return customer;
		}

		else {
			return customer;
		}
	}

	@Path("registerUser")
	@POST
	@Produces("application/json")

	public Customer registeruser(@Context HttpServletRequest request, @Context HttpServletResponse servletResponse,
			JAXBElement<Customer> jaxRegister) {
		Customer customer = jaxRegister.getValue();
		LoginDAO loginDAO = new LoginDAO();

		Customer customerNew = loginDAO.Register(customer);
		if (customerNew.getCustomerId() != 0) {
			HttpSession session = request.getSession();
			session.setAttribute("username", customerNew.getEmail());
			System.out.println("session created with session ID" + session);
			return customerNew;
		}

		else {
			return customerNew;
		}
	}


	@Path("sendMessage")
	@POST
	@Produces("application/json")

	public PostStatus sendMessage(JAXBElement<PostComment> jaxRegister) {
		PostComment postM = jaxRegister.getValue();
		LoginDAO loginDAO = new LoginDAO();
         PostStatus ps=new PostStatus();
		ps.setStatus(loginDAO.sendMsg(postM.getName(),postM.getNumber(),postM.getMessage()));
		return ps;
	}
	@Path("getMessages")
	@GET
	@Produces("application/json")

	public CommentsList sendMessage() {
		LoginDAO loginDAO = new LoginDAO();
		CommentsList cl=new CommentsList();
		
         cl.setPostComments(loginDAO.getMsg());
		return cl;
	}
		


	@Path("getamount")
	@GET
	public String getAmount(@Context HttpServletRequest request, @Context HttpServletResponse servletResponse,
			@QueryParam("username") String username) {
		LoginDAO loginDAO = new LoginDAO();
		HttpSession session = request.getSession(false);
		if (session != null) {
			String user = (String) session.getAttribute("username");
			int amount = 0;
			if (user.equals(username)) {
				amount = loginDAO.getAmount(username);
				System.out.println("session existed previously with user " + user);
				return amount + "";
			} else {
				System.out.println("session not at existed for your id");

			}
		}
		return "No session available";
	}

	@Path("logout")
	@GET
	public void logout(@Context HttpServletRequest request, @Context HttpServletResponse servletResponse,
			@QueryParam("username") String username) {
		
		HttpSession session = request.getSession(false);
		if (session != null) {
			String user = (String) session.getAttribute("username");
			if (user.equals(username)) {
				System.out.println("session existed previously with user     " + user);
				session.invalidate();
				System.out.println("logged out successfully");
			} else {
				System.out.println("session not at existed for your id");

			}
		}
	}

}
