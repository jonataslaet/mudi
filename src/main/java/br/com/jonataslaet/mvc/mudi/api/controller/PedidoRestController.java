package br.com.jonataslaet.mvc.mudi.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.model.StatusPedidoEnum;
import br.com.jonataslaet.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoRestController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("/aguardando")
	public List<Pedido> getPedidosAguardandoOferta(){
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 10, sort);
		List<Pedido> pedidosEncontrados = pedidoRepository.findByStatus(StatusPedidoEnum.AGUARDANDO, paginacao);
		return pedidosEncontrados;
	}
}
