package com.boot.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testController {

	@GetMapping(value="/test")
	public String test() {
		return "Hello Docker's World";
	}
}
