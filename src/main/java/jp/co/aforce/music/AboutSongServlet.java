package jp.co.aforce.music;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.MusicDAO;

@WebServlet("/views/music/aboutMusic")
public class AboutSongServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            MusicDAO dao = new MusicDAO();
            MusicBean music = dao.findById(id);
            
            if (music != null) {
                request.setAttribute("music", music);
                request.getRequestDispatcher("/views/music/aboutMusic.jsp").forward(request, response);
            } else {
                response.sendRedirect("musicList.jsp"); // 該当データなし
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("musicList.jsp");
        }
    }
}