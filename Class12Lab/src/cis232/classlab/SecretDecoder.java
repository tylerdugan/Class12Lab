package cis232.classlab;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SecretDecoder {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the secret key: \n>");
		Scanner kb = new Scanner(System.in);
		int key = kb.nextInt();
		
		FileInputStream fis = new FileInputStream("secret.msg");
		DataInputStream dis = new DataInputStream(fis);
				
		StringBuilder sb = new StringBuilder();
		String message = dis.readUTF();
		for(int i=0; i<message.length(); i++){
			System.out.print((char)(message.charAt(i) - key));
		}
		dis.close();
		
		File f = new File("secret.msg");
		f.delete();
		System.out.println("\nFile was deleted.");
	}

}
