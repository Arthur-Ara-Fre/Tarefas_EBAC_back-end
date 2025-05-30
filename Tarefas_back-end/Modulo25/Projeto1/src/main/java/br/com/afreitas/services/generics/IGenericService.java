package br.com.afreitas.services.generics;

import br.com.afreitas.domain.Persistente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
*@author arthur.freitas
*/
public interface IGenericService<T extends Persistente,E> {
     Boolean salvar(T entity) throws TipoChaveNaoEncontradaException;

     void excluir(E valor);

     void  mudar(T entity) throws TipoChaveNaoEncontradaException;

     T pesquisar(E valor);

     Collection<T> buscarTodos();
}
