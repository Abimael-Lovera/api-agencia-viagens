package api_agencia.apiagenciaviagens.controllers;

import api_agencia.apiagenciaviagens.models.PedidoModel;

import api_agencia.apiagenciaviagens.services.PedidoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOnePedido(@PathVariable(value = "id") Long id){
        Optional<PedidoModel> pedidoModelOptional = pedidoServices.findById(id);
        if (pedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(pedidoModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletePedido(@PathVariable(value = "id") Long id){
        Optional<PedidoModel> pedidoModelOptional = pedidoServices.findById(id);
        if (pedidoModelOptional.isPresent()) {
            pedidoServices.delete(pedidoModelOptional.get());
            return ResponseEntity.status(HttpStatus.OK).body("Pedido Excluido com Sucesso");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> updatePedido(@PathVariable(value = "id") Long id,
                                               @RequestBody PedidoModel pedidoModel){
        Optional<PedidoModel> pedidoModelOptional = pedidoServices.findById(id);
        if (!pedidoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido nao encontrado");
        }
//        var pedidoModel = new PedidoModel();
        pedidoModel.setId(pedidoModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(pedidoServices.save(pedidoModel));
    }
}
