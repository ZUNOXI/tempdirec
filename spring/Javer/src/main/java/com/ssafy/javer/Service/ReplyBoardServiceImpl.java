package com.ssafy.javer.Service;

import java.util.List	;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.ReplyBoard_dto;
import com.ssafy.javer.Repository.ReplyBoardMybatisRepository;

@Service("ReplyBoardServiceImpl")
public class ReplyBoardServiceImpl implements ReplyBoardService{
	@Autowired
	ReplyBoardMybatisRepository replyboardRepo;
	
	@Override
	public int InsertReplyBoard(int bnum, String uid, String rcontent, String rcreation_date) {
		// TODO Auto-generated method stub
		return replyboardRepo.InsertReplyBoard(new ReplyBoard_dto(bnum, uid, rcontent, rcreation_date));
	}

	@Override
	public int UpdateReplyBoard(int rnum, int bnum, String uid, String rcontent, String rcreation_date) {
		// TODO Auto-generated method stub
		return replyboardRepo.UpdateReplyBoard(new ReplyBoard_dto(rnum, bnum, uid, rcontent, rcreation_date));
	}

	@Override
	public int DeleteReplyBoard(int rnum) {
		// TODO Auto-generated method stub
		return replyboardRepo.DeleteReplyBoard(rnum);
	}

	@Override
	public ReplyBoard_dto SelectOneReplyBoard(int rnum) {
		// TODO Auto-generated method stub
		return replyboardRepo.SelectOneReplyBoard(rnum);
	}

	@Override
	public List<ReplyBoard_dto> SelectListReplyBoard(int bnum) {
		// TODO Auto-generated method stub
		return replyboardRepo.SelectListReplyBoard(bnum);
	}

}
