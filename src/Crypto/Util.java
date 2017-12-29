package Crypto;

/**
 * The Util class contains helpful auxiliary functions
 * @author Mussie Habtemichael
 * @version 09/29/2017
 *
 */
public class Util {
	
	public static final int[] IP = {
			
			  58,	50,	42,	34,	26,	18,	10,	2,
			  60,	52,	44,	36,	28,	20,	12,	4,
			  62,	54,	46,	38,	30,	22,	14,	6,
			  64,	56,	48,	40,	32,	24,	16,	8,
			  57,	49,	41,	33,	25,	17,	9,	1,
			  59,	51,	43,	35,	27,	19,	11,	3,
			  61,	53,	45,	37,	29,	21,	13,	5,
			  63,	55,	47,	39,	31,	23,	15,	7
	};
	
	public static final int[] E_TABLE = {
	           32, 1, 2, 3, 4, 5,
	           4, 5, 6, 7, 8, 9,
	           8, 9, 10, 11, 12, 13,
	           12, 13, 14, 15, 16, 17,
	           16, 17, 18, 19, 20, 21,
	           20, 21, 22, 23, 24, 25,
	           24, 25, 26, 27, 28, 29,
	           28, 29, 30, 31, 32, 1
	 };
	
	public static final int[] INVERSE_IP = {
            40, 8, 48, 16, 56, 24, 64, 32,
            39, 7, 47, 15, 55, 23, 63, 31,
            38, 6, 46, 14, 54, 22, 62, 30,
            37, 5, 45, 13, 53, 21, 61, 29,
            36, 4, 44, 12, 52, 20, 60, 28,
            35, 3, 43, 11, 51, 19, 59, 27,
            34, 2, 42, 10, 50, 18, 58, 26,
            33, 1, 41,  9, 49, 17, 57, 25
	};

	public static final int[] P_TABLE = {
	           16, 7, 20, 21, 29, 12, 28, 17,
	           1, 15, 23, 26, 5, 18, 31, 10,
	           2, 8, 24, 14, 32, 27, 3, 9,
	           19, 13, 30, 6, 22, 11, 4, 25
	 };
	 
  public static final int[] PERMUTED_CHOICE1 = {
                    57, 49, 41, 33, 25, 17, 9,
                    1, 58, 50, 42, 34, 26, 18,
                    10, 2, 59, 51, 43, 35, 27,
                    19, 11, 3, 60, 52, 44, 36,
                    63, 55, 47, 39, 31, 23, 15,
                    7, 62, 54, 46, 38, 30, 22,
                    14, 6, 61, 53, 45, 37, 29,
                    21, 13, 5, 28, 20, 12, 4
  
  };

public static final int[] PERMUTED_CHOICE2 = 
                    {14, 17, 11, 24, 1, 5, 3, 28,
                    15, 6, 21, 10, 23, 19, 12, 4,
                    26, 8, 16, 7, 27, 20, 13, 2,
                    41, 52, 31, 37, 47, 55, 30, 40,
                    51, 45, 33, 48, 44, 49, 39, 56,
                    34, 53, 46, 42, 50, 36, 29, 32
    };

public static final int[][] s1 = 
	{{14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7},
	{0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8},
	{4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0},
	{15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13}};

public static final int[][] s2 = 
	{{15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10},
	{3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5},
	{0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15},
	{13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9}};

public static final int[][] s3 = 
	{{10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8},
	{13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1},
	{13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7},
	{1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12}};

public static final int[][] s4 = 
	{{7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15},
	{13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9},
	{10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4},
	{3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14}};

public static final int[][] s5 = 
	{{2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9},
	{14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6},
	{4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14},
	  {11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3}};

public static final int[][] s6 = 
	{{12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11},
	  {10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8},
	  {9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6},
	  {4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 7, 13}};

public static final int[][] s7 = {{4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1},
	  {13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6},
	  {1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2},
	  {6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12}};

public static final int[][] s8 = {{13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7},
	  {1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2},
	  {7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8},
	  {2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11}};

public static final int[] LEFT_SHIFT_SCHEDULE = {1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1};

	
	/**
	 * The Initial permutation function
	 * @param inputString the input block
	 * @return the initial permutation of a block
	 */
	public static String getInitialPermuation(String inputString) {
		String permutedString = "";
		String binaryString = inputString;
		Object[] tempArray = new Object[64];
			
		for (int i = 0; i < binaryString.length(); i++) {
			tempArray[i] = binaryString.charAt( IP[i] - 1);
		}
		permutedString = arrayToString(tempArray);	
		return permutedString;
	}
	
