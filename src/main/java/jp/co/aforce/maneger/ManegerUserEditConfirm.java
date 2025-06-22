package jp.co.aforce.maneger;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;

@WebServlet("/user-edit-confirm")
public class ManegerUserEditConfirm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");

			// 入力値を取得
			String memberId = request.getParameter("memberId");
			String lastName = request.getParameter("lastName");
			String firstName = request.getParameter("firstName");
			String address = request.getParameter("address");
			String mailAddress = request.getParameter("mailAddress");

			// UserBean にセット
			UserBean user = new UserBean();
			user.setMemberId(memberId);
			user.setLastName(lastName);
			user.setFirstName(firstName);
			user.setAddress(address);
			user.setMailAddress(mailAddress);

			// 更新処理
			UserDAO dao = new UserDAO();
			boolean success = dao.update(user);

			if (success) {
				request.setAttribute("user", user);
				request.getRequestDispatcher("/views/maneger/userEditSuccess.jsp").forward(request, response);
			} else {
				request.setAttribute("errorMessage", "更新に失敗しました。");
				request.getRequestDispatcher("/views/maneger/manegerUserEdit.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}
}