package com.ssafy.javer.Repository;

import java.util.List;

import com.ssafy.javer.DTO.ReplyComment_dto;

public interface ReplyCommentMybatisRepository {
	public int InsertReplyComment(ReplyComment_dto replycomment);
	public int UpdateReplyComment(ReplyComment_dto replycomment);
	public int DeleteReplyComment(int rnum);
	public ReplyComment_dto SelectOneReplyComment(int rnum);
	public List<ReplyComment_dto> SelectListReplyComment(int cnum);
}
