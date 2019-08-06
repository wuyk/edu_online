package com.wuyk.eduOnline.controller;

import com.wuyk.eduOnline.config.WeChatConfig;
import com.wuyk.eduOnline.domain.JsonData;
import com.wuyk.eduOnline.mapper.VideoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@RequestMapping("test")
	public String test(){
		System.out.println("xdclass.net");

		return "hello xdclass.net777";
	}



	@Autowired
	private WeChatConfig weChatConfig;

	@RequestMapping("test_config")
	public JsonData testConfig(){

		System.out.println(weChatConfig.getAppId());
		return JsonData.buildSuccess(weChatConfig.getAppId());
	}



	@Autowired
	private VideoMapper videoMapper;

	@RequestMapping("test_db")
	public Object testDB(){


		return videoMapper.findAll();
	}





}
