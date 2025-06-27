package jp.co.aforce.purchase;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.beans.PurchaseBean;
import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.PurchaseDAO;

@WebServlet("/payment-success")
public class PaymentSuccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        List<MusicBean> cartItems = (List<MusicBean>) session.getAttribute("cartItems");
        System.out.println("cartItems" + cartItems);
        
        UserBean customer = (UserBean) session.getAttribute("customer");
        
		String memberId = customer.getMemberId();
		System.out.println("Member ID: " + memberId);

        String paymentMethod = (String)session.getAttribute("paymentMethod");

//        if (cartItems == null || cartItems.isEmpty()) {
//            response.sendRedirect(request.getContextPath() + "/views/purchase/cart.jsp"); // 異常系：カートが空 or 未ログイン
//            return;
//        }

        try {
            PurchaseDAO dao = new PurchaseDAO();

            for (MusicBean music : cartItems) {
                PurchaseBean purchase = new PurchaseBean();
                purchase.setMemberId(memberId);
                purchase.setMusic_id(music.getMusic_id());
                purchase.setAmount(1); // 常に1曲ずつの仕様
                System.out.println("Adding: memberId=" + memberId + ", music_id=" + music.getMusic_id());
                
                boolean success = dao.insert(purchase);
                
                if (!success) {
                	throw new Exception("DB挿入に失敗しました（music_id: " + music.getMusic_id() + "）");
                }	
                	session.removeAttribute("cartItems");
            }
            
            // 完了画面へ
            request.setAttribute("purchasedItems", cartItems);
            request.setAttribute("paymentMethod", paymentMethod);
            request.getRequestDispatcher("/views/purchase/paymentSuccess.jsp").forward(request, response);
            // セッションのカート初期化
            
//            session.removeAttribute("cartItems");
//
//            // 完了画面へ
//            request.setAttribute("purchasedItems", cartItems);
//            request.setAttribute("paymentMethod", paymentMethod);
//            request.getRequestDispatcher("/views/purchase/paymentSuccess.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(500, "購入処理中にエラーが発生しました。");
        }
    }
}
