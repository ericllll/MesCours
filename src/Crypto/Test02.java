package Crypto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		FileInputStream fis =null;
		String str = new String();
		try {
			fis = new FileInputStream(new File("src/Crypto/Data/7ciphertexts.txt"));
			Scanner sc = new Scanner(fis);
			str =  sc.nextLine();
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(str);
	}

}
