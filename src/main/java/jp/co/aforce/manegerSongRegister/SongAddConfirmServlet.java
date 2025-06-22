//package jp.co.aforce.manegerSongRegister;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.Part;
//
//import jp.co.aforce.dao.MusicDAO;
//
///**
// * Servlet implementation class SongAddConfirmServlet
// */
//@WebServlet(urlPatterns = {"/views/songRegister/song-add-confirm"})
//public class SongAddConfirmServlet extends HttpServlet {
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//        try {
//            request.setCharacterEncoding("UTF-8");
//
//            // フォームデータ取得
//            int musicId = Integer.parseInt(request.getParameter("music_id"));
//            String title = request.getParameter("title");
//            int artistId = Integer.parseInt(request.getParameter("artist_id"));
//            String genre = request.getParameter("genre");
//            int price = Integer.parseInt(request.getParameter("price"));
//            String description = request.getParameter("description");
//
//            // ファイル名の取得
//            Part filePart = request.getPart("file_path");
//            String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//
//            // アーティスト名を取得
//            MusicDAO dao = new MusicDAO();
//            String artistName = dao.getArtistNameById(artistId);
//
//            // request にセット
//            request.setAttribute("music_id", musicId);
//            request.setAttribute("title", title);
//            request.setAttribute("artist_id", artistId);
//            request.setAttribute("artist_name", artistName);
//            request.setAttribute("genre", genre);
//            request.setAttribute("price", price);
//            request.setAttribute("file_path", fileName);
//            request.setAttribute("description", description);
//
//            // 確認画面へ
//            request.getRequestDispatcher("/views/songRegister/songAddConfirm.jsp").forward(request, response);
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            request.setAttribute("errorMessage", "確認処理中にエラーが発生しました：" + e.getMessage());
//            
//        }
//    }
//
//}
