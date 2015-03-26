package Crypto;

public class Test {

	public static void main(String[] args) {
		vigenere essai = new vigenere();
		essai.lireFichier();
		/*for (int i=1; i<=13; i++){
			essai.calculerDistribution(i, 4);
		}*/
		
		//essai.calculerDistribution(7, 7);

		//essai.trouverCle();
		
		essai.decoder();
		
		/*for (int i=32; i<=63; i++){
			System.out.print("ligne : " + i + " :   ");
			essai.decoder2(i);
			System.out.println("");
		}*/
		
	}

}
