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

@WebServlet("/payment")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        @SuppressWarnings("unchecked")
        List<MusicBean> cartItems = (List<MusicBean>) session.getAttribute("cartItems");

        if (cartItems == null || cartItems.isEmpty()) {
            response.sendRedirect("cart.jsp");
            return;
        }

//        // 支払い方法取得
//        String paymentMethod = request.getParameter("paymentMethod");
//
//        // 合計金額計算
//        int total = cartItems.stream().mapToInt(MusicBean::getPrice).sum();
//
//        // コンビニ支払いなら300円追加
//        if ("convenience".equals(paymentMethod)) {
//            total += 300;
//        }
//
//        // JSPに渡す
//        request.setAttribute("paymentMethod", paymentMethod);
//        request.setAttribute("totalAmount", total);
//        request.setAttribute("cartItems", cartItems); 

        request.getRequestDispatcher("/views/purchase/payment.jsp").forward(request, response);
    }
}
