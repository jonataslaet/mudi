package br.com.jonataslaet.mvc.mudi.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.jonataslaet.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@GetMapping(value="/home")
	String retornaHello(Model model) {
		Pedido pedido = new Pedido();
		List<Pedido> pedidos = new ArrayList<>();
		pedido.setNomeProduto("Relógio Amazfit GTS A1914");
		pedido.setValorNegociado(new BigDecimal("679.3"));
		pedido.setDataDaEntrega(LocalDate.of(2021, Month.MARCH, 5));
		pedido.setUrlProduto("https://www.amazon.com.br/Rel%C3%B3gio-Amazfit-GTS-A1914-Preto/dp/B07XWT23FZ/");
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/713Wup56jcL._AC_SL1500_.jpg");
		pedido.setDescricao("Muito mais do que um Relógio, o Amazfit é um smartwatch da Xioami com diversas funções que darão mais facilidade para sua vida, além é claro de mostrar as horas. ");
		
		pedidos.add(pedido);
		
		model.addAttribute("pedidos", pedidos);
		return "home";
	}
}
