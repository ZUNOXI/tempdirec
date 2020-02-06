package com.ssafy.javer.Repository;

import java.util.List;	

import com.ssafy.javer.DTO.News_dto;

public interface NewsMybatisRepository {
	public List<News_dto> SelectListNews();
}
