package br.com.afreitas.services;

import br.com.afreitas.domain.Cliente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author arthur.freitas
 */
public interface IClienteService{

    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente pesquisar(Long num);

    void excluir(Long num);

    void mudar(Cliente cliente) throws TipoChaveNaoEncontradaException;
}
