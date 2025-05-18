package br.com.afreitas;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
	
	public static void main(String[] args) {
		exemplosListaSimples();
	}
	
		private static void exemplosListaSimples() {
	
			List<String> lista = new ArrayList<String>();
			Scanner s = new Scanner(System.in);
			
			System.out.print("Insira nomes e sobrenomes(opcional) separados por virgula.\n");
			System.out.println("Exemplo:Arthur,João Araújo.\nLetras Maiusculas tem prioriadade sobre as letras minusculas na ordenação automática.\n");
			
			String nomes = s.nextLine();	
			String[] vet = nomes.split(",");
			
			for(int i=0; i<vet.length; i++) {
				
				lista.add(vet[i]);
				
			}
			
			Collections.sort(lista);
			
			System.out.println("\n\n********************Lista ordenada********************");
			System.out.println("\n"+lista+"\n\n");
			
			s.close();
		}
	
}
