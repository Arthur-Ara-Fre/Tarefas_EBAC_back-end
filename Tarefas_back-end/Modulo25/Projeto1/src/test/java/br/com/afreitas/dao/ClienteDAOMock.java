package br.com.afreitas.dao;


import br.com.afreitas.domain.Cliente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * @author arthur.freitas
 */
public class ClienteDAOMock implements IClienteDAO {

    @Override
    public Boolean cadastrar(Cliente entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(Cliente entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public Cliente consultar(Long valor) {
        Cliente cliente = new Cliente();
        cliente.setCpf(valor);
        return cliente;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return null;
    }
}
