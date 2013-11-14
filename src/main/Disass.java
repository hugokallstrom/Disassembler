package main;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
/**
 * Main class which calls other classes
 * in order to parse a file with MIPS-instructions
 * both in hex and decimal format.
 *
 * The instructions are parsed and printed on
 * stdout.
 *
 * @author oi11hkm
 *
 */
public class Disass {

	ArrayList <String> hexList;
	ArrayList <Long> decList;
	ArrayList <String> mnemonicList;
	ArrayList <String> formatList;

	/**
	 * Constructor which calls different classes
	 * to able to parse the file which is given
	 * as a parameter.
	 *
	 * @param file - name of the file to be parsed
	 * @throws FileNotFoundException
	 */
	public Disass(String file) throws FileNotFoundException {

		/* Read the file with hex and dec instructions */
		FileParser reader = new FileParser(file);
		reader.readFile();
		reader.divideList();
		decList = reader.getDecList();

		/* Parse the instructions */
		Parser parser = new Parser(decList);
		parser.parseOP();
		formatList = parser.getFormatList();
		mnemonicList = parser.getMnemonicList();

		/* Print data */
		Printer print = new Printer(decList, hexList, formatList, mnemonicList);
		print.printData();
	}
	/**
	 * Main function, calling the constructor of the
	 * Disass class with the filename.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Disass dis = new Disass(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

