package jp.co.aforce.manegerSongEdit;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import jp.co.aforce.dao.AdminDAO;

@MultipartConfig
@WebServlet(urlPatterns = {"/views/songEditor/song-edit-execute"})
public class SongEditExecuteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");

            int musicId = Integer.parseInt(request.getParameter("music_id"));
            int artistId = Integer.parseInt(request.getParameter("artist_id"));
            String title = request.getParameter("title");
            String genre = request.getParameter("genre");
            int price = Integer.parseInt(request.getParameter("price"));
            String description = request.getParameter("description");

            // アップロードされたファイル（オプション）
            Part filePart = request.getPart("file_path");
            String filePath = null;

            if (filePart != null && filePart.getSize() > 0) {
                // ファイル名を取得
                String fileName = new File(filePart.getSubmittedFileName()).getName();
                
                // 保存先のパス（サーバー上の任意のディレクトリに調整）
                String uploadDir = getServletContext().getRealPath("/uploads");
                File uploadDirFile = new File(uploadDir);
                if (!uploadDirFile.exists()) {
                    uploadDirFile.mkdirs();
                }

                filePath = "uploads/" + fileName; // DBに保存するパス
                filePart.write(uploadDir + File.separator + fileName);
            }

            // DAOを使って更新
            AdminDAO dao = new AdminDAO();
            boolean success = dao.updateMusic(musicId, title, artistId, genre, price, filePath, description);

            if (success) {
                request.setAttribute("message", "楽曲情報を更新しました。");
            } else {
                request.setAttribute("message", "更新に失敗しました。");
            }

            request.getRequestDispatcher("/views/songEditor/songEditSuccess.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
        }
    }
}