	/**
	 * The E-Bit Expansion function
	 * @param aString the input 32 bit string
	 * @return a 48 bit string
	 */
	public static String getEBitPermutation(String aString) {
		String binaryString = aString;
		Object[] tempArray = new Object[48];
		
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = binaryString.charAt( E_TABLE[i] - 1);
		}
		return arrayToString(tempArray);
	}
	
	/**
	 * The P Permutation function
	 * @param aString the input 32 bit string
	 * @return a 32 bit string
	 */
	public static String getPPermutation(String aString) {
		Object[] tempArray = new Object[32];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = aString.charAt( P_TABLE[i] - 1);
		}
		return arrayToString(tempArray);
	}
	
	/**
	 * The Inverse Permutation function
	 * @param aString the input 64 bit string
	 * @return a 64 bit string
	 */
	public static String getInversePermutation(String aString) {
		Object[] tempArray = new Object[64];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = aString.charAt( INVERSE_IP[i] - 1);
		}
		return arrayToString(tempArray);
	}
	
	/**
	 * The String XOR function
	 * @param x XOR element
	 * @param y XOR element
	 * @return the XOR output
	 */
	public static String XORBinaryString(String x, String y) {
		String output = "";
		char bitChar;
		
		for (int i = 0; i < x.length(); i++) {
			bitChar = x.charAt(i) == y.charAt(i) ? '0' : '1';
			output += bitChar;
		}
		return output;
	}
	
	/**
	 * The DES conversion function of left and right blocks
	 * @param rightBlock the right block
	 * @param nthKey the nth permuted key
	 * @return the conversion function result
	 */
	public static String conversionFunction(String rightBlock, String nthKey) {
		String expandedString = getEBitPermutation(rightBlock);
		String XOR1 = XORBinaryString(nthKey, expandedString);
		Sbox anSbox = new Sbox(XOR1);
		String sBoxOutput = anSbox.getSBoxOutput();
		String pOutput = getPPermutation(sBoxOutput);
		return pOutput;
	}
	
	/**
	 * Return a Hex String from a binary string
	 * @param binary the binary string
	 * @return the hex string
	 */
	public static String getHexFromBinary(String binary) {
		String tempString = "";
		String hexString = "";
		
		for (int i = 0; i < binary.length(); i++) {
			tempString += binary.charAt(i);
			if ( (i + 1) % 4 == 0 ) {
				int temp = Integer.parseInt(tempString, 2);
				tempString = "";
				char tempChar = ' ';
				if (temp < 10) {
					hexString += temp;
				}
				else {
					tempChar = temp == 10 ? 'A' : tempChar;
					tempChar = temp == 11 ? 'B' : tempChar;
					tempChar = temp == 12 ? 'C' : tempChar;
					tempChar = temp == 13 ? 'D' : tempChar;
					tempChar = temp == 14 ? 'E' : tempChar;
					tempChar = temp == 15 ? 'F' : tempChar;
					hexString += tempChar;
				}
			}
		}
		return hexString;
	}
		
	/**
	 * Function to get the binary from a hex input
	 * @param hexCode the hex code to convert
	 * @return the binary string
	 */
	public static String getBinaryFromHex(String hexCode) {
		int decimal;
		String tempString = "";
		String binaryString = "";
		
		for (int i = 0; i < hexCode.length(); i++) {
			char temp = hexCode.charAt(i);
			decimal = Character.isLetter(temp) ? (int) temp : Character.getNumericValue(temp);
			tempString = Integer.toBinaryString(decimal);
			
			if (decimal == 0 || decimal == 1 ) {
				tempString = "000" + tempString;
			}
			else if ( decimal == 2 || decimal == 3 ) {
				tempString = "00" + tempString;
			}
			else if (decimal > 3 && decimal < 8) {
				tempString = "0" + tempString;
			}
			else {

				if (temp == 'A') {
					decimal = 10;
				}
				else if (temp == 'B') {
					decimal = 11;
				}
				else if (temp == 'C') {
					decimal = 12;
				}
				else if (temp == 'D') {
					decimal = 13;
				}
				else if (temp == 'E') {
					decimal = 14;
				}
				else if (temp == 'F') {
					decimal = 15;
				}
				
				tempString = Integer.toBinaryString(decimal);
			}
			
			binaryString = binaryString + tempString;
		}
		
		return binaryString;
	}
	
	/**
	 * Function to get the binary of a text
	 * @param aString the input
	 * @return the binary form
	 */
	public static String getBinaryfromText(String aString) {
		String binaryString = "";
		for (int i = 0; i < aString.length(); i++) {
			int temp = (int) aString.charAt(i);
			String bin = Integer.toBinaryString(temp);
			int binLen = bin.length();
			while (binLen < 8) {
				bin = "0" + bin;
				binLen++;
			}
			binaryString += bin;
		}
		return binaryString;
	}
	
	/**
	 * Function to convert arrays to strings
	 * @param anArray the input array
	 * @return the string version of the array
	 */
	public static String arrayToString(Object[] anArray) {
		String aString = "";	
		for (Object i : anArray) {
			aString += i;
		}
		return aString;
	}
	
	/**
	 * Function to divide a string into blocks
	 * @param aString the string to divide
	 * @param numberOfBits the bit length of each block
	 * @return the divided strings
	 */
	public static String[] getDividedStrings(String aString, int numberOfBits) {
		String temp[] = new String[2];
		temp[0] = aString.substring(0, numberOfBits);
		temp[1] = aString.substring(numberOfBits, numberOfBits * 2);
		return temp;
	}
	
	/**
	 * Function to get the text from binary
	 * @param aString the binary input
	 * @return the text form
	 */
	public static String getTextFromBinary(String aString) {
		String textString = "";
		String temp = "";
		int digit;
		int stringIndex = 0;
		char letter;
		while (stringIndex < aString.length()) {
			temp += aString.charAt(stringIndex);
			if ( temp.length() % 8 == 0 ) {
				digit = Integer.parseInt(temp, 2);
				letter = (char) digit;
				textString += letter;
				temp = "";
			}
			stringIndex++;
		}
		return textString;
	}
	
	public static void main(String[] args) {

	}
}
