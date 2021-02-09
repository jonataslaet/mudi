package br.com.jonataslaet.mvc.mudi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.jonataslaet.mvc.mudi.model.Pedido;
import br.com.jonataslaet.mvc.mudi.model.StatusPedidoEnum;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedidoEnum status);
	
}
