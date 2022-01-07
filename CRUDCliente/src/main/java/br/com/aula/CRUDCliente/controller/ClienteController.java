package br.com.aula.CRUDCliente.controller;

import br.com.aula.CRUDCliente.model.Cliente;
import br.com.aula.CRUDCliente.sevices.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody //RETURN JSON
@RequestMapping(path = "/api")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    //LIST ALL CLIENTS
    @GetMapping(path = "/clientes")
    public ResponseEntity<List<Cliente>> listAll(){
        return ResponseEntity.status(HttpStatus.OK).body(clienteService.findAll());
    }
    //SAVE CLIENT
    @PostMapping(path = "/salvarcliente")
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){

       return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(cliente));
    }

    //FIND BY ID
    @GetMapping(path = "/cliente/{id}")
    public ResponseEntity<Cliente> findCliente(@PathVariable Long id){

        Cliente cliente = clienteService.findById(id);

        if(cliente != null){
            return ResponseEntity.status(HttpStatus.OK).body(cliente);
        }else{
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //UPDATE CLIENT
    @PutMapping(path = "/cliente")
    public ResponseEntity<Cliente> atualizar(@RequestBody Cliente cliente){
        if(clienteService.findById(cliente.getId()) != null){
           //UPDATE ID FROM ADDRESS
           cliente.getAddress().setId(cliente.getId());
           Cliente clienteAtt = clienteService.update(cliente);
            return ResponseEntity.status(HttpStatus.OK).body(clienteAtt);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //DELETE CLIENT
    @DeleteMapping(path = "/cliente/delete/{id}")
    public ResponseEntity<?> deletarCliente(@PathVariable  Long id){
        if(clienteService.findById(id) != null){
            clienteService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente deletado com sucesso!");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente Não existe!");
        }
    }



}
