package br.com.aula.CRUDCliente.sevices;


import br.com.aula.CRUDCliente.model.Cliente;
import br.com.aula.CRUDCliente.model.Endereco;
import br.com.aula.CRUDCliente.repository.ClienteRepository;
import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoService enderecoService;

    //LIST ALL CLIENTS
    public List<Cliente> findAll(){
        return clienteRepository.findAll();
    }

    //RETURN BY ID
    public  Cliente findById(Long id){
        if(clienteRepository.findById(id).isPresent()){
            return clienteRepository.findById(id).get();
        }else{
            return null;
        }

    }

    //UPDATE CLIENT
    public Cliente update(Cliente cliente){
        Endereco endereco = enderecoService.save(cliente.getAddress());
        cliente.setAddress(endereco);
        return clienteRepository.save(cliente);
    }

    //DELETE CLIENT
    public void  delete(Long id){
        clienteRepository.deleteById(id);
        enderecoService.delete(id);

    }

    //SAVE CLIENTS
    public Cliente save(Cliente cliente){
        Endereco endereco = enderecoService.save(cliente.getAddress());
        cliente.setAddress(endereco);
        return clienteRepository.save(cliente);
    }

}
