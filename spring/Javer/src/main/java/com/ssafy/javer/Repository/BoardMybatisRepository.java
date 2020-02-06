package com.ssafy.javer.Repository;

import java.util.List;

import com.ssafy.javer.DTO.Board_dto;

public interface BoardMybatisRepository {
	public int InsertBoard(Board_dto board);
	public int UpdateBoard(Board_dto board);
	public int DeleteBoard(int bnum);
	public Board_dto SelectOneBoard(int bnum);
	public List<Board_dto> SelectListBoard();
}
