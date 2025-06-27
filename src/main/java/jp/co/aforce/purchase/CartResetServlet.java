package jp.co.aforce.purchase;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/views/purchase/cart-reset")
public class CartResetServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		// カート内を削除（cartItemsをremove）
		session.removeAttribute("cartItems");

		// カートページにリダイレクト
		response.sendRedirect("cart.jsp");
	}
}
