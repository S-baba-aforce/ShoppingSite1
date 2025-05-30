package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.CustomerBean;
import jp.co.aforce.dao.CustomerDAO;


@WebServlet(urlPatterns = {"/views/login"})
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		try {
			CustomerDAO dao = new CustomerDAO();
			CustomerBean customer = dao.search(id, password);
	
			if(customer != null) {
				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				response.sendRedirect("user-menu.jsp");
			} else {
				response.sendRedirect("login-error.jsp");
			}
		} catch (Exception e){
		e.printStackTrace();
		response.sendRedirect("error.jsp");
		}
		
	}
	
}
