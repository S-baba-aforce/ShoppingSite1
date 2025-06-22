package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ArtistBean;
import jp.co.aforce.beans.MusicBean;

public class SortDAO extends DAO{
	
	//楽曲並び替え機能
	public List<MusicBean> getMusicOrderBy(String sortType) throws Exception {
	    
		List<MusicBean> list = new ArrayList<>();
		Connection con = getConnection();

	    String orderBy;
	    String sql;
	    
	    switch (sortType) {
        case "popular":
            sql = "SELECT m.*, a.name AS artist_name, COALESCE(SUM(p.amount), 0) AS total_sales " +
                  "FROM music m " +
                  "JOIN artist a ON m.artist_id = a.artist_id " +
                  "LEFT JOIN purchase p ON m.music_id = p.music_id " +
                  "GROUP BY m.music_id " +
                  "ORDER BY total_sales DESC LIMIT 10";
            break;

        case "price_high":
            sql = "SELECT m.*, a.name AS artist_name FROM music m " +
                  "JOIN artist a ON m.artist_id = a.artist_id " +
                  "ORDER BY m.price DESC LIMIT 10";
            break;

        case "price_low":
            sql = "SELECT m.*, a.name AS artist_name FROM music m " +
                  "JOIN artist a ON m.artist_id = a.artist_id " +
                  "ORDER BY m.price ASC LIMIT 10";
            break;

        case "new":
        default:
            sql = "SELECT m.*, a.name AS artist_name FROM music m " +
                  "JOIN artist a ON m.artist_id = a.artist_id " +
                  "ORDER BY m.created_at DESC LIMIT 10";
            break;
	    }

	    PreparedStatement st = con.prepareStatement(sql);
	    ResultSet rs = st.executeQuery();

	    	while (rs.next()) {
				MusicBean music = new MusicBean();
				music.setMusic_id(rs.getInt("music_id"));
				music.setTitle(rs.getString("title"));
				music.setArtist_id(rs.getInt("artist_id"));
				music.setName(rs.getString("artist_name"));
				music.setGenre(rs.getString("genre"));
				music.setPrice(rs.getInt("price"));
				music.setFile_path(rs.getString("file_path"));
				music.setDescription(rs.getString("description"));
				list.add(music);
			}

			rs.close();
			st.close();
			con.close();

			return list;
		}
	
	//アーティスト並び替え機能

	 public List<ArtistBean> getArtistOrderBy(String sort) throws Exception {
	        Connection con = getConnection();
	        String sql = "";

	        switch (sort) {
	            case "popular":
	                sql = "SELECT a.*, COUNT(p.music_id) AS purchase_count " +
	                      "FROM artist a " +
	                      "JOIN music m ON a.artist_id = m.artist_id " +
	                      "JOIN purchase p ON m.music_id = p.music_id " +
	                      "GROUP BY a.artist_id " +
	                      "ORDER BY purchase_count DESC LIMIT 10";
	                break;

	            case "name":
	                sql = "SELECT * FROM artist ORDER BY furigana ASC LIMIT 10";
	                break;

	            case "new":
	            default:
	                sql = "SELECT * FROM artist ORDER BY created_at DESC LIMIT 10";
	                break;
	        }

	        PreparedStatement st = con.prepareStatement(sql);
	        ResultSet rs = st.executeQuery();

	        List<ArtistBean> list = new ArrayList<>();
	        while (rs.next()) {
	            ArtistBean ab = new ArtistBean();
	            ab.setArtist_id(rs.getInt("artist_id"));
	            ab.setName(rs.getString("name"));
	            ab.setFurigana(rs.getString("furigana"));
	            ab.setBio(rs.getString("bio"));
	            ab.setIcon_path(rs.getString("icon_path"));
	            ab.setCreated_at(rs.getTimestamp("created_at").toLocalDateTime());
	            list.add(ab);
	        }

	        rs.close();
	        st.close();
	        con.close();
	        return list;
	 }
}


