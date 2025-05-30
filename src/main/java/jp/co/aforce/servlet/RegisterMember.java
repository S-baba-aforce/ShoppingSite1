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

/**
 * Servlet implementation class RegisterMember
 */
@WebServlet("/views/register-member")
public class RegisterMember extends HttpServlet {
	
	// 新規会員登録画面への遷移
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/member-home.jsp").forward(request, response);
    }
	
	
	// 会員情報を登録
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			CustomerBean cb = new CustomerBean();
			cb.setMemberId(request.getParameter("member_id"));
			cb.setPassword(request.getParameter("password"));
			cb.setLastName(request.getParameter("last_name"));
			cb.setFirstName(request.getParameter("first_name"));
			cb.setAddress(request.getParameter("address"));
			cb.setMailAddress(request.getParameter("mail_address"));
			
			CustomerDAO dao = new CustomerDAO();
			
			int result = dao.insert(cb);
			
			if (result > 0) {
				//登録成功→セッションに保存し、user-menu.jspへ
				HttpSession session = request.getSession();
                session.setAttribute("customer", cb);
				request.getRequestDispatcher("/views/user-menu.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/views/register-error.jsp").forward(request, response);
			}
		}
			
			catch (Exception e){
				System.out.println(e);
				e.printStackTrace();
				request.getRequestDispatcher("/views/error.jsp").forward(request, response);
				
			}
		}
		

}
