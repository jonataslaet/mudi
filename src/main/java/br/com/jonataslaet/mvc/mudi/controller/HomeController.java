package br.com.jonataslaet.mvc.mudi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.jonataslaet.mvc.mudi.PedidoRepository;
import br.com.jonataslaet.mvc.mudi.model.Pedido;

@Controller
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping(value="/home")
	String retornaHello(Model model) {
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = pedidoRepository.findAll();
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
