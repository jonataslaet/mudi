package br.com.jonataslaet.mvc.mudi.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.model.StatusPedidoEnum;
import br.com.jonataslaet.mvc.mudi.repository.PedidoRepository;

@Controller
@RequestMapping(value="/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	String findAllByStatusEntregue(Model model, Principal principal) {
		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 1, sort);
		List<Pedido> pedidos = new ArrayList<>();
		pedidos = pedidoRepository.findByStatus(StatusPedidoEnum.ENTREGUE, paginacao);
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
	
}
