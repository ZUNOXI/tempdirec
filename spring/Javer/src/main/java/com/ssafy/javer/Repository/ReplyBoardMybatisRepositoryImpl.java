package com.ssafy.javer.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.ReplyBoard_dto;

@Repository("ReplyBoardMybatisRepositoryImpl")
public class ReplyBoardMybatisRepositoryImpl implements ReplyBoardMybatisRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public int InsertReplyBoard(ReplyBoard_dto replyboard) {
		// TODO Auto-generated method stub
		return session.insert("com.ssafy.javer.replyboard.insert", replyboard);
	}

	@Override
	public int UpdateReplyBoard(ReplyBoard_dto replyboard) {
		// TODO Auto-generated method stub
		return session.update("com.ssafy.javer.replyboard.update", replyboard);
	}

	@Override
	public int DeleteReplyBoard(int rnum) {
		// TODO Auto-generated method stub
		return session.delete("com.ssafy.javer.replyboard.delete", rnum);
	}

	@Override
	public ReplyBoard_dto SelectOneReplyBoard(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.ssafy.javer.replyboard.selectOne", rnum);
	}

	@Override
	public List<ReplyBoard_dto> SelectListReplyBoard(int bnum) {
		// TODO Auto-generated method stub
		return session.selectList("com.ssafy.javer.replyboard.selectList", bnum);
	}

}
