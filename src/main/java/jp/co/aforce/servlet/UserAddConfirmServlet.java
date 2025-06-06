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

@WebServlet("/views/register-member")
public class UserAddConfirmServlet extends HttpServlet {
	
	// 新規会員登録画面への遷移
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/views/userAdd.jsp").forward(request, response);
    }
	
	// 会員情報を登録
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			request.setCharacterEncoding("UTF-8");
			
			UserBean cb = new UserBean();
			cb.setMemberId(request.getParameter("member_id"));
			cb.setPassword(request.getParameter("password"));
			cb.setLastName(request.getParameter("last_name"));
			cb.setFirstName(request.getParameter("first_name"));
			cb.setAddress(request.getParameter("address"));
			cb.setMailAddress(request.getParameter("mail_address"));
			
			UserDAO dao = new UserDAO();
			
			//重複チェック
			boolean canRegister = dao.checkDuplicate(cb);
			
			if (canRegister) {
				//セッションに保存して確認画面へ
				HttpSession session = request.getSession();
                session.setAttribute("customer", cb);
                request.getRequestDispatcher("/views/userAddConfirm.jsp").forward(request, response);
			} else {
				//エラーメッセージをセット、エラー画面へ
				request.setAttribute("errorMessage", "入力したユーザーIDとパスワードは、すでに登録済みです。");
				request.getRequestDispatcher("/views/login-error.jsp").forward(request, response);
			}
						
		} catch (Exception e){
			e.printStackTrace();
			request.getRequestDispatcher("/views/error.jsp").forward(request, response);
		}
	}
}
