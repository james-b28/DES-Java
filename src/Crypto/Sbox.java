package Crypto;

/**
 * The SBox Mapping Class
 * @author Brian Pendleton, Kyle Whitlatch
 * @version 9/29/2017
 *
 */
public class Sbox {
	
	private String input;
	private String lastOutput;
	private String[] parts = new String[8];
	
	/**
	 * Construct the SBox
	 * @param input the SBox input
	 */
	Sbox (String input) {
		this.input = input;
		this.lastOutput = "";
		for (int i = 0; i < 8; i++) {
			parts[i] = this.input.substring(i * 6, (i * 6) + 6);
		}
	}

	
	/**
	 * Fill the SBox stream
	 * @param input the SBox input
	 * @param sbox the SBox number
	 */
	private void fillSBoxStream(String input, int sbox) {
		String output;
		int[][] sTable = new int[4][16];
		
		// Assign the proper SBox Table
		sTable = sbox == 1 ? Util.s1 : sTable;
		sTable = sbox == 2 ? Util.s2 : sTable;
		sTable = sbox == 3 ? Util.s3 : sTable;
		sTable = sbox == 4 ? Util.s4 : sTable;
		sTable = sbox == 5 ? Util.s5 : sTable;
		sTable = sbox == 6 ? Util.s6 : sTable;
		sTable = sbox == 7 ? Util.s7 : sTable;
		sTable = sbox == 8 ? Util.s8 : sTable;
		
		//takes parts of the input string needed for number selection
		String row = input.substring(0, 1) + input.substring(5, 6);
		String col = input.substring(1,5);
		
		//integer representations of the binary strings "row" and "col"
		int irow = Integer.parseInt(row, 2);
		int icol = Integer.parseInt(col, 2);
		//integer value located in the row + col combo
		int ioutput = sTable[irow][icol];
		
		//converts integer value back to binary string with padded/leading 0's
		output = String.format("%4s", Integer.toBinaryString(ioutput)).replace(' ', '0');
		lastOutput += output;
	}
	
	/**
	 * SBox Substitution function
	 */
	private void substitute() {
		for (int i = 0; i < 8; i++) {
			fillSBoxStream(parts[i], i + 1);
		}
	}
	
	/**
	 * Return the SBox output
	 * @return the SBox output
	 */
	public String getSBoxOutput() {
		this.substitute();
		return this.lastOutput;
	}
}
