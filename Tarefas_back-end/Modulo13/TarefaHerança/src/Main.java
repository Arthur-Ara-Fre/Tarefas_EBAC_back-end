public class Main {
    public static void main(String[] args){
        PessoaFisica PF = new PessoaFisica();
        PF.setNome("Arthur");
        PF.setCpf("1");
        PF.setDataNascimento("29/12/2000");

        PessoaJuridica PJ = new PessoaJuridica();
        PJ.setNome("Arthur Entertainment");
        PJ.setCnpj("123");
        PJ.setDataCriacao("01/05/2025");
        System.out.println(PF+"\n\n"+PJ);




    }
}
