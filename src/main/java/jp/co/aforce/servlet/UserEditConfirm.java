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

@WebServlet("/views/user-edit-confirm")
public class UserEditConfirm extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserBean editCustomer = (UserBean) session.getAttribute("editCustomer");
		
		//セッションチェック
		if (editCustomer == null) {
			System.out.println("セッションがnullです");
			request.getRequestDispatcher("/views/sessionError.jsp").forward(request, response);
			return;
		}
		
		System.out.println("更新");
		
		try {
			UserDAO dao = new UserDAO();
			boolean success = dao.update(editCustomer);  //boolean 戻り値で更新実行
			
			if (!success) {
				request.setAttribute("error", "登録エラー");
				request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
				return;
			}
			
			//成功したらセッションのcustomerを更新し、editorCustomerを削除
			session.setAttribute("customer", editCustomer);
			session.removeAttribute("editCustomer");
			
			request.getRequestDispatcher("/views/userEditSuccess.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", "予期せぬエラーが発生しました。");
			request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
		}

	}		
}
