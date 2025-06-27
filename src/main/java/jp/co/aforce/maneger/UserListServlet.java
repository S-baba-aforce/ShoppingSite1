package jp.co.aforce.maneger;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.UserBean;
import jp.co.aforce.dao.UserDAO;

@WebServlet("/user-list")
public class UserListServlet extends HttpServlet {
	
  protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
    try {
      UserDAO dao = new UserDAO();
      List<UserBean> userList = dao.findAll(); 
      req.setAttribute("userList", userList);
      req.getRequestDispatcher("/views/maneger/userSearch.jsp").forward(req, res);
    } catch (Exception e) {
      e.printStackTrace();
      req.setAttribute("errorMessage", "エラーが発生しました：" + e.getMessage());
      req.getRequestDispatcher("/views/maneger/manegerError.jsp").forward(req, res);
    }
  }
}
