package com.ssafy.javer.Service;

import java.util.List;

import com.ssafy.javer.DTO.ReplyComment_dto;

public interface ReplyCommentService {
	public int InsertReplyComment(int rnum, int cnum, String uid, String rcontent
			, String rcreation_date);
	public int UpdateReplyComment(int rnum, int cnum, String uid, String rcontent
			, String rcreation_date);
	public int DeleteReplyComment(int rnum);
	public ReplyComment_dto SelectOneReplyComment(int rnum);
	public List<ReplyComment_dto> SelectListReplyComment(int cnum);
}
