package br.com.afreitas.services.generics;

import br.com.afreitas.dao.generics.IGenericDAO;
import br.com.afreitas.domain.Persistente;
import br.com.afreitas.exceptions.TipoChaveNaoEncontradaException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;


/**
*@author arthur.freitas
*/public abstract class GenericService<T extends Persistente,E extends Serializable> implements IGenericService<T,E> {

    protected  IGenericDAO<T, E> dao;

    public GenericService(IGenericDAO<T, E> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean salvar(T entity) throws TipoChaveNaoEncontradaException {
        return this.dao.cadastrar(entity);
    }

    @Override
    public void excluir(E valor) {
        this.dao.excluir(valor);
    }

    @Override
    public void mudar(T entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public T pesquisar(E valor) {
        return this.dao.consultar(valor);
    }

    @Override
    public Collection<T> buscarTodos() {
        return List.of();
    }
}
