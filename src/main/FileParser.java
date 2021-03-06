package main;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Reads a file and parses the data into two
 * lists containing hexadecimal and decimal
 * represenations of the MIPS-instructions.
 *
 * @author oi11hkm
 *
 */
public class FileParser {

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
	public void readFile(InstructionInfo insInfo) {
		String line = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				insInfo.addCode(line);
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
	public void divideList(InstructionInfo insInfo) {
		int i = 0;
		String hex = null;
		long dec = 0;

		while(i < insInfo.getCodeSize()) {
			String code = insInfo.getCode(i);
			/* If the line contains "x", it is a hexadecimal
			 * representation of the instruction */
			if(code.contains("x") && code != null) {
				insInfo.addHex(i, code);
				hex = code.substring(2);
				dec = Long.parseLong(hex, 16);
				insInfo.addDec(i, dec);
			} else {
				insInfo.addDec(i, (long) Integer.parseInt(code));
				hex = Integer.toHexString(Integer.parseInt(code));
				insInfo.addHex(i, hex);
			}
			i++;
		}
	}
}
