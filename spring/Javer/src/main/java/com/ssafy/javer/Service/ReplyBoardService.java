package com.ssafy.javer.Service;

import java.util.List;

import com.ssafy.javer.DTO.ReplyBoard_dto;

public interface ReplyBoardService {
	public int InsertReplyBoard(int bnum, String uid, String rcontent
			, String rcreation_date);
	public int UpdateReplyBoard(int rnum, int bnum, String uid, String rcontent
			, String rcreation_date);
	public int DeleteReplyBoard(int rnum);
	public ReplyBoard_dto SelectOneReplyBoard(int rnum);
	public List<ReplyBoard_dto> SelectListReplyBoard(int bnum);
}
