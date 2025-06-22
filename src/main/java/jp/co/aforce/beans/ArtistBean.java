package jp.co.aforce.beans;

public class ArtistBean {
	
	private int artist_id;
	private String name;
	private String furigana;
	private String bio;
	private String icon_path;
	private java.time.LocalDateTime created_at;
	
	
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFurigana() {
		return furigana;
	}
	public void setFurigana(String furigana) {
		this.furigana = furigana;
	}
	
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public String getIcon_path() {
		return icon_path;
	}
	public void setIcon_path(String icon_path) {
		this.icon_path = icon_path;
	}
	public java.time.LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(java.time.LocalDateTime created_at) {
		this.created_at = created_at;
	}
}
