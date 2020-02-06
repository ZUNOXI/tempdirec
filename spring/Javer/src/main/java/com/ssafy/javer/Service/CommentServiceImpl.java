package com.ssafy.javer.Service;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.Comment_dto;
import com.ssafy.javer.Repository.CommentMybatisRepository;

@Service("CommentServiceImpl")
public class CommentServiceImpl implements CommentService{
	@Autowired
	CommentMybatisRepository commentRepo;
	
	@Override
	public int InsertComment(int bnum, String uid, String ccontent, String ccreation_date) {
		// TODO Auto-generated method stub
		return commentRepo.InsertComment(new Comment_dto(bnum, uid, ccontent, ccreation_date));
	}

	@Override
	public int UpdateComment(int cnum, int bnum, String uid, String ccontent, String ccreation_date) {
		// TODO Auto-generated method stub
		return commentRepo.UpdateComment(new Comment_dto(bnum, cnum, uid, ccontent, ccreation_date));
	}

	@Override
	public int DeleteComment(int cnum) {
		// TODO Auto-generated method stub
		return commentRepo.DeleteComment(cnum);
	}

	@Override
	public Comment_dto SelectOneComment(int cnum) {
		// TODO Auto-generated method stub
		return commentRepo.SelectOneComment(cnum);
	}

	@Override
	public List<Comment_dto> SelectListComment(int bnum) {
		// TODO Auto-generated method stub
		return commentRepo.SelectListComment(bnum);
	}

}
