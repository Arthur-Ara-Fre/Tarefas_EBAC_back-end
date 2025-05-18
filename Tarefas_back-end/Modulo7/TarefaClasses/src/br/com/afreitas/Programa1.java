/**
 * 
 */
package br.com.afreitas;

/**
 * usei várias maneiras de getters e setters na classe principal com o objetivo de demonstrar minha aprendizagem
 */
public class Programa1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Casa casa = new Casa();
		casa.setQuartos(3);
		casa.setBanheiros(2);
		/**casa.setPainelSolar("sim");*/
		System.out.println("A casa tem:");
		System.out.print("Quartos:");
		System.out.println(casa.getQuartos());
		casa.imprimirBanheiros();
		System.out.print("Painel Solar:");
		System.out.println(casa.getPainelSolar());
		

	}
	
}
