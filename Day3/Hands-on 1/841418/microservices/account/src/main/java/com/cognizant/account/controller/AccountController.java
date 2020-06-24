package com.cognizant.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private Environment env;
	
	@GetMapping("/{number}")
	public String getAccount() {
		return "{ number: \"00987987973432\", type: \"savings\", balance: 234343 }";
	}
	
	@GetMapping("/status")
	public String getStatus() {
		return "Working on port: " + env.getProperty("local.server.port");
	}
}
