package jp.co.aforce.beans;

public class PurchaseBean {
	
	private int purchase_id;
	private String memberId;
	private int music_id;
	private int amount;
	private java.time.LocalDateTime created_at;
	
	
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getMusic_id() {
		return music_id;
	}
	public void setMusic_id(int music_id) {
		this.music_id = music_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public java.time.LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(java.time.LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
