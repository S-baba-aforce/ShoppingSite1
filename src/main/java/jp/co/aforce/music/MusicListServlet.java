package jp.co.aforce.music;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.SortDAO;

@WebServlet(urlPatterns = {"/views/music/musicList"})
public class MusicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
        	// 並べ替え条件（"new", "popular", "price_high", "price_low"）
            String sort = request.getParameter("sort");
            if (sort == null || sort.isEmpty()) {
                sort = "new";  // デフォルトは新着順
            }
            
            //新着楽曲一覧
            SortDAO dao = new SortDAO();
            List<MusicBean> musicList = dao.getMusicOrderBy(sort); // 新着10曲取得

            request.setAttribute("newMusicList", musicList);
            request.setAttribute("selectedSort", sort);

            // JSPへフォワード
            request.getRequestDispatcher("/views/music/musicList.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();  
        }
    }
}





