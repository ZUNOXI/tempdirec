package com.ssafy.javer.Repository;

import java.util.List;

import com.ssafy.javer.DTO.Comment_dto;

public interface CommentMybatisRepository {
	public int InsertComment(Comment_dto comment);
	public int UpdateComment(Comment_dto comment);
	public int DeleteComment(int cnum);
	public Comment_dto SelectOneComment(int cnum);
	public List<Comment_dto> SelectListComment(int bnum);
}
