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

@WebServlet("/views/user-add")
public class UserAddServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession();
			UserBean cb = (UserBean) session.getAttribute("customer");

			UserDAO dao = new UserDAO();
			boolean isRegisterd = dao.insert(cb);
			
			if (isRegisterd) {
				session.removeAttribute("customer");
				request.getRequestDispatcher("/views/userSuccess.jsp").forward(request, response);
			} else {
				request.setAttribute("error", "入力したユーザーIDとパスワードは、すでに登録済みです。");
				request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "登録時にエラーが発生しました。");
			request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
		}
	}
}
