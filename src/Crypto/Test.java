package Crypto;

public class Test {

	public static void main(String[] args) {
		vigenere essai = new vigenere();
		essai.lireFichier();
		/*for (int i=1; i<=30; i++){
			essai.calculerDistribution(i, 3);
		}*/
		essai.calculerDistribution(7, 7);
		essai.trouverCle();
		essai.decoder();
	}

}
