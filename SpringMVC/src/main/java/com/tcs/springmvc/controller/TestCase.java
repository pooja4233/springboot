package com.tcs.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestCase {
	@GetMapping("/test")
	public String greet() {
		return "myview";
	}
	

}
