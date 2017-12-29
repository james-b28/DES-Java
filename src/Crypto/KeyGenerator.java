package Crypto;

/** 
 * Key Generation class
 * @author Mussie Habtemichael
 * @version 9/29/2017
 *
 */
public class KeyGenerator {
  
  private String originalKey;	
  private String[] nKeyArray;
  
	/**
	 * Constructs the Key Generator
	 * @param originalKey the original key
	 */
	public KeyGenerator(String originalKey) {
		this.originalKey = originalKey;
		nKeyArray = new String[16];
	}
	
	/**
	 * The PC1 Reduction function
	 * @param aString the 64 bit key string
	 * @return a 56 bit string
	 */
	private String getPC1(String aString) {
		Object[] tempArray = new Object[56];
		
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = aString.charAt( Util.PERMUTED_CHOICE1[i] - 1);
		}
		return Util.arrayToString(tempArray);
	}
	
	/**
	 * The PC2 Reduction function
	 * @param aString the 56 bit key string
	 * @return a 48 bit string
	 */
	private String getPC2(String aString) {
		Object[] tempArray = new Object[48];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = aString.charAt( Util.PERMUTED_CHOICE2[i] - 1);
		}
		return Util.arrayToString(tempArray);
	}
	
	/**
	 * The Left Shift Function
	 * @param blocks the left and right blocks
	 * @param shiftSchedule the left shift schedule
	 * @return the left-shifted string
	 */
	private String leftShift(String[] blocks, int shiftSchedule) {
		String leftBlock = blocks[0];
		String rightBlock = blocks[1];
		
		while ( shiftSchedule != 0 ) {
			leftBlock = leftBlock.substring(1) + leftBlock.charAt(0);
			rightBlock = rightBlock.substring(1) + rightBlock.charAt(0);
			shiftSchedule--;
		}
		return leftBlock + rightBlock;
	}
	
	/**
	 * Returns the left-shifted strings
	 * @return the left-shifted strings
	 */
	private String[] getShiftedStrings() {
		String permutedKey = this.getPC1(originalKey);
		String[] blocks = Util.getDividedStrings(permutedKey, 28);
		String[] shiftedStrings = new String[16];
		String [] bStrings = new String[2];
		String nleftBlock;
		String nrightBlock;
		String nBlock;
		int shiftSchedule;
		
		for (int i = 0; i < 16; i++) {
			shiftSchedule = Util.LEFT_SHIFT_SCHEDULE[i];
			nBlock = leftShift(blocks, shiftSchedule);
			bStrings = Util.getDividedStrings(nBlock, 28);
			nleftBlock = bStrings[0];
			nrightBlock = bStrings[1];
			shiftedStrings[i] = nleftBlock + nrightBlock;
			blocks[0] = nleftBlock;
			blocks[1] = nrightBlock;
		}
		
		return shiftedStrings;
	}
	
	/**
	 * Gets all the processed keys
	 * @return the permuted keys
	 */
	public String[] getKeys() {
		String[] shiftedStrings = this.getShiftedStrings();
		for (int i = 0; i < shiftedStrings.length; i++) {
			nKeyArray[i] = getPC2(shiftedStrings[i]);
		}
		return nKeyArray;
	}
}
