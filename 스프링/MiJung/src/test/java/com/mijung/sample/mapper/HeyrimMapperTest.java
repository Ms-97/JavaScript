package com.mijung.sample.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mijung.sample.vo.HeyrimVO;

import lombok.extern.slf4j.Slf4j;

@ExtendWith(SpringExtension.class) // Junit5를 사용하겠다는 의미
@ContextConfiguration("classpath:config/spring/database-context.xml") // 설정파일 로딩
@Slf4j
public class HeyrimMapperTest {
	
	@Autowired
	private HeyrimMapper heyrimMapper; // 맵퍼 테스트 
	
	@Test
	public void testInsert() {
		
		//더미 데이터 맹글깅
		HeyrimVO namchin;	
		for(int i=1; i<=15; i++) {
			namchin = new HeyrimVO();
			namchin.setNamGrade("등급" + i);
			namchin.setNamName("홍길똥" + i);
			namchin.setNamTel("010-8282-242" + i);
			log.debug(namchin.toString());
			assertEquals(1,heyrimMapper.insertNam(namchin));
		}		
	}

}
