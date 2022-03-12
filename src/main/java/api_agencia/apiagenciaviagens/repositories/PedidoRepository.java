package api_agencia.apiagenciaviagens.repositories;

import api_agencia.apiagenciaviagens.models.PedidoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Long> {
}
