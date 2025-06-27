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

@WebServlet("/payment-confirm")
public class PaymentConfirmServlet extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	        throws ServletException, IOException {
//
//		String action = request.getParameter("action");
//
//	    if ("backToCart".equals(action)) {
//	        // セッションが保持されたまま、カート画面へ
//	    	System.out.println("カートに戻る処理発動");
//	        request.getRequestDispatcher("/views/purchase/cart.jsp").forward(request, response);
//	    } else {
//	        // それ以外のGETは直接アクセスなどと見なす
//	        response.sendRedirect(request.getContextPath() + "/views/music/musicTop.jsp");
//	    }
//	 }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        HttpSession session = request.getSession();
        
//        String memberId = (String) session.getAttribute("memberId"); // ログイン済みの会員ID
//        System.out.println("memberid" + memberId);
        
        //支払い方法の取得
        String paymentMethod = request.getParameter("paymentMethod");
        
        @SuppressWarnings("unchecked")
        List<MusicBean> cartItems = (List<MusicBean>) session.getAttribute("cartItems");

        if (cartItems == null || cartItems.isEmpty()) {
        	request.setAttribute("error", "カートが空です。商品を追加してください。");
        	response.sendRedirect(request.getContextPath() + "/views/purchase/cart.jsp");
            return;
        }

        //合計金額の計算
        int total = cartItems.stream().mapToInt(MusicBean::getPrice).sum();
        if ("convenience".equals(paymentMethod)) {
            total += 300;
        }

        session.setAttribute("paymentMethod", paymentMethod);
        session.setAttribute("totalAmount", total);

        request.getRequestDispatcher("/views/purchase/paymentConfirm.jsp").forward(request, response);
    }
}
