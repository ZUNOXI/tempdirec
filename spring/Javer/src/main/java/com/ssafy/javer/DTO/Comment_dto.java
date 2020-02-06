package com.ssafy.javer.DTO;

import java.util.LinkedList;
import java.util.List;

public class Comment_dto {
	private int cnum;
	private int bnum;
	private String uid;
	private String ccontent;
	private String ccreation_date;
	private List<ReplyComment_dto> rlist;
	
    public Comment_dto() {
		// TODO Auto-generated constructor stub
	}
    public Comment_dto(int bnum, String uid, String ccontent, String ccreation_date) {
    	super();
    	this.bnum = bnum;
    	this.uid = uid;
    	this.ccontent = ccontent;
    	this.ccreation_date = ccreation_date;
    }
	public Comment_dto(int bnum, int cnum, String uid, String ccontent, String ccreation_date) {
		super();
		this.bnum = bnum;
		this.cnum = cnum;
		this.uid = uid;
		this.ccontent = ccontent;
		this.ccreation_date = ccreation_date;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
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
	public String getCcontent() {
		return ccontent;
	}
	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}
	public String getCcreation_date() {
		return ccreation_date;
	}
	public void setCcreation_date(String ccreation_date) {
		this.ccreation_date = ccreation_date;
	}
	
	public List<ReplyComment_dto> getRlist() {
		return rlist;
	}
	public void setRlist(List<ReplyComment_dto> rlist) {
		this.rlist = rlist;
	}
	@Override
	public String toString() {
		return "Comment [bnum=" + bnum + ", cnum=" + cnum + ", uid=" + uid + ", ccontent=" + ccontent
				+ ", ccreation_date=" + ccreation_date + "]";
	}
}
