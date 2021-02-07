package br.com.jonataslaet.mvc.mudi;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import br.com.jonataslaet.mvc.mudi.model.Pedido;

@Repository
public class PedidoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Pedido> retornaTodosOsPedidos(){
		List<Pedido> pedidos = new ArrayList<>();
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		pedidos = query.getResultList();
		return pedidos;
	}

}
