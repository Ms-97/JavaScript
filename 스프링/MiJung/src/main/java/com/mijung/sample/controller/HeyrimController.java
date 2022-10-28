package com.mijung.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mijung.sample.service.HeyrimService;
import com.mijung.sample.vo.HeyrimVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/hyerim")
@Slf4j
public class HeyrimController {
		// 컨트롤러에서 서비스 호출
	    @Autowired
	    private HeyrimService heyrimService;
	
		@GetMapping("/insert")
		public String getInsert() {
			return "namchinInput";
		}

		//namName,namTel,namGrade
		@PostMapping(value="/insert",produces = "application/json;charset=utf-8")
		@ResponseBody    // 요게 있으면 아작스로 받겠다는 이야기
		public String postInsert(HeyrimVO herimVO) {
			log.debug("{}"+herimVO);
			heyrimService.insertNam(herimVO);
			return "일단 메롱";
		}

		@PutMapping(value="/update",produces = "application/json;charset=utf-8")
		@ResponseBody    // 요게 있으면 아작스로 받겠다는 이야기
		// 스크립트에서 JSON문자열이나 배열 문자열로 왔을 때 @RequestBody로 받는당
		public String putUpdate(@RequestBody HeyrimVO herimVO) {
			log.debug("{}"+herimVO);
			herimVO.setNamId(21); // 아직은 수정해야할 id결정 흐름이 안 되어 있으니깡
			heyrimService.updateNam(herimVO);
			return "일단 메롱";
		}

		@DeleteMapping(value="/delete",produces = "application/json;charset=utf-8")
		@ResponseBody    // 요게 있으면 아작스로 받겠다는 이야기
		// 스크립트에서 JSON문자열이나 배열 문자열로 왔을 때 @RequestBody로 받는당
		public String deleteDelete(@RequestBody HeyrimVO herimVO) {
			log.debug("{}"+herimVO);
			heyrimService.deleteNam(herimVO);
			return "일단 메롱";
		}

		
		
	/*
		public String postInsert(@RequestParam("namName") String suHyun,String namTel, String namGrade) {
			log.debug(suHyun);
			log.debug(namTel);
			log.debug(namGrade);
			return "일단 메롱";
		}
*/		
}
