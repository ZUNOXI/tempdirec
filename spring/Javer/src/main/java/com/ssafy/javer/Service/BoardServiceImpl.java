package com.ssafy.javer.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.Board_dto;
import com.ssafy.javer.Repository.BoardMybatisRepository;

@Service("BoardServiceImpl")
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMybatisRepository boardRepo;
	
	@Override
	public int InsertBoard(String uid, String btitle, String bcontent, int bhit, String bcreation_date,
			String bctg) {
		// TODO Auto-generated method stub
		return boardRepo.InsertBoard(new Board_dto(uid, btitle, bcontent, bhit, bcreation_date, bctg));
	}

	@Override
	public int UpdateBoard(int bnum, String uid, String btitle, String bcontent, int bhit, String bcreation_date,
			String bctg) {
		// TODO Auto-generated method stub
		return boardRepo.UpdateBoard(new Board_dto(bnum, uid, btitle, bcontent, bhit, bcreation_date, bctg));
	}

	@Override
	public int DeleteBoard(int bnum) {
		// TODO Auto-generated method stub
		return boardRepo.DeleteBoard(bnum);
	}

	@Override
	public Board_dto SelectBoard(int bnum) {
		// TODO Auto-generated method stub
		return boardRepo.SelectOneBoard(bnum);
	}

	@Override
	public List<Board_dto> SelectListBoard() {
		// TODO Auto-generated method stub
		return boardRepo.SelectListBoard();
	}

}
