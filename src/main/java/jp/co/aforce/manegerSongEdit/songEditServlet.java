package jp.co.aforce.manegerSongEdit;

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
@WebServlet(urlPatterns = {"/views/songEditor/song-update"})
public class songEditServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            request.setCharacterEncoding("UTF-8");

            // パラメータ（music_id）取得
            int musicId = Integer.parseInt(request.getParameter("music_id"));

            // DAOから楽曲情報を取得
            AdminDAO dao = new AdminDAO();
            MusicBean music = dao.getMusicById(musicId);

            if (music != null) {
                request.setAttribute("music", music);
                request.getRequestDispatcher("/views/songEditor/songEdit.jsp").forward(request, response);
            } 
            
            System.out.println("music_id: " + musicId);
            System.out.println("music: " + (music != null ? music.getTitle() : "null"));

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
            request.getRequestDispatcher("/views/error.jsp").forward(request, response);
        }
	}

	

}
