package com.ssafy.javer.DTO;

import java.util.LinkedList;	
import java.util.List;

public class Board_dto {
	private int bnum;
	private String uid;
	private String btitle;
	private String bcontent;
	private int bhit;
	private String bcreation_date;
	private String bctg;
	// 게시글에 대한 답변
	private List<Comment_dto> clist;
	// 게시글에 대한 댓글
	private List<ReplyBoard_dto> rblist;
	
    public Board_dto() {
		// TODO Auto-generated constructor stub
	}
	public Board_dto(String uid, String btitle, String bcontent, int bhit, String bcreation_date, String bctg) {
		super();
		this.uid = uid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bcreation_date = bcreation_date;
		this.bctg = bctg;
	}
	public Board_dto(int bnum, String uid, String btitle, String bcontent, int bhit, String bcreation_date,
			String bctg) {
		super();
		this.bnum = bnum;
		this.uid = uid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bcreation_date = bcreation_date;
		this.bctg = bctg;
	}
	
	public Board_dto(int bnum, String uid, String btitle, String bcontent, int bhit, String bcreation_date, String bctg,
			List<Comment_dto> clist, List<ReplyBoard_dto> rblist) {
		super();
		this.bnum = bnum;
		this.uid = uid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bhit = bhit;
		this.bcreation_date = bcreation_date;
		this.bctg = bctg;
		this.clist = clist;
		this.rblist = rblist;
	}
	
	public List<ReplyBoard_dto> getRblist() {
		return rblist;
	}
	public void setRblist(List<ReplyBoard_dto> rblist) {
		this.rblist = rblist;
	}
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBhit() {
		return bhit;
	}
	public void setBhit(int bhit) {
		this.bhit = bhit;
	}
	public String getBcreation_date() {
		return bcreation_date;
	}
	public void setBcreation_date(String bcreation_date) {
		this.bcreation_date = bcreation_date;
	}
	public String getBctg() {
		return bctg;
	}
	public void setBctg(String bctg) {
		this.bctg = bctg;
	}
	
	public List<Comment_dto> getClist() {
		return clist;
	}
	public void setClist(List<Comment_dto> clist) {
		this.clist = clist;
	}
	@Override
	public String toString() {
		return "Board_dto [bnum=" + bnum + ", uid=" + uid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bhit="
				+ bhit + ", bcreation_date=" + bcreation_date + ", bctg=" + bctg + ", clist=" + clist + ", rblist="
				+ rblist + "]";
	}
}
