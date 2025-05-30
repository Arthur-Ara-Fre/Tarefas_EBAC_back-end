package br.com.afreitas.services;

import br.com.afreitas.dao.IClienteDAO;
import br.com.afreitas.domain.Cliente;
import br.com.afreitas.services.generics.GenericService;

/**
 * @author arthur.freitas
 */
public class ClienteService extends GenericService<Cliente, Long> implements IClienteService {

    //private IClienteDAO clienteDAO;

   public ClienteService(IClienteDAO clienteDAO){
       super(clienteDAO);
       //this.clienteDAO =  clienteDAO;
    }

    @Override
    public Cliente pesquisar(Long valor) {
        return this.dao.consultar(valor);
    }
}
