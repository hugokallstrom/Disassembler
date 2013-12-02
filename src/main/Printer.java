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

		System.out.printf("%-2s%12s%9s%5s%25s%35s\n" , "Nr", "From file", "Format", "Dec", "Hex", "Mnemonic");
		while(i < insInfo.getSize()) {
			System.out.format("#%-4d", i);
			System.out.format("%-12s", insInfo.getCode(i));
			System.out.printf("%-8c", insInfo.getFormat(i));
			System.out.printf("%-25s", insInfo.getDecompDec(i));
			System.out.printf("%-30s", insInfo.getDecompHex(i));
			System.out.printf("%s", insInfo.getMnemonic(i));
			System.out.print("\n");
			i++;
		}
	}
}
