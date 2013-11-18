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
	ArrayList <Character> formatList;
	/**
	 * Constructor which calls different classes
	 * to able to parse the file which is given
	 * as a parameter.
	 *
	 * @param file - name of the file to be parsed
	 * @throws FileNotFoundException
	 */
	public Disass(String file) throws FileNotFoundException {

		InstructionInfo insInfo = new InstructionInfo();

		/* Read the file with hex and dec instructions */
		FileParser reader = new FileParser(file);
		reader.readFile();
		reader.divideList(insInfo);

		/* Parse the instructions */
		Parser parser = new Parser();
		parser.parseOP(insInfo);

		/* Print data */
		Printer print = new Printer();
		print.printData(insInfo);
	}
	/**
	 * Main function, calling the constructor of the
	 * Disass class with the filename.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		if(args[0] != null) {
			try {
				Disass dis = new Disass(args[0]);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Please specify an input file");
		}

	}

}

