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

	/**
	 * Constructor.
	 */
	public Parser() {

	}
	/**
	 * Parse the instructions by
	 * extracting the op from the
	 * instructions and calling
	 * the class MnemonicFormat.
	 */
	public void parseOP(InstructionInfo insInfo) {
		int i = 0;

		while(i < insInfo.getSize()) {
			long instruction = insInfo.getDec(i);

			/* Extract the op from the instruction */
			int op = (int) instruction/67108864;

			/* Insert format in formatList */
			char format = MnomicFormat.getFormat(op);
			insInfo.addFormat(i, format);

			/* Insert mnemonic representaion in mnemonicList */
			String mnemonic = MnomicFormat.getMnomicFormat(format, instruction);
			insInfo.addMnemonic(i, mnemonic);
			i++;
		}
	}
}
