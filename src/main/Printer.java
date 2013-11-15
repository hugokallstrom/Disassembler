package main;

import java.util.ArrayList;
/**
 * Prints the parsed data contained
 * in different ArrayLists.
 *
 * @author oi11hkm
 *
 */
public class Printer {

	ArrayList<String> hexList;
	ArrayList<Long> decList;
	ArrayList<String> mnemonicList;
	ArrayList<Character> formatList;

	/**
	 * Constructor.
	 * @param decList - decimal list
	 * @param hexList - hexadecimal list
	 * @param formatList - format list
	 * @param mnemonicList - mnemonic list
	 */
	public Printer(ArrayList<Long> decList, ArrayList<String> hexList, ArrayList<Character> formatList, ArrayList<String> mnemonicList) {
		this.decList = decList;
		this.hexList = hexList;
		this.formatList = formatList;
		this.mnemonicList = mnemonicList;
	}

	/**
	 * Prints the data.
	 */
	public void printData() {
		int i = 0;

		while(i < mnemonicList.size()) {
			System.out.println("#" + i + " ");
			System.out.println("  frmt: " + formatList.get(i));
			System.out.println("  dec: " + decList.get(i));
			System.out.println("  hex: " + hexList.get(i));
			System.out.println("  mnmc: " + mnemonicList.get(i));
			System.out.println("\n");
		}
	}
}
