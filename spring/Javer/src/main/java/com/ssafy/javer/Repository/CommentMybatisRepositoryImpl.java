package com.ssafy.javer.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.Comment_dto;

@Repository("CommentMybatisRepositoryImpl")
public class CommentMybatisRepositoryImpl implements CommentMybatisRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public int InsertComment(Comment_dto comment) {
		// TODO Auto-generated method stub
		return session.insert("com.ssafy.javer.comment.insert", comment);
	}

	@Override
	public int UpdateComment(Comment_dto comment) {
		// TODO Auto-generated method stub
		return session.update("com.ssafy.javer.comment.update", comment);
	}

	@Override
	public int DeleteComment(int cnum) {
		// TODO Auto-generated method stub
		return session.delete("com.ssafy.javer.comment.delete", cnum);
	}

	@Override
	public Comment_dto SelectOneComment(int cnum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.ssafy.javer.comment.selectOne", cnum);
	}

	@Override
	public List<Comment_dto> SelectListComment(int bnum) {
		// TODO Auto-generated method stub
		return session.selectList("com.ssafy.javer.comment.selectList", bnum);
	}
}
