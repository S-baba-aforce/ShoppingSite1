package jp.co.aforce.maneger;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.AdminBean;
import jp.co.aforce.dao.AdminDAO;


@WebServlet(urlPatterns = {"/views/maneger/maneger-login"})
public class AdminLoginServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        // 入力値の取得
        int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("password");

        try {
            AdminDAO dao = new AdminDAO();
            AdminBean admin = dao.findByLogin(id, password);

            if (admin != null) {
                // ログイン成功
                HttpSession session = request.getSession();
                session.setAttribute("admin", admin);
                request.getRequestDispatcher("manegerMenu.jsp").forward(request, response);
                

            } else {
                // ログイン失敗
                request.setAttribute("errorMessage", "ユーザー名またはパスワードが間違っています。");
                request.getRequestDispatcher("manegerLogin.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "システムエラーが発生しました。");
            request.getRequestDispatcher("manegerLogin.jsp").forward(request, response);
        }
    }
}
