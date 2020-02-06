package com.ssafy.javer.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.ReplyComment_dto;

@Repository("ReplyCommentMybatisRepositoryImpl")
public class ReplyCommentMybatisRepositoryImpl implements ReplyCommentMybatisRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public int InsertReplyComment(ReplyComment_dto reply) {
		// TODO Auto-generated method stub
		return session.insert("com.ssafy.javer.replycomment.insert", reply);
	}

	@Override
	public int UpdateReplyComment(ReplyComment_dto reply) {
		// TODO Auto-generated method stub
		return session.update("com.ssafy.javer.replycomment.update", reply);
	}

	@Override
	public int DeleteReplyComment(int rnum) {
		// TODO Auto-generated method stub
		return session.delete("com.ssafy.javer.replycomment.delete", rnum);
	}

	@Override
	public ReplyComment_dto SelectOneReplyComment(int rnum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.ssafy.javer.replycomment.selectOne", rnum);
	}

	@Override
	public List<ReplyComment_dto> SelectListReplyComment(int cnum) {
		// TODO Auto-generated method stub
		return session.selectList("com.ssafy.javer.replycomment.selectList", cnum);
	}

}
