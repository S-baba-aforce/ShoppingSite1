package jp.co.aforce.manegerSongDelete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.AdminDAO;

@MultipartConfig
@WebServlet(urlPatterns = {"/views/songDeleteBox/song-delete-execute"})
public class SongDeleteExecuteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");

            // フォームから受け取る music_id
            int music_id = Integer.parseInt(request.getParameter("music_id"));

            // DAOで削除処理
            AdminDAO dao = new AdminDAO();
            boolean success = dao.deleteMusicById(music_id);

            if (success) {
                // 削除成功時
                request.getRequestDispatcher("/views/songDeleteBox/songDeleteSuccess.jsp").forward(request, response);
            } else {
                // 削除失敗時（存在しないなど）
                request.setAttribute("errorMessage", "削除に失敗しました。対象の楽曲が存在しない可能性があります。");
                request.getRequestDispatcher("/views/songDeleteBox/dustSongSearch.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
        }
    }
}
