package Crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		FileInputStream fis =null;
		String str = new String();
		ArrayList<NombreBinaire> cy1, cy2, cy3, cy4, cy5, cy6, cy7;
		try {
			fis = new FileInputStream(new File("src/Crypto/Data/7ciphertexts.txt"));
			Scanner sc = new Scanner(fis);
			str =  sc.nextLine();
			cy1 = lireLigne(str);
			str =  sc.nextLine();
			cy2 = lireLigne(str);
			str =  sc.nextLine();
			cy3 = lireLigne(str);
			str =  sc.nextLine();
			cy4 = lireLigne(str);
			str =  sc.nextLine();
			cy5 = lireLigne(str);
			str =  sc.nextLine();
			cy6 = lireLigne(str);
			str =  sc.nextLine();
			cy7 = lireLigne(str);
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		
		try {
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		afficheCyBinaire(cy1);
		afficheCyBinaire(cy2);
		afficheCyBinaire(cy3);
		afficheCyBinaire(cy4);
		afficheCyBinaire(cy5);
		afficheCyBinaire(cy6);
		afficheCyBinaire(cy7);
		
		System.out.println("");
		
		ArrayList<NombreBinaire> cy;
		cy = xorLigne(cy7, cy1);
		afficheCyBinaire(cy);
		
	}
	
	private static void afficheCyBinaire(ArrayList<NombreBinaire> liste){
		int nb = liste.size();
		//System.out.println("longueur liste : " + nb);
		int i=1;
		while(i<nb){
			System.out.print("  " + i + " _" + liste.get(i).getNbrStringBin() + " ");
			i++; 
		}
		System.out.println("");
	}
	
	private static ArrayList<NombreBinaire> lireLigne(String str) {
		ArrayList<NombreBinaire> cy = new ArrayList<NombreBinaire>();
		int i=0;
		while(i<str.length()) {
			cy.add(new NombreBinaire(str.substring(i, i+2)));
			i+=2;
		}
		return cy;
	}
	private static ArrayList<NombreBinaire> xorLigne(ArrayList<NombreBinaire> l1, ArrayList<NombreBinaire> l2){
		int i=0;
		ArrayList<NombreBinaire> l = new ArrayList<NombreBinaire>();
		while(i<l1.size()){
			l.add(l1.get(i).xor(l2.get(i)));
			//System.out.println("go");
			i++;
		}
		return l;
	}

}
