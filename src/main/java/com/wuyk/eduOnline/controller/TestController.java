package com.wuyk.eduOnline.controller;

import com.wuyk.eduOnline.config.WeChatConfig;
import com.wuyk.eduOnline.mapper.VideoMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
public class TestController {

	@RequestMapping("test")
	public String test(){
		System.out.println("xdclass.net");

		return "hello xdclass.net777";
	}

	@Resource
	private WeChatConfig weChatConfig;

	@RequestMapping("test_config")
	public String testConfig(){
		System.out.println(weChatConfig.getAppId());
		return "hello xdclass.net";
	}

	@Resource
	private VideoMapper videoMapper;

	@RequestMapping("test_db")
	public Object testDB(){
		return videoMapper.findAll();
	}
}
