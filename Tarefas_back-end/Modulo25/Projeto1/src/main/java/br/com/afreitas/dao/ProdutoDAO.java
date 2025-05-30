package br.com.afreitas.dao;

import br.com.afreitas.dao.generics.GenericDAO;
import br.com.afreitas.domain.Produto;

/**
 * @author arthur.freitas
 */
public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO{

    public ProdutoDAO() {super();}

    @Override
    public Class<Produto> getTipoClasse() {
        return  Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {
        entityCadastrado.setNome(entity.getNome());
        entityCadastrado.setCodigo(entity.getCodigo());
    }
}
