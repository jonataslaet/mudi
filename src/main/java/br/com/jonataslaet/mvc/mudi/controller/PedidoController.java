package br.com.jonataslaet.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jonataslaet.mvc.mudi.controller.dto.RequisicaoNovoPedido;
import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.model.User;
import br.com.jonataslaet.mvc.mudi.repository.PedidoRepository;
import br.com.jonataslaet.mvc.mudi.repository.UserRepository;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido novoPedido) {
		
		return "pedidos/formulario";
	}

	@PostMapping("novo")
	public String save(@Valid RequisicaoNovoPedido novoPedido, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedidos/formulario";
		}
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		Pedido pedidoNovo = novoPedido.toPedido();
		pedidoRepository.save(pedidoNovo);
		return "redirect:/home";		
	}
}
