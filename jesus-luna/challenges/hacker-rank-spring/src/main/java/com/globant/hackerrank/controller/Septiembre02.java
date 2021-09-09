package com.globant.hackerrank.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("septiembre02")
public class Septiembre02 {

	@GetMapping(value = "reverse")
	public String getMethodName() {
		return"Hello world";
	}

}
