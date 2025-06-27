package jp.co.aforce.purchase;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.MusicBean;

@WebServlet("/views/purchase/cart-delete")
public class CartDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		int musicId = Integer.parseInt(request.getParameter("music_id"));

		HttpSession session = request.getSession();
		List<MusicBean> cartItems = (List<MusicBean>) session.getAttribute("cartItems");

		if (cartItems != null) {
			Iterator<MusicBean> iterator = cartItems.iterator();
			while (iterator.hasNext()) {
				MusicBean item = iterator.next();
				if (item.getMusic_id() == musicId) { // ← music_id に合わせる
					iterator.remove();
					break;
				}
			}
		}

		// セッション更新（再設定）
		session.setAttribute("cartItems", cartItems);

		// cart.jsp へリダイレクト（画面更新）
		response.sendRedirect("cart.jsp");
	}
}
