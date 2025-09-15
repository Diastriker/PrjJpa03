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
	
	// 추가
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
	
	// 한개 조회
	public Article get(Long id) {
		Article article = articleRepository.findById(id).orElse(null);
		return article;
	}
	
	public Article delete(Long id) {
		
		// 삭제할 떄는 미리 검색을 하고 cache memory 에서
		Article target = articleRepository.findById(id).orElse(null);
		
		if(target == null )  return null;
		articleRepository.delete(target);
		
		return target;
	}
	public Article update(Article article) {
		// 1. 수정할 데이터를 검색
		Long id = article.getId();
		Article target = articleRepository.findById(id).orElse(null);
		if(target == null || target.getId() != id) {
			log.info("id:{} article{}", id, article);
			return null; // 400 띄울려면 null을 리턴해야함
		}
		target = articleRepository.save(article);

		return target;
	}
}



