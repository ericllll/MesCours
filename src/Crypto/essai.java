package Crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

public class essai {
	
	// longueur du texte
	int longueurTexte = 0;
	// longueur de la cle
	int longueurCle = 0;
	int [] distrib = new int[256];
	
	public static void calculerDistrib() {
		
	}

	public static void main(String[] args) {
		
		// tableau des valeurs lues
		ArrayList<Integer> tab = new ArrayList<Integer>() ;
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(new File("entree.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		byte[] entree = new byte[2];
		int n=0 ;
		try {
			while((n = fis.read(entree, 0, 2))!=-1){
				//char c = (char) entree[0];
				//char d = (char) entree[1];
				tab.add(((int)((Character.digit(entree[0], 16) << 4))) + ((int)((Character.digit(entree[1], 16)))));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		//System.out.println(tab.get(0));
		System.out.println("Longueur du tableau : " + tab.size() );
		
		int freq = 4;
		int[] prob = new int[256];
		
		int indice = 0;
		while (indice<tab.size()){
			prob[tab.get(indice)]++;
			indice+=freq;
		}
		int i=0;
		double somme1 = 0.0;
		double somme2 = 0.0;
		while (i<prob.length){
			//System.out.println(i + (" : " + prob[i]));
			somme1+=(1.0/(double)prob[i])*(1.0/(double)prob[i]);
			System.out.printf("somme1 = %.12f",(1.0/(double)prob[i])*(1.0/(double)prob[i]));
			System.out.println("");
			somme2+=(double)prob[i]*(double)prob[i];
			i++;
		}
		double u = 1F/256F;
		//double u = 1L/(double)256;
		//DecimalFormat df = new DecimalFormat("0,00000");
		System.out.printf("1/256 = %.8f",u);
		System.out.println("");
		System.out.printf("somme1 = %.8f",somme1);
		System.out.println("");
		System.out.printf("somme2 = %.8f",somme2);
		System.out.println("");
		
	}
}
