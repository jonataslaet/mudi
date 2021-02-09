package br.com.jonataslaet.mvc.mudi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jonataslaet.mvc.mudi.PedidoRepository;
import br.com.jonataslaet.mvc.mudi.controller.dto.RequisicaoNovoPedido;
import br.com.jonataslaet.mvc.mudi.model.Pedido;

@Controller
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPedido novoPedido) {
		
		return "pedidos/formulario";
	}

	@PostMapping("novo")
	public String save(@Valid RequisicaoNovoPedido novoPedido, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedidos/formulario";
		}
		
		Pedido pedidoNovo = novoPedido.toPedido();
		pedidoRepository.save(pedidoNovo);
		return "redirect:/home";		
	}
}
