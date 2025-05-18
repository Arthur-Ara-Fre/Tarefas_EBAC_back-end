package br.com.afreitas;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		List<String> masculino = new ArrayList<String>();
		List<String> feminino = new ArrayList<String>();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Insira nomes e sobrenomes(opcional) com -m(Masculino) ou -f(Feminino) no final separados por(,). Ex:Arthur Araújo-m,Jõao-m,Ana-Flávia-f.\n");
		
		String nomes = s.nextLine();
		String[]vet = nomes.split(",");
		
		for(int i=0; i<vet.length; i++) {
			if(vet[i].contains("-m")) {
				vet[i] = vet[i].substring(0, vet[i].length() - 2 );
				masculino.add(vet[i]);
			}
			else if(vet[i].contains("-f")){
				vet[i] = vet[i].substring(0, vet[i].length() - 2 );
				feminino.add(vet[i]);
			}
		}
		s.close();
		
		Collections.sort(masculino);
		Collections.sort(feminino);
		
		System.out.println();
		
		System.out.println("..................Masculinos...................");
		System.out.println(masculino+"\n");
		
		System.out.println("------------------Femininos--------------------");
		System.out.println(feminino);
	}

}
