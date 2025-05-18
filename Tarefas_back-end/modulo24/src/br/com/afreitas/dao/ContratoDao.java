package br.com.afreitas.dao;

/**
 * @author arthur.freitas
 */
public class ContratoDao implements IContratoDAO {

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com banco");}

    @Override
    public void buscar() {throw new UnsupportedOperationException("Falha na busca");}

    @Override
    public void excluir() { throw new UnsupportedOperationException("Erro ao Excluir");}

    @Override
    public void atualizar() { throw new UnsupportedOperationException("Falha ao Atualizar");}
}