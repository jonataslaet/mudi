package br.com.jonataslaet.mvc.mudi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	@GetMapping(value="/hello")
	String retornaHello(HttpServletRequest req) {
		req.setAttribute("nome", "Mundo");
		return "hello";
	}
}
