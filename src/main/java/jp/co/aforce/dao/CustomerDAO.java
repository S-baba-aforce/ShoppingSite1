package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.CustomerBean;

/**
 * Servlet implementation class CustomerDAO
 */

public class CustomerDAO extends DAO {
	
	
    public CustomerBean search(String id, String password) throws Exception {
    	CustomerBean customer = null;
    	
    	Connection con = getConnection();
    	
    	PreparedStatement st;
    	st = con.prepareStatement(
    			"select * from customer where MEMBER_ID = ? and PASSWORD = ? ");
    	st.setString(1, id);
    	st.setString(2, password);
    	ResultSet rs = st.executeQuery();
    	
    	while (rs.next()) {
    		customer = new CustomerBean();
    		customer.setMemberId(rs.getString("MEMBER_ID"));
    		customer.setPassword(rs.getString("PASSWORD"));
    	}
    	st.close();
    	con.close();
    	return customer;
    }
    
    public int insert(CustomerBean cb) throws Exception{
    	Connection con = getConnection();
    	
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
        return result;
    	
    }
}
