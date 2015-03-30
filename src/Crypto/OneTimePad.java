package Crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class OneTimePad {
	
	// longueur du texte
	//int longueurTexte = 0;
	// longueur de la cle
	//int longueurCle = 0;
	//int [] distrib = new int[256];
	ArrayList<Integer> tab = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
	}
	
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
}
