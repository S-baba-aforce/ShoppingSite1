package jp.co.aforce.manegerSongRegister;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ArtistBean;
import jp.co.aforce.dao.MusicDAO;

/**
 * Servlet implementation class SongAddConfirmServlet
 */
@WebServlet(urlPatterns = {"/views/songRegister/song-add"})
public class SongAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
            // アーティスト一覧を取得
            MusicDAO dao = new MusicDAO();
            List<ArtistBean> artistList = dao.getAllArtists();

            request.setAttribute("artistList", artistList);
            
            request.getRequestDispatcher("songAdd.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "アーティスト一覧の取得に失敗しました。");
            request.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(request, response);
        }
    }
	

	

}
