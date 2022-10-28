package com.mijung.sample.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mijung.sample.vo.HeyrimVO;

@Mapper  // 명시적으로 붙여주는 것이 좋음, 없으면 약간 헷갈림
public interface HeyrimMapper {
	
	//post로 왔을 때 실행, 생성
	public int insertNam(HeyrimVO namchin);
	
	//put으로 왔을 때 실행, 수정
	public int updateNam(HeyrimVO namchin);
	
	//delete로 왔을 때 실행, 삭제, id값 1개만 String으로 있어도 무방, 조금은 낭비되도 괜찮음
	public int deleteNam(HeyrimVO namchin);
}
