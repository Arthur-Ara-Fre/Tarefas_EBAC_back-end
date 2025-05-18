package br.com.afreitas;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author arthur.freitas
 */
public class Main {

    public static void main(String[] args) {

        UsoTabela usoTabela = new UsoTabela();

        for (Field field: usoTabela.getClass().getDeclaredFields()){
            if (field.isAnnotationPresent(Tabela.class)){
                Tabela tabela = field.getAnnotation(Tabela.class);
                assert tabela != null;
                System.out.println(tabela);
                System.out.println(Arrays.toString(tabela.value()));
            }
        }
    }
}