package br.com.jonataslaet.mvc.mudi.api.controller.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.jonataslaet.mvc.mudi.model.Oferta;
import br.com.jonataslaet.mvc.mudi.util.Data;

public class RequisicaoNovaOferta {

	private Long pedidoId;
	
	@Pattern(regexp="^\\d+(\\.\\d+{2})?$")
	@NotNull
	private String valor;
	
	@Pattern(regexp="^\\d{2}/\\d{2}/\\d{4}$", message = "deve corresponder ao formato dd/MM/yyyy")
	@NotNull
	private String dataDaEntrega;
	
	private String comentario;

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataDaEntrega() {
		return dataDaEntrega;
	}

	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(this.comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, Data.formatter("dd/MM/yyyy")));
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
}
