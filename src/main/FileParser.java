package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * Reads a file and parses the data into two
 * lists containing hexadecimal and decimal
 * represenations of the MIPS-instructions.
 *
 * @author oi11hkm
 *
 */
public class FileParser {

	ArrayList <String> codeList = new ArrayList<String>();
	ArrayList <String> hexList = new ArrayList<String>();
	ArrayList <Long> decList = new ArrayList<Long>();
	String file;

	/**
	 * Constructor.
	 * @param file - name of the file
	 */
	public FileParser(String file) {
		this.file = file;
	}
	/**
	 * readFile - reads the file specified as the input argument "file"
	 * and puts every line in a list containing strings.
	 */
	public void readFile() {
		String line = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				codeList.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * divideList - divides the list, "codeList", and creates
	 * hexadecimal and decimal representations of all instructions.
	 */
	public void divideList() {
		int i = 0;
		String hex = null;
		long dec = 0;

		while(i < codeList.size()) {
			String code = codeList.get(i);
			/* If the line contains "x", it is a hexadecimal
			 * representation of the instruction */
			if(code.contains("x") && code != null) {
				hexList.add(code);
				hex = code.substring(2);
				dec = Long.parseLong(hex, 16);
				decList.add(dec);
			} else {
				decList.add((long) Integer.parseInt(code));
				hex = Integer.toHexString(Integer.parseInt(code));
				hexList.add(hex);
			}
			i++;
		}
	}
	/**
	 * Returns the hexList.
	 * @return - hexList
	 */
	public ArrayList<String> getHexList() {
		return hexList;
	}
	/**
	 * Returns the decList.
	 * @return - decList
	 */
	public ArrayList<Long> getDecList() {
		return decList;
	}
}
