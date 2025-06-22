package jp.co.aforce.maneger;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;

@WebServlet("/user-delete-confirm")
public class ManegerUserDeleteConfirm extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");

            // member_id を取得
            String memberId = request.getParameter("id");

            // ユーザー情報を取得
            UserDAO dao = new UserDAO();
            UserBean user = dao.findUserById(memberId);

            if (user != null) {
                request.setAttribute("user", user);
                request.getRequestDispatcher("/views/maneger/userDeleteConfirm.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "該当するユーザーが見つかりませんでした。");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}
