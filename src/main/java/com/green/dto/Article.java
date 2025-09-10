package com.green.dto;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;


// @AllArgsConstructor 모든 인자가 있는 생성자
// @NoArgsConstructor  기본 생성자
@Entity
@Data        //@RequiredArgsConstructor - null 못받음
public class Article {
	
	@Id                    // primary key 의미를 갖고있음 @Column 안해도 자동으로 칼럼으로 인식
	@GeneratedValue        // sequence 
	private Long id;    // Integer : null 입력가능, int 는 null 못받음
	
	@Column                // DB 칼럼 선언 
	private String title;
	
	@Column
	private String content;
	
	public Article() {}
	public Article(Long id , String title, String content) {
		this.id = id;
		this.title = title;
		this.content = content;
	}


	
	
}
