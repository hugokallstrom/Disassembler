package main;

import java.util.ArrayList;
/**
 * Parse the data contained in decList in order
 * to get mnemonic representations of the instructions
 * and which format they are in.
 *
 * @author oi11hkm
 *
 */
public class Parser {

	ArrayList <Long> decList;
	ArrayList <String> mnemonicList = new ArrayList<String>();
	ArrayList <Character> formatList = new ArrayList<Character>();
	/**
	 * Constructor.
	 * @param decList - decimal list
	 */
	public Parser(ArrayList<Long> decList) {
		this.decList = decList;
	}
	/**
	 * Parse the instructions by
	 * extracting the op from the
	 * instructions and calling
	 * the class MnemonicFormat.
	 */
	public void parseOP() {
		int i = 0;

		while(i < decList.size()) {
			long instruction = decList.get(i);

			/* Extract the op from the instruction */
			int op = (int) instruction/67108864;

			/* Insert format in formatList */
			char format = MnomicFormat.getFormat(op);
			formatList.add(format);

			/* Insert mnemonic representaion in mnemonicList */
			String mnemonic = MnomicFormat.getMnomicFormat(format, instruction);
			mnemonicList.add(mnemonic);
			i++;
		}
	}
	/**
	 * Returns the mnemonicList
	 * @return - mnemonicList
	 */
	public ArrayList<String> getMnemonicList() {
		return mnemonicList;
	}
	/**
	 * Returns the formatList
	 * @return - formatList
	 */
	public ArrayList<Character> getFormatList() {
		return formatList;
	}


}
