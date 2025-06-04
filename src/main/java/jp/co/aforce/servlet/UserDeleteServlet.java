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

@WebServlet("/views/user-delete-confirm")
public class UserDeleteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String confirm = request.getParameter("confirm");
		HttpSession session = request.getSession();
		UserBean customer = (UserBean) session.getAttribute("customer");
		
		if ("はい".equals(confirm)) {
			try {
				UserDAO dao = new UserDAO();
				dao.deleteUser(customer.getMemberId());
				session.invalidate();   //セッション破棄
				request.getRequestDispatcher("/views/userDeleteSuccess.jsp").forward(request, response);	
			} catch (Exception e) {
				e.printStackTrace();
				response.sendRedirect("error.jsp");
			}
		} else {
			response.sendRedirect("user-menu.jsp");
		}
	}
}
