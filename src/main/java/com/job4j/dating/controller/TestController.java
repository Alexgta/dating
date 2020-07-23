package com.job4j.dating.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
public class TestController {

	@GetMapping("/test")
	public String helloWorld() {


		return "helloworld";
	}

}


