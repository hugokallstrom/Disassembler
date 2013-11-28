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

		System.out.println("Nr	Format		Dec	 	Hex		Mnemonic");
		while(i < insInfo.getSize()) {
			System.out.print("#" + i);
			System.out.print("       " + insInfo.getFormat(i));
			System.out.print("  " + insInfo.getDec(i));
			System.out.print("  " + insInfo.getHex(i));
			System.out.print("  " + insInfo.getMnemonic(i));
			System.out.print("\n\n");
			i++;
		}
	}
}
