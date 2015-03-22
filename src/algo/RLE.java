package algo;


public class RLE extends Exception {
	
	public static int longueurRLE(int[] t) throws IllegalArgumentException
		{
		int ret;	
		int longueur;
		int precedent;
		if (t==null){
				throw new IllegalArgumentException();
			} else {
				if (t.length==0){
					ret = 0;
				} else {
					ret = 2;
					longueur = t.length;
					precedent = t[0];
					for (int i=1; i<longueur; i++){
						if (t[i]!=precedent){
							ret += 2;
						}
						precedent = t[i];
					}
				}
			}
		return ret;
		}
	
	public static int[] RLE(int[] t) {
		int[] tab = new int[longueurRLE(t)];
		int precedent;
		int indice = 1;
		if (t.length==0){
			return tab;
		} else {
			precedent = t[0];
			tab[0] = t[0];
			tab[1] = 1;
			for (int i=1; i<t.length; i++){
				if(t[i]!=precedent){
					tab[indice+1]=t[i];
					indice +=2;
					tab[indice] = 1;
				} else {
					tab[indice]++;
				}
				precedent = t[i];
			}
		}
		return tab;
	}
	
	public static int longueurRLEInverse(int[] t){
		int longueur;
		if (t.length==0){
			longueur = 0;
		} else {
			longueur = 0;
			for (int i=0; i<t.length;i+=2){
				longueur +=t[i+1];
			}
		}
		return longueur;
	}
	
	public static int[] RLEInverse(int[] t) {
		int[] tab = new int[longueurRLEInverse(t)];
		int indice =0;
		if (t.length==0){
			return tab;
		} else {
			for (int i=0; i<t.length;i+=2){
				for (int j=0; j<t[i+1]; j++){
					tab[indice] = t[i];
					indice++;
				}
			}
		}
		return tab;
	}
}
