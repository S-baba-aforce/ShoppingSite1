package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.UserBean;

public class UserDAO extends DAO {
	
    public UserBean search(String id, String password) throws Exception {
    	UserBean customer = null;
    	
    	Connection con = getConnection();
    	
    	PreparedStatement st;
    	st = con.prepareStatement(
    			"select * from customer where MEMBER_ID = ? and PASSWORD = ? ");
    	st.setString(1, id);
    	st.setString(2, password);
    	ResultSet rs = st.executeQuery();
    	
    	while (rs.next()) {
    		customer = new UserBean();
    		customer.setMemberId(rs.getString("MEMBER_ID"));
    		customer.setPassword(rs.getString("PASSWORD"));
    		customer.setLastName(rs.getString("LAST_NAME"));
    		customer.setFirstName(rs.getString("FIRST_NAME"));
    	}
    	st.close();
    	con.close();
    	return customer;
    }
    
    public boolean checkDuplicate(UserBean cb) throws Exception {
        Connection con = getConnection();

        String sql = "SELECT COUNT(*) FROM customer WHERE MEMBER_ID = ? AND PASSWORD = ?";
        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, cb.getMemberId());
        st.setString(2, cb.getPassword());

        ResultSet rs = st.executeQuery();
        boolean exists = false;

        if (rs.next()) {
            exists = rs.getInt(1) > 0;
        }

        rs.close();
        st.close();
        con.close();

        return !exists;  // true → 登録してOK、false → 既に存在する
    }

  
    public boolean insert(UserBean cb) throws Exception{
    	Connection con = getConnection();
    	
    	//すでに同じものが存在してないかチェック
    	PreparedStatement checkSt = con.prepareStatement(
    		"SELECT COUNT(*) FROM customer WHERE member_id = ? AND password = ?");
        checkSt.setString(1, cb.getMemberId());
        checkSt.setString(2, cb.getPassword());
        ResultSet rs = checkSt.executeQuery();	
    	
        rs.next();
        if (rs.getInt(1) > 0) {
        	//登録済み
        	rs.close();
            checkSt.close();
            con.close();
            return false;
        }
    	
    	//登録処理
    	PreparedStatement st = con.prepareStatement(
    			"INSERT INTO customer (member_id, password, last_name, first_name, address, mail_address) VALUES (?, ?, ?, ?, ?, ?)");
    	
        st.setString(1, cb.getMemberId());
        st.setString(2, cb.getPassword());
        st.setString(3, cb.getLastName());
        st.setString(4, cb.getFirstName());
        st.setString(5, cb.getAddress());
        st.setString(6, cb.getMailAddress());
        
        int result = st.executeUpdate();
               
        st.close();
        con.close();
        return result > 0;
    }
    
    public boolean update(UserBean customer) throws Exception {
    	Connection con = getConnection();
    	PreparedStatement st = con.prepareStatement(
    			"UPDATE customer SET last_name=?, first_name=?, address=?, mail_address=? WHERE MEMBER_ID=?");
    	st.setString(1, customer.getLastName());
    	st.setString(2, customer.getFirstName());
    	st.setString(3, customer.getAddress());
    	st.setString(4, customer.getMailAddress());
    	st.setString(5, customer.getMemberId());  // 主キー

    	int result = st.executeUpdate();

    	st.close();
    	con.close();

    	return result > 0;
    }
    
    public int deleteUser(String memberId) throws Exception {
    	Connection con = getConnection();
    	
    	PreparedStatement st = con.prepareStatement(
    			"DELETE FROM customer WHERE member_id = ? ");
    	st.setString(1, memberId);
    	
    	int result = st.executeUpdate();
    	
    	st.close();
    	con.close();
    	return result;
    }
}
