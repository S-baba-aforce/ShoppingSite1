package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.ArtistBean;
import jp.co.aforce.beans.MusicBean;


public class MusicDAO extends DAO {
	
	//共通で使うMusicオブジェクト作成
	private MusicBean makeMusic(ResultSet rs) throws Exception{
        MusicBean music = new MusicBean();
        music.setMusic_id(rs.getInt("music_id"));
        music.setTitle(rs.getString("title"));
        music.setArtist_id(rs.getInt("artist_id"));
        music.setName(rs.getString("name"));
        music.setGenre(rs.getString("genre"));
        music.setPrice(rs.getInt("price"));
        music.setFile_path(rs.getString("file_path"));
        music.setDescription(rs.getString("description"));
        music.setCreated_at(rs.getTimestamp("created_at"));
        music.setIcon_path(rs.getString("icon_path"));

        return music;
        
	}
	
	
	//新着楽曲を取得
	public List<MusicBean> findNewMusic()throws Exception {
		List<MusicBean>newMusicList = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
		        "SELECT m.*, a.name, a.icon_path FROM music m " +
		        "JOIN artist a ON m.artist_id = a.artist_id " +
		        "ORDER BY m.created_at DESC LIMIT 5"
		);
		
		ResultSet rs = st.executeQuery();
		
