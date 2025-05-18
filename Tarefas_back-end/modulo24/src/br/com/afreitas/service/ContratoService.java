package br.com.afreitas.service;

import br.com.afreitas.dao.IContratoDAO;

/**
 * @author arthur.freitas
 */
public class ContratoService implements IContratoService {

    private IContratoDAO contratoDAO;

    public ContratoService(IContratoDAO dao) { this.contratoDAO = dao;}

    @Override
    public String salvar() {
        contratoDAO.salvar();
        return "Sucesso";
    }

    @Override
    public String buscar() {
        contratoDAO.buscar();
        return "Encontrado";
    }

    @Override
    public String excluir() {
        contratoDAO.excluir();
        return "Excluído";
    }

    @Override
    public String atualizar() {
        contratoDAO.atualizar();
        return "Atualizado";
    }
}