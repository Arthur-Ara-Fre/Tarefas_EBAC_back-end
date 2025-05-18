/**
 * 
 */
package br.com.afreitas;

/**
 * Trouxe o objeto casa com duas ints e dois strings alem de exemplos variados metodos
 */
public class Casa {
	
	private int quartos;
	private int banheiros;
	private String  painelSolar = "sim";
	
	public int getQuartos() {
		return quartos;
	}
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}
	public int getBanheiros() {
		return banheiros;
	}
	public void setBanheiros(int banheiros) {
		this.banheiros = banheiros;
	}
	public String getPainelSolar() {
		return painelSolar;
	}
	public void setPainelSolar(String painelSolar) {
		this.painelSolar = painelSolar;
	}
	public void imprimirBanheiros() {
		System.out.print("Banheiros:");
		System.out.println(this.banheiros);
		
	}
	
	
}
