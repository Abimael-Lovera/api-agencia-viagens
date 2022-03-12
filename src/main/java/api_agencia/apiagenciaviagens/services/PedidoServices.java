package api_agencia.apiagenciaviagens.services;

import api_agencia.apiagenciaviagens.models.PedidoModel;
import api_agencia.apiagenciaviagens.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findAll() {
        return pedidoRepository.findAll();
    }

    @Transactional
    public PedidoModel save(PedidoModel pedidoModel) {
        return  pedidoRepository.save(pedidoModel);
    }

    public Optional<PedidoModel> findById(Long id) {
        return pedidoRepository.findById(id);
    }
}
