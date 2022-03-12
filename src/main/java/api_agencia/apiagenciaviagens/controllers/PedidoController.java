package api_agencia.apiagenciaviagens.controllers;

import api_agencia.apiagenciaviagens.models.PedidoModel;

import api_agencia.apiagenciaviagens.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PedidoController {

    @Autowired
    private PedidoServices pedidoServices;

    @GetMapping
    public ResponseEntity <List<PedidoModel>> getAllPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.findAll());
    }

    @PostMapping
    public ResponseEntity<Object> savePedido (@RequestBody PedidoModel pedidoModel){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoServices.save(pedidoModel));
    }
}
