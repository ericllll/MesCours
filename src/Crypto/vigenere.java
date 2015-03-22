package Crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class vigenere {
	
	// longueur du texte
	int longueurTexte = 0;
	// longueur de la cle
	int longueurCle = 0;
	int [] distrib = new int[256];
	ArrayList<Byte> tab = new ArrayList<Byte>();

	public void lireFichier(){
		FileInputStream fis =null;
		byte [] c = new byte[1];
		try {
			fis = new FileInputStream(new File("entree.txt"));
			while ((fis.read(c, 0, c.length))>=0){
				System.out.print((char)c[0]);
				tab.add((byte)c[0]);
				longueurTexte++;
			}
			System.out.println("");
			System.out.println("Nombre de caractères : " + longueurTexte);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void calculerDistribution(int longueurCle, int offset) {
		if(offset>longueurCle){
			System.out.println("Erreur de paramètres");
			return;
		}
		//int [] distrib = new int[256];
		int pos = offset-1;
		int nbrElements = 0;
		while (pos<tab.size()){
			distrib[tab.get((pos))]++;
			pos+=longueurCle;
			nbrElements++;
		}
		double somme = 0;
		for(int i : distrib) {
			somme+=((double)i/(double)nbrElements)*((double)i/(double)nbrElements);
		}
		//System.out.println(1.0/256.0);
		System.out.println("longueur clé : " + longueurCle + ". Offset : " + offset + " -");
		System.out.println("la somme vaut " + somme + " et l'ecart vaut " + Math.abs(somme-(1.0/256.0)));
	}
	public void trouverCle(){
		int max =0;
		for(int i=0; i<256; i++) {
			if(distrib[i]>distrib[max]){
				max=i;
			}
		}
		byte encode=(byte)max;
		byte cle=0;
		byte decode=101;
		while((encode^cle)!=decode){
			cle++;
		}
		System.out.println("la cle est : "+cle);
	}
	
	public void decoder(){
		byte [] cle = {33, 86, 82, 38, 35, 80 ,33};
		int pos=0;
		int i=0;
		while (pos<tab.size()){
			byte temp = (byte)(cle[i]^(tab.get(pos)));
			System.out.print((char)temp);
			i++;
			if (i==7){
				i=0;
			}
			pos++;
		}
	}
	
}
	
	/*
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fis = new FileInputStream(new File("entree.txt"));
			fos = new FileOutputStream(new File("sortie.txt"));
			
			byte[] buf = new byte[8];
			
			int n = 0;
			
			while ((n = fis.read(buf))>=0){
				fos.write(buf);
				for (byte bit : buf) {
					System.out.println("\t" + bit + "(" + (char)bit + ")");
					System.out.println("");
				}
				//buf = new byte[8];
			}
			System.out.println("Copie terminée.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		} finally {
			try {
				if (fis != null){
					fis.close();
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			try {
				if (fos != null){
					fos.close();
				}
			} catch (IOException e){
				e.printStackTrace();
			}
		}
	}

}
*/