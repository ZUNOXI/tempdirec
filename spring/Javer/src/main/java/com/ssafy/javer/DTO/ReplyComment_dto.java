package com.ssafy.javer.DTO;

public class ReplyComment_dto {
	private int rnum;
	private int cnum;
	private String uid;
	private String rcontent;
	private String rcreation_date;
	public ReplyComment_dto() {
		// TODO Auto-generated constructor stub
	}
	public ReplyComment_dto(int rnum, int cnum, String uid, String rcontent, String rcreation_date) {
		super();
		this.rnum = rnum;
		this.cnum = cnum;
		this.uid = uid;
		this.rcontent = rcontent;
		this.rcreation_date = rcreation_date;
	}
	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getCnum() {
		return cnum;
	}
	public void setCnum(int cnum) {
		this.cnum = cnum;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getRcontent() {
		return rcontent;
	}
	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}
	public String getRcreation_date() {
		return rcreation_date;
	}
	public void setRcreation_date(String rcreation_date) {
		this.rcreation_date = rcreation_date;
	}
	@Override
	public String toString() {
		return "ReplyComment_dto [rnum=" + rnum + ", cnum=" + cnum + ", uid=" + uid + ", rcontent=" + rcontent
				+ ", rcreation_date=" + rcreation_date + "]";
	}
}
