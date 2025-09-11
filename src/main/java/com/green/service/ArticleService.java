package com.green.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.dto.Article;
import com.green.dto.ArticleDTO;
import com.green.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ArticleService {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	public List<Article> getList() {
		List<Article> articleList = articleRepository.findAll();
		
		return articleList;
	}
	
	public Article create(ArticleDTO articleDTO) {
		
		System.out.println(articleDTO);
		Article article = articleDTO.toEntity();
		// 입력된 id 가 있다면 null 을 리턴하도록 코딩 - 왜냐 시퀸스니깐
		if( article.getId() != null ) {
			return null;
		}
		Article saved = articleRepository.save(article);
		return saved;
	}
}



