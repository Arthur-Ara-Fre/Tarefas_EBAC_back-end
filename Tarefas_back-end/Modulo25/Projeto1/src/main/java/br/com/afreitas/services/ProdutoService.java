package br.com.afreitas.services;

import br.com.afreitas.dao.IProdutoDAO;
import br.com.afreitas.domain.Produto;
import br.com.afreitas.services.generics.GenericService;

/**
*@author arthur.freitas
*/public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    public ProdutoService(IProdutoDAO dao) {
        super(dao);
    }

}
