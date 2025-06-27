package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jp.co.aforce.beans.PurchaseBean;

public class PurchaseDAO extends DAO {
	
	public boolean insert(PurchaseBean purchase) throws Exception {
	    Connection con = getConnection();
	    String sql = "INSERT INTO purchase (MEMBER_ID, music_id, amount) VALUES (?, ?, ?)";
	    
	    

	    PreparedStatement st = con.prepareStatement(sql);
	    st.setString(1, purchase.getMemberId());
	    st.setInt(2, purchase.getMusic_id());
	    st.setInt(3, purchase.getAmount());

	    int result = st.executeUpdate();
	    
	    st.close();
	    con.close();
	    return result == 1;
	}


}
