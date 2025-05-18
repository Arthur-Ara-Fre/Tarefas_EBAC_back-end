package br.com.afreitas;

import br.com.afreitas.dao.ClienteMapDAO;
import br.com.afreitas.dao.IClienteDAO;
import br.com.afreitas.domain.Cliente;

import javax.swing.*;

/**
 * @author arthur.freitas
 */
public class App {

    private static IClienteDAO iClienteDAO;

    public static void main(String[] args) {
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para excluir, 4 para alteração ou 5 para sair.",
                "Menu Principal", JOptionPane.INFORMATION_MESSAGE);

        //Loop do menu para que ele se repita até que o usuario queira sair.
         while (!isOpcaoSair(opcao)) {
            if (opcao.matches("^\\d+$")){
                //opção sair
                if (isOpcaoSair(opcao)) {
                    sair();
                }
                else if (isCadastro(opcao)) { //opção cadastro.
                    String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por vírgula conforme o exemplo :Nome,CPF,Telefone,Endereço,Número,Cidade,Estado.\n"+
                                    "Pelo menos nome e cpf devem ser inseridos.",
                            "Cadastro | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);

                    if(!"menu".equals(dados)){cadastrar(dados, opcao);}//voltar ao menu
                }
                else if (isConsultar(opcao)) { //Opção consultar.
                    String dados = JOptionPane.showInputDialog(null,
                            "Insira o cpf",
                            "Consultar | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);

                    if (!"menu".equals(dados)){consultar(dados);}
                }
                else if(isExcluir(opcao)) { //Opção excluir
                    String dados = JOptionPane.showInputDialog(null,
                            "Informe o cpf",
                            "Excluir | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);


                    if (!"menu".equals(dados)){ excluir(dados);}

                }
                else if(isAlterar(opcao)) { //Opção alterar
                    String dados = JOptionPane.showInputDialog(null,
                            "Digite os dados do cliente separados por vírgula, conforme o exemplo :Nome,CPF,Telefone,Endereço,Número,Cidade,Estado.\n"+
                                    "Pelo menos nome e cpf devem ser inseridos.",
                            "Alterar| Insira 'menu' para voltar",JOptionPane.INFORMATION_MESSAGE);

                    if(!"menu".equals(dados)) {alterar(dados, opcao);}
                }
            }

            opcao = JOptionPane.showInputDialog(null,
                    "Digite 1 para cadastro, 2 parar consultar, 3 para excluir,4 para alterar ou 5 para sair.",
                    "Menu", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isCadastro(String opcao) {
        return "1".equals(opcao);
    }

    private static boolean isConsultar(String opcao) {
        return "2".equals(opcao);
    }

    private static boolean isExcluir(String opcao) {
        return "3".equals(opcao);
    }

    private static boolean isAlterar(String opcao) {
        return "4".equals(opcao);
    }

    private static boolean isOpcaoSair(String opcao) {
        return "5".equals(opcao);
    }

    private static void cadastrar(String dados, String opcao) {
        String[] dadosSeparados = dados.split(",");

        //validar campos nulos
        for(int i = 0; i < dadosSeparados.length; i++){
            if(dadosSeparados[i].isEmpty() || dadosSeparados[i]==null){
                dadosSeparados[i]=null;
            }
        }

        //validar se pelo menos o nome e o cpf foram passados
        if (dadosSeparados.length==1) {
            dados = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente separados por vírgula, conforme o exemplo:Nome,CPF,Telefone,Endereço,Número,Cidade,Estado.\n"+
                            "Pelo menos nome e cpf devem ser inseridos.",
                    "Erro!Ambos nome e CPF são Obrigatórios | Insira 'menu' para voltar",JOptionPane.INFORMATION_MESSAGE);
            if(!"menu".equals(dados)){cadastrar(dados, opcao);}
        }
        else if(dadosSeparados[1].matches("^\\d+$")) { //verificar se o cpf tem apenas numeros

            if (dadosSeparados.length==7) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
                validar(cliente, opcao);
            }
            else if (dadosSeparados.length==6) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],null);
                validar(cliente, opcao);
            }
            else if (dadosSeparados.length==5) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],null,null);
                validar(cliente, opcao);
            }
            else if (dadosSeparados.length==4) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],null,null,null);
                validar(cliente, opcao);
            }
            else if (dadosSeparados.length==3) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],null,null,null,null);
                validar(cliente, opcao);
            }
            else if (dadosSeparados.length==2) {
                Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],null,null,null,null,null);
                validar(cliente, opcao);
            }
            else { //verificar se não foram passados mais de 7 campos
                dados = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vírgula, conforme o exemplo:Nome,CPF,Telefone,Endereço,Número,Cidade,Estado.\n"+
                                "Pelo menos nome e cpf devem ser inseridos.",
                        "Erro! Insira apenas 7 campos | Insira 'menu' para voltar ao menu.", JOptionPane.INFORMATION_MESSAGE);
                if(!"menu".equals(dados)){cadastrar(dados, opcao);}
            }
        }
        else {
            dados = JOptionPane.showInputDialog(null,
                    "Digite os dados do cliente separados por vírgula, conforme o exemplo:Nome,CPF,Telefone,Endereço,Número,Cidade,Estado.\n"+
                            "Ambos nome e cpf são obrigatórios.",
                    "Erro!Ambos Nome e CPF são Obrigatórios | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);
            if(!"menu".equals(dados)){cadastrar(dados, opcao);}
        }
    }

    private static void consultar(String dados) {
        if (dados != null && dados.matches("^\\d+$")){ //validar se foi passado apenas números
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));

            if (cliente != null){
                JOptionPane.showMessageDialog(null,"Cliente encontrado:"+ cliente, "Consultar", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(null,"Cliente não encontrado.", "Consultar", JOptionPane.INFORMATION_MESSAGE);
                dados = JOptionPane.showInputDialog(null,
                        "Insira o cpf:",
                        "Consultar | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);

                if (!"menu".equals(dados)){consultar(dados);}
            }
        }
        else  {
            JOptionPane.showMessageDialog(null,"Insira apenas numeros", "Consultar", JOptionPane.INFORMATION_MESSAGE);
            dados = JOptionPane.showInputDialog(null,
                    "Insira o cpf:",
                    "Consultar | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);

            if (!"menu".equals(dados)){consultar(dados);}
        }
    }

    private static void alterar(String dados, String opcao) {
       //Após passar os dados, a função cadastrar vai chamar a função validar, que identifica pela opção se é cadastro ou alteração
        cadastrar(dados,opcao);
    }

    private static void excluir(String dados) {
        if (dados.matches("^\\d+$")){
            Cliente cliente = iClienteDAO.consultar(Long.parseLong(dados));
            
            if (cliente != null){
                int confirmar = JOptionPane.showConfirmDialog(null,
                        "Este é o cpf do cliente que você deseja excluir?\n("+dados+")", "Confirmar", JOptionPane.YES_NO_OPTION);

                if(confirmar==0){
                    if (iClienteDAO.excluir(Long.parseLong(dados))) {
                        JOptionPane.showMessageDialog(null, "Cliente excluido.", "Exluir cliente", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Excluir cliente", JOptionPane.INFORMATION_MESSAGE);

                dados = JOptionPane.showInputDialog(null,
                        "Informe o cpf:",
                        "Excluir | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);

                if (!"menu".equals(dados)){excluir(dados);}

            }
           
        }
        else {
            dados = JOptionPane.showInputDialog(null,
                    "Formato cpf invalido. Insira somente numeros:",
                    "Excluir | Insira 'menu' para voltar ao menu",JOptionPane.INFORMATION_MESSAGE);


           if (!"menu".equals(dados)){ excluir(dados);}
        }
    }

    private static void validar(Cliente cliente, String opcao) {
        Cliente cliente1 = iClienteDAO.consultar(cliente.getCpf());

        if (cliente1 == null && isAlterar(opcao)){
            int confirmar = JOptionPane.showConfirmDialog(null,
                    "Cliente não cadastrado. Deseja cadastra-lo?", "Alterar", JOptionPane.YES_NO_OPTION);
            if (confirmar !=0){ return; }
        }
        else if (isAlterar(opcao)){
            iClienteDAO.alterar(cliente);
            JOptionPane.showMessageDialog(null, "Dados do cliente alterado.", "Alterar", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado){
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Cliente já cadastrado.", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo", "Sair ", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}