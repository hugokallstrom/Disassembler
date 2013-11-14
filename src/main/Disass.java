package main;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Disass {

	/**
	 * @param args
	 */

	ArrayList <String> hexList;
	ArrayList <Long> decList;

	public Disass(String file) throws FileNotFoundException {
		/* Read the file with hex and dec instructions */
		FileParser reader = new FileParser(file);
		reader.readFile();
		reader.divideList();
		decList = reader.getDecList();
		/* Parse the instructions */
		Parser parser = new Parser(decList);
		parser.parseOP();
	}

	public static void main(String[] args) {
		try {
			Disass dis = new Disass(args[0]);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}

