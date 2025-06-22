package jp.co.aforce.artist;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ArtistBean;
import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.MusicDAO;

@WebServlet("/views/artist/aboutArtist")
public class AboutArtistServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int artist_id = Integer.parseInt(request.getParameter("id"));
            
            System.out.println("id" + artist_id);

            MusicDAO dao = new MusicDAO();
            ArtistBean artist = dao.getArtistById(artist_id);
            List<MusicBean> popularSongs = dao.getPopularSongsByArtist(artist_id, 5);

            request.setAttribute("artist", artist);
            request.setAttribute("popularSongs", popularSongs);
            request.getRequestDispatcher("/views/artist/aboutArtist.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "アーティスト情報の取得に失敗しました。");
        }
    }
}
