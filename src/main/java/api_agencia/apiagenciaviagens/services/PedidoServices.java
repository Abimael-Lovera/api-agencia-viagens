package api_agencia.apiagenciaviagens.services;

import api_agencia.apiagenciaviagens.models.PedidoModel;
import api_agencia.apiagenciaviagens.repositories.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoServices {

    @Autowired
    private PedidoRepository pedidoRepository;

    public List<PedidoModel> findAll() {
        return pedidoRepository.findAll();
    }

    public PedidoModel save(PedidoModel pedidoModel) {
        return  pedidoRepository.save(pedidoModel);
    }
}
