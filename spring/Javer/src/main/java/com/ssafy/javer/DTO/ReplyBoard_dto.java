package com.ssafy.javer.DTO;

public class ReplyBoard_dto {
	private int rnum;
	private int bnum;
	private String uid;
	private String rcontent;
	private String rcreation_date;
	public ReplyBoard_dto() {
		// TODO Auto-generated constructor stub
	}
	public ReplyBoard_dto(int bnum, String uid, String rcontent, String rcreation_date) {
		super();
		this.bnum = bnum;
		this.uid = uid;
		this.rcontent = rcontent;
		this.rcreation_date = rcreation_date;
	}
	public ReplyBoard_dto(int rnum, int bnum, String uid, String rcontent, String rcreation_date) {
		super();
		this.rnum = rnum;
		this.bnum = bnum;
		this.uid = uid;
		this.rcontent = rcontent;
		this.rcreation_date = rcreation_date;
	}
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
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
		return "ReplyBoard_dto [rnum=" + rnum + ", bnum=" + bnum + ", uid=" + uid + ", rcontent=" + rcontent
				+ ", rcreation_date=" + rcreation_date + "]";
	}
}
