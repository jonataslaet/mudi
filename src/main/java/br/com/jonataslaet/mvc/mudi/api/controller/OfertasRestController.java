package br.com.jonataslaet.mvc.mudi.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jonataslaet.mvc.mudi.api.controller.dto.RequisicaoNovaOferta;
import br.com.jonataslaet.mvc.mudi.model.Oferta;
import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRestController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public Oferta criaOferta(@RequestBody RequisicaoNovaOferta requisicao) {
		Optional<Pedido> pedidoEncontrado = pedidoRepository.findById(requisicao.getPedidoId());
		if (!pedidoEncontrado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoEncontrado.get();
		Oferta oferta = requisicao.toOferta();
		oferta.setPedido(pedido);
		pedido.getOfertas().add(oferta);
		pedidoRepository.save(pedido);
		return oferta;
	}
}
