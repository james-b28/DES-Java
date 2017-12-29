package Crypto;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Buffer class to read and write blocks into a file
 * @author Mussie Habtemichael
 * @version 09/25/2017
 */
public class Buffer { 
	
	private String inputFilePath;
	private String outputFilePath;
	private BufferedReader in;
	private int blockSize;
	private int blockLength;
	char[] buffer;
	
	
	/**
	 * Construct the File Buffer Object
	 * @param inputPath the input file path
	 * @param outputPath the output file path
	 */
	public Buffer(String inputPath, String outputPath, int blockSize, int blockLength) throws IOException {
		this.inputFilePath = inputPath;
		this.outputFilePath = outputPath;
		this.blockSize = blockSize;
		this.blockLength = blockLength;
		this.buffer = new char[blockSize * blockLength];
		this.in = null;
		try {
			in = new BufferedReader(new FileReader(inputFilePath), blockSize * blockLength);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Get Blocks from file
	 * @return the DES blocks
	 */
	public String[] getBlocks() throws IOException {
		
		String [] blocks = new String[blockSize];
		
		try {
			// reads "bufferSize" amount of bytes into the buffer
			int nextByteStatus = in.read(buffer);
			int completeBlockStatus = nextByteStatus % this.blockLength;
			int leftOver = nextByteStatus - completeBlockStatus;
			String block = "";
			
			if ( nextByteStatus != -1 ) {
				int loopCounter = 0;
				int blockCounter = 0;
				while (loopCounter < leftOver) {
					block += buffer[loopCounter];
					if ( (loopCounter + 1) % this.blockLength == 0) {
						blocks[blockCounter] = block;
						block = "";
						blockCounter++;
					}
					loopCounter++;
				}
				char[] empty = new char[1];
				// Complete the rest of the block
				for (int i = leftOver; i < buffer.length; i++) {
					char item = buffer[i];
					if (item != empty[0]) {
						block += item;
					}
				}
				// Add Padding if block is not complete from file
				while (block.length() < this.blockLength && block != "") {
					block += "0";
					if (block.length() == this.blockLength) {
						blocks[blockCounter] = block;
					}
				}
			}
			
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return blocks;
	}
	
	/**
	 * Closes the buffer
	 * @throws IOException
	 */
	public void closeBuffer() throws IOException {
		
		try {
			if (in != null) {
				in.close();
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Write a string to a file
	 * @param aString the string to write
	 * @throws IOException
	 */
	public void writeString(String aString) throws IOException {
		
		try {
			BufferedWriter bw = null;
			FileWriter fw = null;
			fw = new FileWriter(outputFilePath);
			bw = new BufferedWriter(fw);
			bw.write(aString);
			bw.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
