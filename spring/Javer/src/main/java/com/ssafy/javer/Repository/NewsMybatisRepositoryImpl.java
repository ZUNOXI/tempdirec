package com.ssafy.javer.Repository;

import java.util.List;	

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.javer.DTO.News_dto;

@Repository("NewsMybatisRepositoryImpl")
public class NewsMybatisRepositoryImpl implements NewsMybatisRepository{
	@Autowired
	SqlSession session;
	
	@Override
	public List<News_dto> SelectListNews() {
		// TODO Auto-generated method stub
		return session.selectList("com.ssafy.javer.news.selectList");
	}
}