		while (rs.next())	{
			newMusicList.add(makeMusic(rs));
		}
		rs.close();
	   	st.close();
    	con.close();
		return newMusicList;
	}
	
	//新着楽曲10曲取得
	public List<MusicBean> findNewMusic10() throws Exception {
	    List<MusicBean> list = new ArrayList<>();
	    Connection con = getConnection();
	    PreparedStatement st = con.prepareStatement(
	        "SELECT m.*, a.name FROM music m JOIN artist a ON m.artist_id = a.artist_id ORDER BY m.created_at DESC LIMIT 10"
	    );
	    ResultSet rs = st.executeQuery();
	    while (rs.next()) {
	        list.add(makeMusic(rs));
	    }
	    rs.close();
	    st.close();
	    con.close();
	    return list;
	}

	
	//人気楽曲を取得（購入数の多い順）
	public List<MusicBean> findPopularMusic()throws Exception {
		List<MusicBean>list = new ArrayList<>();
		
		Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
		        "SELECT m.*, a.name, a.icon_path, COUNT(p.music_id) AS count " +
		        "FROM music m " +
				"LEFT JOIN purchase p ON m.music_id = p.music_id " +
				"JOIN artist a ON m.artist_id = a.artist_id " +
				"GROUP BY m.music_id " +
				"ORDER BY count DESC " +
				"LIMIT 5"
				);
		
		ResultSet rs = st.executeQuery();	
		
		while (rs.next())	{
			list.add(makeMusic(rs));
		}
		rs.close();
	   	st.close();
    	con.close();
		return list;
	}
	
	//全楽曲取得
	public List<MusicBean> findAll()throws Exception{
		List<MusicBean>list = new ArrayList<>();
		
        Connection con = getConnection();
		
		PreparedStatement st = con.prepareStatement(
				"SELECT m.*, a.name FROM music m "
			    + "JOIN artist a ON m.artist_id = a.artist_id "
			    + "ORDER BY m.created_at DESC");
			    
		ResultSet rs = st.executeQuery();
		
		while (rs.next())	{
			MusicBean music = makeMusic(rs);
			list.add(music);
		}
		rs.close();
	   	st.close();
    	con.close();
		return list;
	}
	
    // ジャンルで検索
    public List<MusicBean> findByGenre(String genre) {
        List<MusicBean> musicList = new ArrayList<>();

        String sql = """
            SELECT m.*, a.name 
            FROM music m
            JOIN artist a ON m.artist_id = a.artist_id
            WHERE m.genre = ?
            ORDER BY m.created_at DESC""";

        try (Connection con = getConnection();
             PreparedStatement st = con.prepareStatement(sql)) {

            st.setString(1, genre);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    musicList.add(makeMusic(rs));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return musicList;
    }
    
    //  タイトル検索
    public List<MusicBean> searchByTitle(String keyword) throws Exception {
        List<MusicBean> list = new ArrayList<>();
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
        		"SELECT m.*, a.name, a.icon_path FROM music m " +
        		"JOIN artist a ON m.artist_id = a.artist_id " +
        		"WHERE m.title LIKE ?");
        st.setString(1, "%" + keyword + "%");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            list.add(makeMusic(rs));
        }
        st.close();
        con.close();
        return list;
    }
    
    //アーティスト検索
    public List<MusicBean> searchArtistName(String query) throws Exception {
        List<MusicBean> artistNames = new ArrayList<>();

        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
                 "SELECT artist_id, name FROM artist WHERE name LIKE ?");
         
        st.setString(1, "%" + query + "%");
        ResultSet rs = st.executeQuery();
        
        while (rs.next()) {
        	MusicBean music = new MusicBean();
        	music.setArtist_id(rs.getInt("artist_id"));
            music.setName(rs.getString("name"));
            artistNames.add(music);
        }
        st.close();
        con.close();
        return artistNames;
    }
    
    //全アーティスト取得
    public List<ArtistBean> getAllArtists() throws Exception {
        List<ArtistBean> list = new ArrayList<>();

        Connection con = getConnection();
        
        PreparedStatement st = con.prepareStatement(
        		"SELECT * FROM artist ORDER BY name");
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            ArtistBean artist = new ArtistBean();
            artist.setArtist_id(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            list.add(artist);
        }

        rs.close();
        st.close();
        con.close();

        return list;
    }
    
    //アーティスト名を取得
    public String getArtistNameById(int artistId) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
        		"SELECT name FROM artist WHERE artist_id = ?");
        st.setInt(1, artistId);
        ResultSet rs = st.executeQuery();

        String name = null;
        if (rs.next()) {
            name = rs.getString("name");
        }

        rs.close();
        st.close();
        con.close();

        return name;
    }


    
    
    //楽曲の詳細を取得
    public MusicBean findById(int id) throws Exception {
        Connection con = getConnection();
        String sql = "SELECT m.*, a.name, a.icon_path FROM music m JOIN artist a ON m.artist_id = a.artist_id WHERE m.music_id = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, id);
        ResultSet rs = st.executeQuery();

        MusicBean music = null;
        if (rs.next()) {
            music = makeMusic(rs);
        }

        rs.close();
        st.close();
        con.close();
        return music;
    }
    
 // 楽曲をデータベースに追加するメソッド
    public void insertMusic(MusicBean music) throws Exception {
        // DB接続
        Connection con = null;
        PreparedStatement st = null;

        try {
            con = getConnection();

            String sql = "INSERT INTO music (music_id, title, artist_id, genre, price, file_path, description, created_at) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

            st = con.prepareStatement(sql);
            st.setInt(1, music.getMusic_id());
            st.setString(2, music.getTitle());
            st.setInt(3, music.getArtist_id());
            st.setString(4, music.getGenre());
            st.setInt(5, music.getPrice());
            st.setString(6, music.getFile_path());
            st.setString(7, music.getDescription());

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            if (st != null) try { st.close(); } catch (Exception e) {}
            if (con != null) try { con.close(); } catch (Exception e) {}
        }
    }
    
    //アーティスト名・アイコン画像取得
    public List<ArtistBean> getLatestArtists(int limit) throws Exception {
        List<ArtistBean> list = new ArrayList<>();
        Connection con = getConnection();

        PreparedStatement st = con.prepareStatement(
        		"SELECT artist_id, name, icon_path FROM artist ORDER BY created_at DESC LIMIT ?");
        st.setInt(1, limit);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            ArtistBean artist = new ArtistBean();
            artist.setArtist_id(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            artist.setIcon_path(rs.getString("icon_path"));
            list.add(artist);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }
    
    //アーティスト情報一件取得
    public ArtistBean getArtistById(int artist_id) throws Exception {
        Connection con = getConnection();
        PreparedStatement st = con.prepareStatement(
            "SELECT * FROM artist WHERE artist_id = ?"
        );
        st.setInt(1, artist_id);
        ResultSet rs = st.executeQuery();

        ArtistBean artist = null;
        if (rs.next()) {
            artist = new ArtistBean();
            artist.setArtist_id(rs.getInt("artist_id"));
            artist.setName(rs.getString("name"));
            artist.setFurigana(rs.getString("furigana"));
            artist.setBio(rs.getString("bio"));
            artist.setIcon_path(rs.getString("icon_path"));
        }

        rs.close();
        st.close();
        con.close();
        return artist;
    }

 // アーティストごとの人気楽曲を取得（購入回数＝amountの合計）
    public List<MusicBean> getPopularSongsByArtist(int artist_id, int limit) throws Exception {
        List<MusicBean> list = new ArrayList<>();
        Connection con = getConnection();
        
        String sql = """
            SELECT m.*, a.name, a.icon_path, COALESCE(SUM(p.amount), 0) AS amount
            FROM music m
            JOIN artist a ON m.artist_id = a.artist_id
            LEFT JOIN purchase p ON m.music_id = p.music_id
            WHERE m.artist_id = ?
            GROUP BY m.music_id
            ORDER BY amount DESC
            LIMIT ?
        """;

        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1, artist_id);
        st.setInt(2, limit);
        ResultSet rs = st.executeQuery();

        while (rs.next()) {
            MusicBean music = makeMusic(rs); // 共通メソッド
            music.setAmount(rs.getInt("amount")); // ← ここがポイント！
            list.add(music);
        }

        rs.close();
        st.close();
        con.close();
        return list;
    }

    
 // アーティストごとの楽曲一覧を取得
//    public List<MusicBean> findByArtistId(int artistId) {
//        List<MusicBean> musicList = new ArrayList<>();
//
//        String sql = """
//            SELECT m.*, a.name 
//            FROM music m
//            JOIN artist a ON m.artist_id = a.artist_id
//            WHERE m.artist_id = ?
//            ORDER BY m.created_at DESC""";
//
//        try (Connection conn = getConnection();
//             PreparedStatement st = conn.prepareStatement(sql)) {
//
//            st.setInt(1, artistId);
//
//            try (ResultSet rs = st.executeQuery()) {
//                while (rs.next()) {
//                    musicList.add(makeMusic(rs));
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return musicList;
//    }
}
