package com.ssafy.javer.Repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.Board_dto;

@Repository("BoardMybatisRepositoryImpl")
public class BoardMybatisRepositoryImpl implements BoardMybatisRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public int InsertBoard(Board_dto board) {
		// TODO Auto-generated method stub
		return session.insert("com.ssafy.javer.board.insert", board);
	}

	@Override
	public int UpdateBoard(Board_dto board) {
		// TODO Auto-generated method stub
		return session.update("com.ssafy.javer.board.update", board);
	}

	@Override
	public int DeleteBoard(int bnum) {
		// TODO Auto-generated method stub
		return session.delete("com.ssafy.javer.board.delete", bnum);
	}

	@Override
	public Board_dto SelectOneBoard(int bnum) {
		// TODO Auto-generated method stub
		return session.selectOne("com.ssafy.javer.board.selectOne", bnum);
	}

	@Override
	public List<Board_dto> SelectListBoard() {
		// TODO Auto-generated method stub
		return session.selectList("com.ssafy.javer.board.selectList");
	}

}
