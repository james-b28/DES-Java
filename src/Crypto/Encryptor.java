package Crypto;
import java.io.IOException;

/**
 * The Encryption class
 * @author Mussie Habtemichael
 * @version 09/29/2017
 *
 */
public class Encryptor {
	
	private Buffer aBuffer;
	private KeyGenerator aKeyGenerator;
	
	/**
	 * Construct the Encrypter
	 * @param buf the buffer
	 */
	public Encryptor(Buffer buf, String key) {
		this.aBuffer = buf;
		aKeyGenerator = new KeyGenerator(key);
	}
	
	/**
	 * Get the Cipher Text blocks
	 * @return the DES cipher text blocks
	 * @throws IOException
	 */
	public String[] getCipherTextBlocks() throws IOException {

		String permutedString = "";
		String leftBlock = ""; 
		String rightBlock = "";
		String [] plainBlocks = this.aBuffer.getBlocks();
		String [] cipherBlocks = new String[plainBlocks.length];
		String [] nKeyArray = aKeyGenerator.getKeys();
		String tempLeftBlock = "";
		String [] dividedStrings = new String[2];
			
			for (int i = 0; i < plainBlocks.length; i++) {
				permutedString  = Util.getInitialPermuation(Util.getBinaryfromText(plainBlocks[i]));
				dividedStrings = Util.getDividedStrings(permutedString, 32);
				leftBlock = dividedStrings[0];
				rightBlock = dividedStrings[1];
				
				for (int j = 0; j < 16; j++) {
					tempLeftBlock = leftBlock;
					leftBlock = rightBlock;
					rightBlock = Util.XORBinaryString(tempLeftBlock, Util.conversionFunction(rightBlock, nKeyArray[j]));
				}
				cipherBlocks[i] = Util.getInversePermutation(rightBlock + leftBlock);
			}		
			return cipherBlocks;	
	}
}