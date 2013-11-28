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
		MnomicFormat mf = new MnomicFormat();

		while(i < insInfo.getSize()) {
			String mnemonic = "";
			long instruction = insInfo.getDec(i);
			System.out.println(Long.toBinaryString(instruction));
			/* Extract the op from the instruction */
			System.out.println(Long.toHexString(instruction));
			long op = instruction/67108864;

			/* Insert format in formatList */
			char format = mf.getFormat(op);
			insInfo.addFormat(i, format);

			System.out.println("op:" + op);
			System.out.println("format: " + format);

			if(format != 'E') {
				/* Insert mnemonic representaion in mnemonicList */
				mnemonic = mf.getMnomicFormat(format, instruction);
			} else {
				mnemonic = "Instruction not known";
			}
			insInfo.addMnemonic(i, mnemonic);

			i++;
		}
	}
}
