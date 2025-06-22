package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.AdminBean;
import jp.co.aforce.beans.MusicBean;


public class AdminDAO extends DAO {
	
	// 管理者を取得する（ログイン用）
    public AdminBean findByLogin(int admin_id, String password) throws Exception {
        AdminBean admin = null;

        Connection con = getConnection();
        

        PreparedStatement st = con.prepareStatement(
        		"SELECT * FROM admin WHERE admin_id=? AND password=?");
        st.setInt(1, admin_id);
        st.setString(2, password);

        ResultSet rs = st.executeQuery();

        if (rs.next()) {
            admin = new AdminBean();
            admin.setAdmin_id(rs.getInt("admin_id"));
            admin.setUsername(rs.getString("username"));
            admin.setPassword(rs.getString("password"));
            admin.setName(rs.getString("name"));
            admin.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
        }

        rs.close();
        st.close();
        con.close();

        return admin;
    }
    
    //楽曲追加
    public boolean addMusic(int musicId, String title, int artistId, String genre, int price, String filePath, String description)
            throws Exception {

        Connection con = getConnection();

        String sql = "INSERT INTO music (music_id,title, artist_id, genre, price, file_path, description) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement st = con.prepareStatement(sql);
        
        st.setInt(1, musicId);
        st.setString(2, title);
        st.setInt(3, artistId);
        st.setString(4, genre);
        st.setInt(5, price);
        st.setString(6, filePath);
        st.setString(7, description);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result > 0;
    }
    
    //楽曲情報（一曲）取得
    public MusicBean getMusicById(int musicId) throws Exception {
        Connection con = getConnection();

        String sql = "SELECT m.*, a.name AS name FROM music m " +
                     "JOIN artist a ON m.artist_id = a.artist_id " +
                     "WHERE m.music_id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, musicId);

        ResultSet rs = st.executeQuery();

        MusicBean music = null;
        if (rs.next()) {
            music = new MusicBean();
            music.setMusic_id(rs.getInt("music_id"));
            music.setTitle(rs.getString("title"));
            music.setArtist_id(rs.getInt("artist_id"));
            music.setName(rs.getString("name"));  
            music.setGenre(rs.getString("genre"));
            music.setPrice(rs.getInt("price"));
            music.setFile_path(rs.getString("file_path"));
            music.setDescription(rs.getString("description"));
        }

        rs.close();
        st.close();
        con.close();

        return music;
    }
    
    //楽曲情報を更新
    public boolean updateMusic(int musicId, String title, int artistId, String genre, int price, String filePath, String description)
            throws Exception {

        Connection con = getConnection();

        String sql = "UPDATE music SET title=?, artist_id=?, genre=?, price=?, "
                   + (filePath != null ? "file_path=?," : "")
                   + " description=? WHERE music_id=?";
        
        PreparedStatement st;

        if (filePath != null) {
            st = con.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, artistId);
            st.setString(3, genre);
            st.setInt(4, price);
            st.setString(5, filePath);
            st.setString(6, description);
            st.setInt(7, musicId);
        } else {
            // file_pathを更新しないSQL
            sql = "UPDATE music SET title=?, artist_id=?, genre=?, price=?, description=? WHERE music_id=?";
            st = con.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, artistId);
            st.setString(3, genre);
            st.setInt(4, price);
            st.setString(5, description);
            st.setInt(6, musicId);
        }

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result > 0;
    }
    
    //楽曲削除
    public boolean deleteMusicById(int music_id) throws Exception {
        Connection con = getConnection();

        String sql = "DELETE FROM music WHERE music_id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, music_id);

        int result = st.executeUpdate();

        st.close();
        con.close();

        return result > 0;
    }



}
