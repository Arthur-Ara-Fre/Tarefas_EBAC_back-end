package br.com.afreitas;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


/**
 * @author arthur.freitas
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("Insira os nomes seguido por -f para feminino" +
                " e -m para masculino, separados por virgula.\n" +
                "Exemplo:Arthur-m,Maria-f");

        List<String> nomes = List.of(new Scanner(System.in).nextLine().split(","));

        List<String> feminino = nomes.stream()
                        .filter(nome-> nome.toLowerCase().endsWith("-f"))
                .collect(Collectors.toList());

        System.out.println(feminino);
    }
}