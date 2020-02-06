package com.ssafy.javer.Service;

import java.util.List;		

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.javer.DTO.News_dto;
import com.ssafy.javer.Repository.NewsMybatisRepository;

@Service("NewsServiceImpl")
public class NewsServiceImpl implements NewsService{
	@Autowired
	NewsMybatisRepository newsRepo;
	
	@Override
	public List<News_dto> SelectListNews() {
		// TODO Auto-generated method stub
		return newsRepo.SelectListNews();
	}

}
