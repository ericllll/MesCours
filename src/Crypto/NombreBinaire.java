package Crypto;

public class NombreBinaire {
	private int nbrBinaire;
	
	public NombreBinaire(int nbr){
		nbrBinaire = nbr;
	}
	
	public NombreBinaire(char nbr){
		nbrBinaire = (int)nbr;
	}
	
	public NombreBinaire(String nbr){
		String str1 = "0123456789ABCDEF";
		String str2 = "01";
		nbr.toUpperCase();
		boolean test = false;
		int i = 0;
		while(i<nbr.length() && test==false){
			if(str2.indexOf(nbr.charAt(i))==-1){
				test=true;
			}
			i++;
		}
		if(test==false){
			nbrBinaire = bin2Decimal(nbr);
		} else {
			i=0;
			test=false;
			while(i<nbr.length() && test==false){
				if(str1.indexOf(nbr.charAt(i))==-1){
					test=true;
				}
				i++;
			}
			if(test=false){
				nbrBinaire = hex2Decimal(nbr);
			} else {
				System.out.println("La chaine de caractère contient des caractères non valides pour un format binaire ou hexa.");
			}
		}
	}
	
	public NombreBinaire xor(NombreBinaire nbBin){
		NombreBinaire res = new NombreBinaire(nbBin.getNbrInteger()^this.nbrBinaire);
		return res;
	}
	
	public static int hex2Decimal(String s){
		String digits = "0123456789ABCDEF";
		s = s.toUpperCase();
		int val = 0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16*val + d;
		}
		return val;
	}
	
	public static int bin2Decimal(String s){
		String digits = "01";
		int val = 0;
		for (int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 2*val + d;
		}
		return val;
	}
	//
	// Accesseurs du nombre binaire
	//
	public int getNbrInteger(){
		return nbrBinaire;
	}
	public String getNbrStringHex(){
		String str = new String();
		str = Integer.toHexString(nbrBinaire);
		return str;
	}
	public String getNbrStringBin(){
		String str = new String();
		str = Integer.toBinaryString(nbrBinaire);
		return str;
	}
	
	
}
