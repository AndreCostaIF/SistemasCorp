package br.com.aula.CRUDCliente.sevices;

import br.com.aula.CRUDCliente.model.Cliente;
import br.com.aula.CRUDCliente.model.Endereco;
import br.com.aula.CRUDCliente.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    //LIST ALL ADDRESS
    public List<Endereco> findAll(){
        return  enderecoRepository.findAll();
    }

    //SAVE ON DATABASE
    public Endereco save(Endereco endereco){

        return enderecoRepository.save(endereco);
    }



    //DELETE CLIENT
    public void  delete(Long id){
        enderecoRepository.deleteById(id);

    }


}
