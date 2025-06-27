package jp.co.aforce.manegerSongDelete;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.AdminDAO;

@MultipartConfig
@WebServlet(urlPatterns = {"/views/songDeleteBox/song-erace"})
public class SongDeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            request.setCharacterEncoding("UTF-8");

            // パラメータ（music_id）取得
            int music_id = Integer.parseInt(request.getParameter("music_id"));

            // DAOから楽曲情報を取得
            AdminDAO dao = new AdminDAO();
            MusicBean music = dao.getMusicById(music_id);

            if (music != null) {
                request.setAttribute("music", music);
                request.getRequestDispatcher("/views/songDeleteBox/songDelete.jsp").forward(request, response);
            }
		 } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
	            request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
		 }       
	}

}
