package api_agencia.apiagenciaviagens.controllers;

import api_agencia.apiagenciaviagens.models.PedidoModel;
import api_agencia.apiagenciaviagens.repositories.PedidoRepository;
import api_agencia.apiagenciaviagens.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PedidoController {

//    final PedidoServices pedidoServices;
//
//    public PedidoController(PedidoServices pedidoServices) {
//        this.pedidoServices = pedidoServices;
//    }
    @Autowired
    private PedidoServices pedidoServices;

    @GetMapping
    public ResponseEntity <List<PedidoModel>> getAllPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.findAll());
    }
}
