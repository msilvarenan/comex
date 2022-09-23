package br.com.alura.comex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ControllerTeste {
	
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello world";
	}
}
