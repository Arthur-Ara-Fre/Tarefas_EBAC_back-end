package br.com.br.a.freitas;

public class Calculo {
	
	private int nota1 = 10;
	private int nota2 = 20;
	private int nota3 = 30;
	private int nota4 = 40;
	private int media;
	
	
	
	public void soma(){
		
		media = nota1 + nota2 + nota3 + nota4;
		
	}
	public void media() {
		media /= 4; //media = media/4
		System.out.print("media = ");
		System.out.println(media);
	}
}

