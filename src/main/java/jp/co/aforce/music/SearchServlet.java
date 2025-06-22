package jp.co.aforce.music;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.beans.MusicBean;
import jp.co.aforce.dao.MusicDAO;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet(urlPatterns = {"/views/music/searchForm"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=UTF-8");

        String type = request.getParameter("type");
        String query = request.getParameter("query");

        try (PrintWriter out = response.getWriter()) {
            MusicDAO dao = new MusicDAO();
            List<MusicBean> resultList;

            if ("title".equals(type)) {
                resultList = dao.searchByTitle(query);

                // JSON出力
                out.print(toJsonTitleList(resultList));

            } else if ("artist".equals(type)) {
                resultList = dao.searchArtistName(query);

                // JSON出力（nameのみ）
                out.print(toJsonArtistList(resultList));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // タイトル検索の結果をJSON配列に変換
    private String toJsonTitleList(List<MusicBean> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            MusicBean m = list.get(i);
            json.append("{")
                .append("\"title\":\"").append(escape(m.getTitle())).append("\",")
                .append("\"artistName\":\"").append(escape(m.getName())).append("\"")
                .append("}");
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        return json.toString();
    }

    // アーティスト検索の結果をJSON配列に変換
    private String toJsonArtistList(List<MusicBean> list) {
        StringBuilder json = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            MusicBean m = list.get(i);
            json.append("{\"name\":\"").append(escape(m.getName())).append("\"}");
            if (i < list.size() - 1) json.append(",");
        }
        json.append("]");
        return json.toString();
    }

    private String escape(String str) {
        if (str == null) return "";
        return str.replace("\"", "\\\"").replace("\n", "").replace("\r", "");
    }
}
