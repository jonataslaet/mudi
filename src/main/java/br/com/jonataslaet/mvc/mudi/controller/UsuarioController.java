package br.com.jonataslaet.mvc.mudi.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.model.StatusPedidoEnum;
import br.com.jonataslaet.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping("/pedidos")
	String findAll(Model model, Principal principal) {
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = pedidoRepository.findAllByUsuario(principal.getName());
		
		model.addAttribute("pedidos", pedidos);
		return "usuarios/home";
	}
	
	@GetMapping("/pedidos/{status}")
	String findAllByStatus(@PathVariable("status") String status, Model model, Principal principal) {
		
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = pedidoRepository.findByStatusAndUser(StatusPedidoEnum.valueOf(status.toUpperCase()), principal.getName());
		
		model.addAttribute("pedidos", pedidos);
		return "usuarios/home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuarios/home";
	}
}
