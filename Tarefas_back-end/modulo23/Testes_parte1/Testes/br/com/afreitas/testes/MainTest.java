package br.com.afreitas.testes;

import org.junit.Assert;
import org.junit.Test;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author arthur.freitas
 */

public class MainTest {

    @Test
    public void test(){
        List<String> nomes = List.of("Arthur-m","Rodrigo-M","Maria-f","Isabela-F");

        List<String> feminino = nomes.stream()
                .filter(nome-> nome.toLowerCase().endsWith("-f"))
                .collect(Collectors.toList());

        List<String> teste = List.of("Maria-f","Isabela-F");

        //System.out.println(feminino);
        Assert.assertEquals(teste, feminino);
    }
}