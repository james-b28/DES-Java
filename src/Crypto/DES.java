package Crypto;

import java.io.IOException;
import java.util.Scanner;

/**
 * DES Cipher
 * @author Mussie Habtemichael
 *
 */
public class DES {

	public static void main(String args[]) throws IOException {
		long start_time; // DES cipher running start Time
		long end_time;
		start_time = System.nanoTime();
		Buffer fileBuffer = null;
		Encryptor anEncrypter = null;
		Decryptor aDecrypter = null;
		
		try {
			System.out.println();
			System.out.println("DES ENCRYPTOR/DECRYPTOR PROGRAM 1.0");
			System.out.println();
			System.out.println();
			Scanner in = new Scanner(System.in);
			System.out.println("Please Enter the Key in HexaDecimal: ");
			String key = in.nextLine();
			System.out.println();
			System.out.println();
			System.out.println("Please Enter e for encryption and d for decryption: ");
			char choice = in.next().charAt(0);
			in.close();
			
			double one_block_time; // 1 block Enc. or Dec. time
			double oneK_block_time; // 1000 blocks Enc. or Dec. time
			double tenK_block_time; // 10000 blocks Enc. or Dec. time
			
			if ( choice == 'e' ) {
				start_time = System.nanoTime();
				fileBuffer = new Buffer("tenkP.txt", "oneC.txt", 1, 8);
				anEncrypter = new Encryptor(fileBuffer, Util.getBinaryFromHex(key));
				
				String cipherText = "";
				String [] cipherBlocks = anEncrypter.getCipherTextBlocks();
				
				for (String item : cipherBlocks) {
					cipherText += item;
				}
				fileBuffer.writeString(Util.getHexFromBinary(cipherText));
				end_time = System.nanoTime();
				one_block_time = (end_time - start_time) / 1e6;
				
				System.out.println();
				System.out.println("1 Block Encryption Time: " + one_block_time + " ms");
				
				start_time = System.nanoTime();
				fileBuffer = new Buffer("tenkP.txt", "oneC.txt", 1000, 8);
				anEncrypter = new Encryptor(fileBuffer, Util.getBinaryFromHex(key));
				cipherText = "";
				cipherBlocks = anEncrypter.getCipherTextBlocks();
				
				for (String item : cipherBlocks) {
					cipherText += item;
				}
				
				fileBuffer.writeString(Util.getHexFromBinary(cipherText));
				end_time = System.nanoTime();
				oneK_block_time = (end_time - start_time) / 1e6;
				System.out.println("1,000 Blocks Encryption Time: " + oneK_block_time + " ms");
				
				
				start_time = System.nanoTime();
				
				// 10,000 is the number of blocks while 8 is the length of each block (8 characters or bytes)
				fileBuffer = new Buffer("tenkP.txt", "oneC.txt", 10000, 8);
				anEncrypter = new Encryptor(fileBuffer, Util.getBinaryFromHex(key));
				
				cipherText = "";
				cipherBlocks = anEncrypter.getCipherTextBlocks();
				
				for (String item : cipherBlocks) {
					cipherText += item;
				}
				fileBuffer.writeString(Util.getHexFromBinary(cipherText));
				end_time = System.nanoTime();
				tenK_block_time = (end_time - start_time) / 1e6;
				System.out.println("10,000 Blocks Encryption Time: " + tenK_block_time + " ms");
			}
			else {
				start_time = System.nanoTime();
				
				// 10,000 is the number of blocks while 16 is the length of each block (hexadecimal)
				fileBuffer = new Buffer("tenkC.txt", "tenDC.txt", 10000, 16);
				aDecrypter = new Decryptor(fileBuffer, key);
				
				String plainText = "";
				String [] plainBlocks = aDecrypter.getPlainTextBlocks();
				
				for (String item : plainBlocks) {
					plainText += item;
				}
				fileBuffer.writeString(Util.getTextFromBinary(plainText));
				end_time = System.nanoTime();
				tenK_block_time = (end_time - start_time) / 1e6;
				System.out.println("1 Block Decryption Time: " + tenK_block_time);
			}

		}
		finally {
			if (fileBuffer != null) {
				fileBuffer.closeBuffer();
			}
		}
	}
	  
}
	  