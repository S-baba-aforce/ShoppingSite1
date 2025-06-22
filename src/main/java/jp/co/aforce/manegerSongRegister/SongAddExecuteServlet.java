package jp.co.aforce.manegerSongRegister;

import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import jp.co.aforce.dao.AdminDAO;


@WebServlet(urlPatterns = {"/views/songRegister/song-add-confirm"})
@MultipartConfig
public class SongAddExecuteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");

            // フォームデータの取得
            int musicId = Integer.parseInt(request.getParameter("music_id"));
            String title = request.getParameter("title");
            int artistId = Integer.parseInt(request.getParameter("artist_id"));
            String genre = request.getParameter("genre");
            int price = Integer.parseInt(request.getParameter("price"));
            String description = request.getParameter("description");

            // ファイル名の取得（アップロード処理は省略）
            Part filePart = request.getPart("file_path");
            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // DAOを使って登録処理
            AdminDAO dao = new AdminDAO();
            boolean success = dao.addMusic(musicId, title, artistId, genre, price, fileName, description);

            if (success) {
                request.getRequestDispatcher("songAddSuccess.jsp").forward(request, response);
            } else {
                request.setAttribute("errorMessage", "楽曲の登録に失敗しました。");
                request.getRequestDispatcher("/views/error.jsp").forward(request, response);
            }

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
    }
}