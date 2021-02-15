package br.com.jonataslaet.mvc.mudi.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonataslaet.mvc.mudi.interceptor.InterceptadorDeAcessos;
import br.com.jonataslaet.mvc.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("/api/acessos")
public class AcessosRestController {

	@GetMapping
	public List<Acesso> getAcessos(){
		return InterceptadorDeAcessos.acessos;
	}
}
