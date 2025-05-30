package br.com.afreitas.dao.generics;

import br.com.afreitas.domain.Persistente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;

import java.io.Serializable;
import java.util.Collection;

/**
 * @author arthur.freitas
 */
public interface IGenericDAO<T extends Persistente, E extends Serializable> {
    Boolean cadastrar(T entity) throws TipoChaveNaoEncontradaException;

    void excluir(E valor);

    void  alterar(T entity) throws TipoChaveNaoEncontradaException;

    T consultar(E valor);

    Collection<T> buscarTodos();
}
