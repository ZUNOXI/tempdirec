package com.ssafy.javer.Service;

import java.util.List;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.ReplyComment_dto;
import com.ssafy.javer.Repository.ReplyCommentMybatisRepository;

@Service("ReplyCommentServiceImpl")
public class ReplyCommentServiceImpl implements ReplyCommentService{
	@Autowired
	ReplyCommentMybatisRepository replycommentRepo;
	
	@Override
	public int InsertReplyComment(int rnum, int cnum, String uid, String rcontent, String rcreation_date) {
		// TODO Auto-generated method stub
		return replycommentRepo.InsertReplyComment(new ReplyComment_dto(rnum, cnum, uid, rcontent, rcreation_date));
	}

	@Override
	public int UpdateReplyComment(int rnum, int cnum, String uid, String rcontent, String rcreation_date) {
		// TODO Auto-generated method stub
		return replycommentRepo.UpdateReplyComment(new ReplyComment_dto(rnum, cnum, uid, rcontent, rcreation_date));
	}

	@Override
	public int DeleteReplyComment(int rnum) {
		// TODO Auto-generated method stub
		return replycommentRepo.DeleteReplyComment(rnum);
	}

	@Override
	public ReplyComment_dto SelectOneReplyComment(int rnum) {
		// TODO Auto-generated method stub
		return replycommentRepo.SelectOneReplyComment(rnum);
	}

	@Override
	public List<ReplyComment_dto> SelectListReplyComment(int cnum) {
		// TODO Auto-generated method stub
		return replycommentRepo.SelectListReplyComment(cnum);
	}

}
