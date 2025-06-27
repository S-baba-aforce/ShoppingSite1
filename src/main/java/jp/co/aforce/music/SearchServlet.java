package jp.co.aforce.music;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.MusicDAO;


@WebServlet("/views/music/searchForm")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String type = request.getParameter("type");
        String query = request.getParameter("query");

        try {
            MusicDAO dao = new MusicDAO();
            List<MusicBean> resultList;
            
            //タイトル検索
            if ("title".equals(type)) {
                resultList = dao.searchByTitle(query);

                if (resultList.size() == 1) {
                    int musicId = resultList.get(0).getMusic_id();

                    response.sendRedirect(request.getContextPath() + "/views/music/aboutMusic?id=" + musicId);
                } else {
                    response.sendRedirect(request.getContextPath() + "/views/music/musicList.jsp?keyword=" + query);
                }
                
                //アーティスト検索の場合
            } else if ("artist".equals(type)) {
                resultList = dao.searchArtistName(query);

                if (resultList.size() == 1) {
                    int artist_id = resultList.get(0).getArtist_id(); 
                    
                    //アーティスト詳細へリダイレクト（AboutArtistServletに処理を任せる）
                    response.sendRedirect(request.getContextPath() + "/views/artist/aboutArtist?id=" + artist_id);
                    
                } else {
                	// 複数ヒット、または0件の場合はリストにリダイレクト
                    response.sendRedirect(request.getContextPath() + "/views/artist/artistList.jsp?keyword=" + query);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }
}
