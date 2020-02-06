package com.ssafy.javer.Service;

import java.util.List;

import com.ssafy.javer.DTO.Board_dto;

public interface BoardService {
	public int InsertBoard(String uid, String btitle, String bcontent
			, int bhit, String bcreation_date, String bctg);
	public int UpdateBoard(int bnum, String uid, String btitle, String bcontent
			, int bhit, String bcreation_date, String bctg);
	public int DeleteBoard(int bnum);
	public Board_dto SelectBoard(int bnum);
	public List<Board_dto> SelectListBoard();
}
//private int bnum;
//private String uid;
//private String btitle;
//private String bcontent;
//private int bhit;
//private String bcreation_date;
//private String bctg;