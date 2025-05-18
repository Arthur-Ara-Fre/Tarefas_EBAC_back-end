package br.com.br.a.freitas;

import java.util.Scanner;

public class Calculo {
	
	public void pegarCalcularRevisar() {
		Scanner s = new Scanner(System.in);	
		
		System.out.print("Insira a nota 1: ");
		float nota1 = s.nextFloat();
		
		System.out.print("Insira a nota 2: ");
		float nota2 = s.nextFloat();
		
		System.out.print("Insira a nota 3: ");
		float nota3 = s.nextFloat();
		
		System.out.print("Insira a nota 4: ");
		float nota4 = s.nextFloat();
		
		float soma = 0;
		float media = 0;
		
		soma = somar(nota1, nota2, nota3, nota4);
		
		
		media = CalcularMedia(soma);
		
		RevisarNotas(media);
		
		s.close();
	}
	
	public float somar(float nota1, float nota2, float nota3, float nota4) {
		float soma;
		soma = nota1 +  nota2 + nota3 + nota4;
		System.out.println("A soma é " + soma);
		
		return soma;
	}
	
	public float CalcularMedia(float soma) {
		float media = soma/4;
		System.out.println("A media é " + media);
		
		return media;
	}
	
	public void RevisarNotas(float media) {
		if(media >= 7) {
			System.out.println("Aprovado");
		}
		else if(media >=5 && media <7) {
			System.out.println("Recuperação");
		}
		else {
			System.out.println("Reprovado");
		}
		
	}
}
