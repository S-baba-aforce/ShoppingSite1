package jp.co.aforce.maneger;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.UserDAO;

@WebServlet("/user-delete-execute")
public class ManegerUserDeleteExecute extends HttpServlet {
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            request.setCharacterEncoding("UTF-8");
            String memberId = request.getParameter("member_id");

            UserDAO dao = new UserDAO();
            int result = dao.deleteUser(memberId);

            if (result > 0) {
                // 削除成功
                request.setAttribute("memberId", memberId);
                request.getRequestDispatcher("/views/maneger/userDeleteSuccess.jsp").forward(request, response);
            } else {
                // 削除失敗
                request.setAttribute("errorMessage", "削除に失敗しました。会員が存在しない可能性があります。");
                request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
        }
    }
}
