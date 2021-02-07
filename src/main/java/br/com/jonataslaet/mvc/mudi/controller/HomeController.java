package br.com.jonataslaet.mvc.mudi.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.jonataslaet.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping(value="/home")
	String retornaHello(Model model) {
		
		List<Pedido> pedidos = new ArrayList<>();
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		pedidos = query.getResultList();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
