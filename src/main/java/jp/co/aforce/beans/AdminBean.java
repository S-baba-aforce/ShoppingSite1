package jp.co.aforce.beans;

public class AdminBean {
	
	private int admin_id;
	private String username;
	private String password;
	private String name;
	private java.time.LocalDateTime created_at;
	
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public java.time.LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(java.time.LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
