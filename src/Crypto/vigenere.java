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
	//int [] distrib = new int[256];
	ArrayList<Integer> tab = new ArrayList<Integer>();

	public void lireFichier(){
		FileInputStream fis =null;
		byte [] c = new byte[2];
		//String c = "00";
		try {
			fis = new FileInputStream(new File("src/Crypto/Data/entree.txt"));
			while ((fis.read(c, 0, c.length))>=0){
				char [] copie = new char[2];
				copie[0] = (char)c[0];
				copie[1] = (char)c[1];
				//System.out.println(String.copyValueOf(copie));
				tab.add((hex2decimal(String.copyValueOf(copie))));
				System.out.print(hex2decimal(String.copyValueOf(copie)) + " ");
				//tab.add((byte)((byte)c[0]*16+(byte)c[1]));
				longueurTexte++;
			}
			System.out.println("");
			System.out.println("Nombre de caracteres : " + longueurTexte);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void calculerDistribution(int longueurCle, int offset) {
		if(offset>longueurCle){
			System.out.println("Erreur de parametres");
			return;
		}
		int [] distrib = new int[256];
		int pos = offset-1;
		int nbrElements = 0;
		while (pos<tab.size()){
			//System.out.println(tab.get(pos));
			distrib[tab.get(pos)]++;
			pos+=longueurCle;
			nbrElements++;
		}
		double somme = 0;
		for(int i : distrib) {
			somme+=((double)i/(double)nbrElements)*((double)i/(double)nbrElements);
		}
		//System.out.println(1.0/256.0);
		System.out.println("longueur cle : " + longueurCle + ". Offset : " + offset + " -");
		System.out.println("la somme vaut " + somme + " et l'ecart vaut " + Math.abs(somme-(1.0/256.0)));
		trouverCle(distrib, longueurCle, offset);
	}
	
	public void trouverCle(int [] distrib, int longueurCle, int offset){
		int max =0;
		for(int i=255; i>=0; i--) {
			if(distrib[i]>distrib[max]){
				max=i;
			}
		}
		int cle=0;
		int decode=101;
		while((max^cle)!=decode){
			cle++;
		}
		//cle=187; // essai d'une cle 
		System.out.println("la cle est : "+cle);
		int pos=offset-1;
		int nb=0; // nombre de caractères hors intervalle  32 - 127
		for (cle=0; cle<256; cle++){ // boucle optionnelle
		pos = offset-1;
		nb = 0;
		while (pos<tab.size()){
			int temp = cle^(tab.get(pos));
			if (temp<32 || temp >127){
				nb++;
			}
			pos+=longueurCle;
		}
		System.out.println("Le nombre de caractère hors intervalle est : " + nb + ". (Cle = " + cle);
		} // fin boucle optionnelle
	}
	
	public void decoder(){
		int [] cle = {186, 31, 145, 178, 83, 205 , 62};
		int pos=0;
		int i=0;
		while (pos<tab.size()){
			int temp = cle[i]^(tab.get(pos));
			System.out.print((char)temp);
			i++;
			if (i==7){
				i=0;
				//System.out.println("");
			}
			pos++;
		}
	}
	
	public void decoder2(int a){
		int pos=6;
		while (pos<tab.size()){
			int temp = a^(tab.get(pos));
			System.out.print((char)temp);
			pos+=7;
		}
	}

	
	public static int hex2decimal(String s) {
		String digits = "0123456789ABCDEF";
		//s = s.toUpperCase();
		int val = 0;
		for (int i = 0; i<2; i++) {
			char c = s.charAt(i);
			int d = digits.indexOf(c);
			val = 16*val + d;
		}
		return val;
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
			System.out.println("Copie terminï¿½e.");
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