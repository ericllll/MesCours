package algo;

// Ces squelettes sont à compléter et sont là uniquement pour prévenir des
// erreurs de compilation.
class LZ77 {
	public static Occurrence plusLongueOccurrence(int[] t, int positionCourante, int tailleFenetre) {
		Occurrence ocCourante = new Occurrence(0,0);
		Occurrence ocTrouvee = new Occurrence(0,0);
		
		if(tailleFenetre>positionCourante) {
			tailleFenetre = positionCourante;
		}
		
		//parcrous de la fen�tre de t-tailleFenetre � t-1
		int position1=0;
		int position2=0;
		
		for (int i=positionCourante-tailleFenetre; i<positionCourante; i++){
			// i est l'indice de recherche courant
			boolean verif = false;
			boolean horsLimite = false;
			position1=i;
			position2=positionCourante;
			do {
				if ((t[position1]==t[position2]) && !horsLimite){
					if (!verif){
						verif=true;
						ocCourante.retour= positionCourante-position1;
						ocCourante.taille=1;
					} else {
						ocCourante.taille++;
					}
					position1++;
					position2++;
					if ((position1>=positionCourante) || (position2>=t.length)){
						horsLimite = true;
						position2--;
					}
				} else {
					if (verif) {
						if (ocCourante.taille>ocTrouvee.taille){
							ocTrouvee.taille=ocCourante.taille;
							ocTrouvee.retour=ocCourante.retour;
						}
						verif=false;
						ocCourante.taille=0; // voir si c'est utile
						ocCourante.retour=0; // voir  si c'est utile
					}
				}
			} while (verif);
		}
		
		
		return ocTrouvee;
	}
	
	public static int LZ77Longueur(int[] t, int tailleFenetre){
		Occurrence ocCourante = new Occurrence(0,0);
		int pos=0 ; // position courante
		int tailleFinale = 0;
		int memPos =0;
		do {
			ocCourante = plusLongueOccurrence(t, pos, tailleFenetre);
			memPos = pos + ocCourante.taille;
			pos += ocCourante.taille +1 ;
			tailleFinale += 1;
		} while(t[memPos]!=2);
		return tailleFinale;
	}
	
	public static Element[] LZ77(int[] tab, int tailleFenetre){
		int tailleComp = LZ77Longueur(tab, tailleFenetre);
		Element[] tabComp = new Element[tailleComp];
		
		Occurrence ocCourante = new Occurrence(0,0);
		int pos=0 ; // position courante
		int memPos =0;
		
		int indice = 0;
		do {
			ocCourante = plusLongueOccurrence(tab, pos, tailleFenetre);
			memPos = pos + ocCourante.taille;
			tabComp[indice] = new Element(new Occurrence(ocCourante.retour, ocCourante.taille), tab[memPos]);
			pos += ocCourante.taille +1 ;
			indice++;
		} while(tab[memPos]!=2);
		return tabComp;
	}
	
	public static void afficheEncode(Element[] tab) {
		for (Element tableau : tab){
			System.out.print("(" + tableau.e.retour + "," + tableau.e.taille + ")" + tableau.s);
		}
		System.out.println("");
	}
	
	public static int LZ77InverseLongueur(Element[] t) {
		int longueur = 0;
		for (Element tab : t) {
			longueur += 1+tab.e.taille; 
		}
		
		return longueur;
	}
	
	public static int[] LZ77Inverse(Element[] t) {
		int [] tabDecomp = new int[LZ77InverseLongueur(t)];
		int indice = 0;
		int indiceTmp = 0;
		for (Element tab : t) {
			indiceTmp = indice;
			for(int i = indice-tab.e.retour; i<(indice-tab.e.retour+tab.e.taille); i++) {
				tabDecomp[indiceTmp++] = tabDecomp[i]; 
			}
			indice = indiceTmp;
			tabDecomp[indice++] = tab.s;
		}
		return tabDecomp;
	}
	
	public static void afficheDecode(int[] t) {
		for (int tab : t) {
			System.out.print(tab + " ");
		}
		System.out.println("");
	}
	
}

class Element {
	Occurrence e;
	int s;
  Element (Occurrence e, int s) {
	  this.s = s;
	  this.e = e ;
  }
}

class Occurrence {
	int retour;
	int taille;
	
  Occurrence (int retour, int taille) {
	  this.retour = retour;
	  this.taille = taille;
  }
}
