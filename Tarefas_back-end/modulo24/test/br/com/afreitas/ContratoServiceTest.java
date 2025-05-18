package br.com.afreitas;

import br.com.afreitas.dao.ContratoDao;
import br.com.afreitas.dao.mocks.ContratoDAOMock;
import br.com.afreitas.dao.IContratoDAO;
import br.com.afreitas.service.ContratoService;
import br.com.afreitas.service.IContratoService;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author arthur.freitas
 */
public class ContratoServiceTest {

    @Test
    public void salvarTest() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoSalvarTest() {
        IContratoDAO dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.salvar();
        Assert.assertEquals("Sucesso", retorno);
    }

    @Test
    public void buscar() {
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Encontrado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoBuscarTest() {
        IContratoDAO dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.buscar();
        Assert.assertEquals("Encontrado", retorno);
    }

    @Test
    public void ExcluirTest(){
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluído", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroNoExcluirTest() {
        IContratoDAO dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.excluir();
        Assert.assertEquals("Excluído", retorno);
    }

    @Test
    public void atualizar(){
        IContratoDAO dao = new ContratoDAOMock();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void esperadoErroEmAtualizar(){
        IContratoDAO dao = new ContratoDao();
        IContratoService service = new ContratoService(dao);
        String retorno = service.atualizar();
        Assert.assertEquals("Atualizado", retorno);
    }
}
