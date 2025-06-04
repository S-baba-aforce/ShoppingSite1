package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UserBean;

@WebServlet("/views/user-edition")
public class UserEditServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			//入力された情報を取得
			String lastName2 = request.getParameter("last_name");
			String firstName2 = request.getParameter("first_name");
			String address2 = request.getParameter("address");
			String mailAddress2 = request.getParameter("mail_address");
			
			HttpSession session = request.getSession();
			UserBean cb = (UserBean) session.getAttribute("customer");
			
			if (cb != null) {
				//編集用のユーザー情報を作成し、セッションに保存
				UserBean editCustomer = new UserBean();
                editCustomer.setMemberId(cb.getMemberId());
                editCustomer.setPassword(cb.getPassword());
                editCustomer.setLastName(lastName2);
                editCustomer.setFirstName(firstName2);
                editCustomer.setAddress(address2);
                editCustomer.setMailAddress(mailAddress2);
                
                session.setAttribute("editCustomer", editCustomer);

				request.getRequestDispatcher("/views/userEditConfirm.jsp").forward(request, response);	
				
			} else {
				response.sendRedirect("sessionError.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
	        response.sendRedirect("error.jsp");
		}
	}
}
