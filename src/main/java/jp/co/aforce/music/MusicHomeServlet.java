package jp.co.aforce.music;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.MusicDAO;


@WebServlet(urlPatterns = {"/views/music-home"})
public class MusicHomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			HttpSession session = request.getSession(false);
			UserBean loginUser = null;
			
			if (session != null) {
				//セッションにユーザー情報がある場合
				loginUser =(UserBean)session.getAttribute("customer");
			}
			
			//ログインユーザー情報をリクエストスコープに渡す
			request.setAttribute("loginUser", loginUser);
				
				
			MusicDAO dao = new MusicDAO();
			
			//新着楽曲を取得
			List<MusicBean>newMusicList = dao.findNewMusic();
			
			//人気楽曲を取得
			List<MusicBean>popularMusicList = dao.findPopularMusic();
			
			request.setAttribute("newMusicList", newMusicList);
			request.setAttribute("popularMusicList",popularMusicList);
			request.getRequestDispatcher("/views/music/musicHome.jsp").forward(request, response);
			
			System.out.println("Servlet reached. Forwarding to musicHome.jsp...");

			
		} catch (Exception e){
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
}
