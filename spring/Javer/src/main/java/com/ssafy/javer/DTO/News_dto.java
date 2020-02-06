package com.ssafy.javer.DTO;

public class News_dto {
	private String img;
	private String urltitle;
	private String title;
	public News_dto() {
		// TODO Auto-generated constructor stub
	}
	public News_dto(String img, String urltitle, String title) {
		super();
		this.img = img;
		this.urltitle = urltitle;
		this.title = title;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getUrltitle() {
		return urltitle;
	}
	public void setUrltitle(String urltitle) {
		this.urltitle = urltitle;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "News_dto [img=" + img + ", urltitle=" + urltitle + ", title=" + title + "]";
	}
}
