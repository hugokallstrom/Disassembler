package main;

import mappings.OpCode;
import mappings.OpMappings;

/**
 * A class that has a method to find out what format a instruction has
 * depending on the operation and a method that creates a String of
 * the mnemonic form for a instruction.
 * @author Markus Sk�ld (oi11msd)
 *
 */
public class MnomicFormat {

	private OpMappings mappings;

	/**
	 * The constructor, it creates a object of the class OpMappings.
	 */
	public MnomicFormat() {
		mappings = new OpMappings();
	}

	/**
	 * A method that returns the format 'R', 'I' or 'J'.
	 * @param op - A long that represent different MIP instructions.
	 * @return - A char that represent what format the instruction has.
	 */
	public char getFormat(long op) {

		char format;

		if((op == 0) || (op == 28)) {
			format = 'R';
		}
		else if(op == 1) {
			format = 'I';
		} else {
			try {
			OpCode temp = mappings.allOP[(int)op];
			format = temp.getOpCodeType();
			} catch(Exception e) {
				return 'E';
			}
		}
		return format;
	}

	/**
	 * A method that creates a String in mnemonic format for the instruction.
	 * @param format - The format of the instruction.
	 * @param number - The instruction in long.
	 * @param insInfo - A class that is used for the printing.
	 * @return - A String of the instruction in mnemonic format.
	 */
	public String getMnomicFormat(char format, long number, InstructionInfo insInfo) {
		String mnemonic = "";

		String temp = Long.toBinaryString(number);

		StringBuilder leadingZeroes = new StringBuilder();
		for(int index = 0; index < 32- temp.length(); index++) {
			leadingZeroes = leadingZeroes.append("0");

		}
		temp = leadingZeroes + temp;

		// Creates a String in mnemonic format for instructions in format R.
		// The String is different depending on the value of funct and op.
		if(format == 'R') {
			int op = Integer.parseInt(temp.substring(0, 6), 2);
			int rs = Integer.parseInt(temp.substring(6, 11), 2);
			int rt = Integer.parseInt(temp.substring(11, 16), 2);
			int rd = Integer.parseInt(temp.substring(16, 21), 2);
			int shamt = Integer.parseInt(temp.substring(21, 26), 2);
			int funct = Integer.parseInt(temp.substring(26, 32), 2);

			String regNick1 = mappings.registerNicks[rs];
			String regNick2 = mappings.registerNicks[rt];
			String regNick3 = mappings.registerNicks[rd];

			String functName = "";

			String decompDec = "[" + op + " " + rd + " " + rs + " " + rt + " " + shamt + " " + funct + "]";
			insInfo.addDecompDec(decompDec);

			String decompHex = "[0x" + Integer.toHexString(op) + " " +
							   "0x" + Integer.toHexString(rd) + " " +
							   "0x" + Integer.toHexString(rs) + " " +
							   "0x" + Integer.toHexString(rt) + " " +
							   "0x" + Integer.toHexString(shamt) + " " +
							   "0x" + Integer.toHexString(funct) + "]";
			insInfo.addDecompHex(decompHex);

			if(number == 0) {
				mnemonic = "nop";
				return mnemonic;
			}
			if(op == 0) {
				if((funct >= 32 && funct <= 39)  || (funct >= 42 && funct <= 43)
						|| (funct >= 10 && funct <= 11) ) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1
							+ " " + regNick2;
					//[funct rd rs rt]
				} else if((funct >= 24 && funct <= 27) || (funct >= 48 && funct <= 54)) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick2;
					//[funct rs rt]
				} else if((funct == 17) || (funct == 19) || (funct == 8)) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1;
					//[funct rs]
				} else if((funct == 18) || (funct == 16)) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3;
					//[funct rd]
				} else if (funct == 13) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + rs + rt + rd + shamt ;
					//[funct code]
				} else if(funct == 12) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName;
					//[functname]
				} else if(funct == 9) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick3;
					//[funct rs rd]
				} else if ((funct >= 6 && funct <= 7) || (funct == 4)) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick2 + " "
							+ regNick1;
					//[funct rd rt rs]
				} else if ((funct >= 2 && funct <= 3) || (funct == 0)) {
					functName = mappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick2 + " " + shamt;
					//[funct rd rt shamt]
				} else if(funct == 1) {
					int bit16 = Integer.parseInt(temp.substring(16, 17));
					functName = mappings.op1func1[bit16];

					int cc = Integer.parseInt(temp.substring(11, 14));
					mnemonic = functName + " " + regNick3 + " " + regNick1 + " " + cc;
					//[funct rd rs cc]
				} else {
					mnemonic = "OP: " + op + " " +  "funct: " + funct + " is unknown";
				}
			} else if(op == 28) {
				if((funct >= 0 && funct <= 1) || (funct >= 4 && funct <= 5)) {
					functName = mappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick2;
					//[funct rs rt]
				} else if(funct == 2) {
					functName = mappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1 + " "
							+ regNick2;
					//[funct rd rs rt]
				} else if(funct >= 33 && funct <= 34) {
					functName = mappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1;
					//[funct rd rs]
				} else {
					mnemonic = "OP: " + op + " " + "funct: " + funct + " is unknown";
				}
			} else {
				mnemonic = "Instruction not known";
			}
		// Creates a String in mnemonic format for instructions in the format I.
		// The String is different depending on the value of rt and op.
		} else if(format == 'I') {

			int op = Integer.parseInt(temp.substring(0, 6), 2);
			int rs = Integer.parseInt(temp.substring(6, 11), 2);
			int rt = Integer.parseInt(temp.substring(11, 16), 2);
			short imm = (short)Integer.parseInt(temp.substring(16, 32), 2);

			String regNick1 = mappings.registerNicks[rs];
			String regNick2 = mappings.registerNicks[rt];

			String functName = "";

			String decompDec = "[" + op + " " + rs + " " + rt + " " + imm + "]";
			insInfo.addDecompDec(decompDec);

			String decompHex = "[0x" +  Integer.toHexString(op) + " " +
								"0x" + Integer.toHexString(rs) + " " +
								"0x" + Integer.toHexString(rt) + " " +
								"0x" + Integer.toHexString(imm) + "]";
			insInfo.addDecompHex(decompHex);

			if(op == 1) {
				if((rt >= 0 && rt <= 3) || (rt >= 16 && rt <= 19)
						|| (rt >= 8 && rt <= 12) || (rt == 14)) {
					functName = mappings.OP1Functions[rt];
					mnemonic = functName + " " + regNick1 + " " +  4*imm;
					//[funct rs label/imm]
				} else {
					mnemonic = "OP: " + op + " rt: " + rt + " is unknown";
				}
			} else {
				OpCode temp2 = mappings.allOP[op];
				functName = temp2.getOpCodeName();

				if((op >= 4 && op <= 5) || (op >= 20 && op <= 21)) {
					mnemonic = functName + " " + regNick1 + " " +  regNick2 + " " + 4*imm;
					//[funct rs rt offset]
				} else if((op >= 6 && op <= 7) || (op >= 22 && op <= 23)) {
					mnemonic = functName + " " + regNick1 + " " + 4*imm;
					//[funct rs offset]x
				} else if(op >= 8 && op <= 14) {
					mnemonic = functName + " " + regNick2 + " " +  regNick1 + " " + imm;
					//[funct rt rs imm]
				} else if((op == 15) ) {
					mnemonic = functName + " " + regNick2 + " " + imm;
					//[funct rt imm]
				} else if((op >= 32 && op <= 38) || (op >= 40 && op <= 43)
						|| (op == 46) || (op == 48) || (op == 50) || (op == 54)
						|| (op == 56) || (op ==58) || (op ==62)) {
					mnemonic = functName + " " + regNick2 + " " + imm + "(" + regNick1 + ")";
					//[funct rt offset(base/rs)]
				} else if(op == 47) {
					mnemonic = functName + " " + op + " " + imm + "(" + regNick1 + ")";
					//[funct op offset(base)]
				} else if((op == 47) || (op == 51)) {
					mnemonic = functName + " " + rt + " " + imm + "(" + regNick1 + ")";
					//[funct hint offset(base)]
				}
			}
		// Creates a String in mnemonic format for instructions in format J.
		} else if(format == 'J') {

			int op = Integer.parseInt(temp.substring(0, 6), 2);
			int label = Integer.parseInt(temp.substring(6, 32), 2);
			String hexLabel = Integer.toHexString(4*label);

			OpCode temp2 = mappings.allOP[op];
			String functName = temp2.getOpCodeName();

			String decompDec = "[" + op + " " + label + "]";
			insInfo.addDecompDec(decompDec);

			String decompHex = "[0x" +  Integer.toHexString(op) + " " +
								"0x" + Integer.toHexString(label) + "]";
			insInfo.addDecompHex(decompHex);


			mnemonic = functName + " " + "0x" + hexLabel;
		}
		return mnemonic;
	}

}
