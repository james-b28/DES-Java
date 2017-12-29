package Crypto;
import java.io.IOException;

/**
 * The Decryption class
 * @author Mussie Habtemichael
 * @version 09/25/2017
 *
 */
public class Decryptor {
	
	private Buffer aBuffer;
	private KeyGenerator aKeyGenerator;
	
	/**
	 * Construct the Decrypter
	 * @param buf the buffer
	 * @param key the original key
	 */
	public Decryptor(Buffer buf, String key) {
		this.aBuffer = buf;
		aKeyGenerator = new KeyGenerator(key);
	}
	
	/**
	 * Get the plain text blocks
	 * @return the DES plain text blocks
	 * @throws IOException
	 */
	public String[] getPlainTextBlocks() throws IOException {
		String permutedString = "";
		String leftBlock = ""; 
		String rightBlock = "";
		String [] nKeyArray = aKeyGenerator.getKeys();
		String [] cipherBlocks = this.aBuffer.getBlocks();
		String [] plainBlocks = new String[cipherBlocks.length];
		String tempLeftBlock = "";
		String [] dividedStrings;
		
		for (int i = 0; i < cipherBlocks.length; i++) {
			permutedString  = Util.getInitialPermuation(Util.getBinaryFromHex(cipherBlocks[i]));
			dividedStrings = Util.getDividedStrings(permutedString, 32);
			leftBlock = dividedStrings[0];
			rightBlock = dividedStrings[1];

			for (int j = 15; j >= 0; j--) {
				tempLeftBlock = leftBlock;
				leftBlock = rightBlock;
				rightBlock = Util.XORBinaryString(tempLeftBlock, Util.conversionFunction(rightBlock, nKeyArray[j]));
			}
			plainBlocks[i] = Util.getInversePermutation(rightBlock + leftBlock);
		}
		return plainBlocks;	
	}
}