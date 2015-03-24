package Crypto;

public class Test {

	public static void main(String[] args) {
		vigenere essai = new vigenere();
		essai.lireFichier();
		/*for (int i=1; i<=13; i++){
			essai.calculerDistribution(i, 1);
		}*/

		
		essai.calculerDistribution(7, 1);
		//essai.trouverCle();
		//essai.decoder();
		
	}

}
