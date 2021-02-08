package br.com.jonataslaet.mvc.mudi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String formulario() {
		
		return "pedidos/formulario";
	}

	@PostMapping("novo")
	public String save(RequisicaoNovoPedido novoPedido) {
		Pedido pedidoNovo = novoPedido.toPedido();
		pedidoRepository.save(pedidoNovo);
		return "pedidos/formulario";		
	}
}
