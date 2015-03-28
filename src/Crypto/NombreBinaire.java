package Crypto;

public class NombreBinaire {
	private int nbrBinaire = 0b10101100;
	
	public NombreBinaire(int nbr){
		nbrBinaire = nbr;
	}
	
	public NombreBinaire(char nbr){
		nbrBinaire = (int)nbr;
	}
	
	//
	// Accesseurs du nombre binaire
	//
	public int getNbrInteger(){
		return nbrBinaire;
	}
	public String getNbrStringHex(){
		String str = new String();
		
		return str;
	}
	public String getNbrStringBin(){
		String str = new String();
		
		return str;
	}
	
	
}
