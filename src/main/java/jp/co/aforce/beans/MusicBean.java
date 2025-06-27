package jp.co.aforce.beans;

import java.io.Serializable;
import java.sql.Timestamp;


public class MusicBean implements Serializable {
		
		private int music_id;
		private String title;
		private int artist_id;
		private String genre;
		private int price;
		private String file_path;
		private String description;
		private Timestamp created_at;
		private String name;
		private int amount;
		private String icon_path;
		
		public int getMusic_id() {
			return music_id;
		}
		public void setMusic_id(int music_id) {
			this.music_id = music_id;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public int getArtist_id() {
			return artist_id;
		}
		public void setArtist_id(int artist_id) {
			this.artist_id = artist_id;
		}
		public String getGenre() {
			return genre;
		}
		public void setGenre(String genre) {
			this.genre = genre;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getFile_path() {
			return file_path;
		}
		public void setFile_path(String file_path) {
			this.file_path = file_path;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public Timestamp getCreated_at() {
			return created_at;
		}
		public void setCreated_at(Timestamp created_at) {
			this.created_at = created_at;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAmount() {
		    return amount;
		}
		public void setAmount(int amount) {
		    this.amount = amount;
		}
		public String getIcon_path() {
		    return icon_path;
		}
		public void setIcon_path(String icon_path) {
		    this.icon_path = icon_path;
		}
}
