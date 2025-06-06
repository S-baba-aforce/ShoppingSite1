package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;

@WebServlet(urlPatterns = {"/views/login"})
public class LoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
	
		try {
			UserDAO dao = new UserDAO();
			UserBean customer = dao.search(id, password);
	
			if(customer != null) {
				String fullName = customer.getLastName() + customer.getFirstName();
 				HttpSession session = request.getSession();
				session.setAttribute("customer", customer);
				request.setAttribute("fullName", fullName);
				request.getRequestDispatcher("user-menu.jsp").forward(request, response);
			} else {
				response.sendRedirect("login-error.jsp");
			}
		} catch (Exception e){
		e.printStackTrace();
		response.sendRedirect("error.jsp");
		}
	}
}
