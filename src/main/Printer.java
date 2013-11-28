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
			System.out.print("#" + i);
			System.out.print("  frmt: " + insInfo.getFormat(i));
			System.out.print("  dec: " + insInfo.getDec(i));
			System.out.print("  hex: " + insInfo.getHex(i));
			System.out.print("  mnmc: " + insInfo.getMnemonic(i));
			System.out.print("\n\n");
			i++;
		}
	}
}
