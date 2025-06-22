package jp.co.aforce.artist;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.ArtistBean;
import jp.co.aforce.dao.SortDAO;


@WebServlet(urlPatterns = {"/views/artist/artistList"})
public class ArtistListServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        try {
        	 String sort = request.getParameter("sort");
             if (sort == null || sort.isEmpty()) {
                 sort = "new"; // デフォルトは新着順
             }
            SortDAO dao = new SortDAO();
            List<ArtistBean> artists = dao.getArtistOrderBy(sort); 

            request.setAttribute("newArtistList", artists);
            request.setAttribute("selectedSort", sort);
            request.getRequestDispatcher("/views/artist/artistList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "アーティストの取得に失敗しました。");
        }
    }

	
}
