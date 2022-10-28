package com.mijung.sample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mijung.sample.mapper.HeyrimMapper;
import com.mijung.sample.vo.HeyrimVO;

@Service
public class HeyrimServiceImpl implements HeyrimService {

	@Autowired
	private HeyrimMapper heyrimMapper;
	
	@Override
	public int insertNam(HeyrimVO namchin) {
		return heyrimMapper.insertNam(namchin);
	}

	@Override
	public int updateNam(HeyrimVO namchin) {
		return heyrimMapper.updateNam(namchin);
	}

	@Override
	public int deleteNam(HeyrimVO namchin) {
		return heyrimMapper.deleteNam(namchin);
	}

}
