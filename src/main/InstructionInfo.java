package main;

import java.util.ArrayList;
/**
 * Class which stores information about the instructions
 * specified in the input file. The data stored are:
 *
 * 1. Hexadecimal representation of the instruction
 * 2. Decimal representation of the instruction
 * 3. Mnemonic representation of the instruction
 * 4. Format of the instruction
 *
 * @author oi11hkm
 *
 */
public class InstructionInfo {

	ArrayList <String> codeList;
	ArrayList <String> hexList;
	ArrayList <Long> decList;
	ArrayList <String> mnemonicList;
	ArrayList <Character> formatList;
	ArrayList <String> decompHex;
	ArrayList <String> decompDec;
	/**
	 * Constructor, creating ArrayLists
	 * for data
	 */
	public InstructionInfo() {
		codeList = new ArrayList<String>();
		hexList = new ArrayList<String>();
		decList = new ArrayList<Long>();
		mnemonicList = new ArrayList<String>();
		formatList = new ArrayList<Character>();
		decompHex = new ArrayList<String>();
		decompDec = new ArrayList<String>();
	}
	public void addCode(String code) {
		codeList.add(code);
	}
	/**
	 * Adds a hex to the ArrayList
	 * @param index
	 * @param hex
	 */
	public void addHex(int index, String hex) {
		hexList.add(hex);
	}
	/**
	 * Adds a decimal to the ArrayList
	 * @param index
	 * @param decimal
	 */
	public void addDec(int index, long decimal) {
		decList.add(decimal);
	}
	/**
	 * Adds a mnemonic representation to the ArrayList
	 * @param index
	 * @param mnemonic
	 */
	public void addMnemonic(int index, String mnemonic) {
		mnemonicList.add(mnemonic);
	}
	/**
	 * Adds a format to the ArrayList
	 * @param index
	 * @param format
	 */
	public void addFormat(int index, char format) {
		formatList.add(format);
	}

	public void addDecompHex(String hex) {
		decompHex.add(hex);
	}
	public void addDecompDec(String dec) {
		decompDec.add(dec);
	}
	public String getCode(int index) {
		return codeList.get(index);
	}
	/**
	 * Gets a hex on index i from the
	 * ArrayList
	 * @param index
	 * @return hex
	 */
	public String getHex(int index) {
		return hexList.get(index);
	}
	/**
	 * Gets a decimal on index i from the
	 * ArrayList
	 * @param index
	 * @return decimal
	 */
	public long getDec(int index) {
		return decList.get(index);
	}
	/**
	 * Gets a mnemonic representation on
	 * index i from the ArrayList
	 * @param index
	 * @return mnemonic representation
	 */
	public String getMnemonic(int index) {
		return mnemonicList.get(index);
	}
	/**
	 * Gets a format on index i from the
	 * ArrayList
	 * @param index
	 * @return format
	 */
	public char getFormat(int index) {
		return formatList.get(index);
	}

	public String getDecompDec(int index) {
		return decompDec.get(index);
	}

	public String getDecompHex(int index) {
		return decompHex.get(index);
	}
	public int getCodeSize() {
		return codeList.size();
	}
	/**
	 * Gets the size of the decimal ArrayList
	 * (which is equal to all other lists)
	 * @return size
	 */
	public int getSize() {
		return decList.size();
	}
	public void print() {
		System.out.println(hexList);
	}
}
