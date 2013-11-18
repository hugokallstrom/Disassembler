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
	/**
	 * Constructor.
	 */
	public Printer() {

	}
	/**
	 * Prints the data.
	 */
	public void printData(InstructionInfo insInfo) {
		int i = 0;
		System.out.println(insInfo.getSize());
		while(i < insInfo.getSize()) {
			System.out.println("#" + i);
			System.out.println("  frmt: " + insInfo.getFormat(i));
			System.out.println("  dec: " + insInfo.getDec(i));
			System.out.println("  hex: " + insInfo.getHex(i));
			System.out.println("  mnmc: " + insInfo.getMnemonic(i));
			System.out.println("\n");
			i++;
		}
	}
}
