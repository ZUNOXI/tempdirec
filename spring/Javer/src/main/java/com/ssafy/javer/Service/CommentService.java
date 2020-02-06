package com.ssafy.javer.Service;

import java.util.List;

import com.ssafy.javer.DTO.Comment_dto;

public interface CommentService {
	public int InsertComment(int bnum, String uid, String ccontent
			, String ccreation_date);
	public int UpdateComment(int cnum, int bnum, String uid, String ccontent
			, String ccreation_date);
	public int DeleteComment(int cnum);
	public Comment_dto SelectOneComment(int cnum);
	public List<Comment_dto> SelectListComment(int bnum);
}
