package jp.co.aforce.purchase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.MusicDAO;

@WebServlet("/cart-add")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            request.setCharacterEncoding("UTF-8");

            int music_id = Integer.parseInt(request.getParameter("music_id"));
            MusicDAO dao = new MusicDAO();
            MusicBean music = dao.findById(music_id);  

            HttpSession session = request.getSession();
//            UserBean customer = (UserBean) session.getAttribute("customer");
//            if (customer != null) {
//                String memberId = customer.getMemberId();
//                System.out.println("Member ID: " + memberId);
//            }
            List<MusicBean> cartItems = (List<MusicBean>) session.getAttribute("cartItems");

            if (cartItems == null) {
                cartItems = new ArrayList<>();
                session.setAttribute("cartItems", cartItems);
            }

            // 同じ曲は追加しない（重複防止）
            boolean alreadyInCart = cartItems.stream()
                .anyMatch(item -> item.getMusic_id() == music_id);

            if (!alreadyInCart) {
                cartItems.add(music);
            }
            
            // 合計金額を計算してセッションに格納
            int totalPrice = 0;
            for (MusicBean item : cartItems) {
                totalPrice += item.getPrice();
            }
            session.setAttribute("totalPrice", totalPrice);

            // カート画面に遷移
            response.sendRedirect(request.getContextPath() + "/views/purchase/cart.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "カートへの追加に失敗しました。");
        }
    }
}
