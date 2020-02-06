package com.ssafy.javer.Repository;

import java.util.List;

import com.ssafy.javer.DTO.ReplyBoard_dto;

public interface ReplyBoardMybatisRepository {
	public int InsertReplyBoard(ReplyBoard_dto replyboard);
	public int UpdateReplyBoard(ReplyBoard_dto replyboard);
	public int DeleteReplyBoard(int rnum);
	public ReplyBoard_dto SelectOneReplyBoard(int rnum);
	public List<ReplyBoard_dto> SelectListReplyBoard(int bnum);
}
