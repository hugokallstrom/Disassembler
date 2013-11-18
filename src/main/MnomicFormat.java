package main;

import java.io.IOException;

import mappings.OpCode;
import mappings.OpMappings;

public class MnomicFormat {


	public static char getFormat(int op) {
		char format;
		if((op == 0) || (op == 28)) {
			format = 'R';
		} else {
			try {
			OpCode temp = OpMappings.allOP[op];
			format = temp.getOpCodeType();
			} catch(Exception e) {
				return (Character) null;
			}
		}

		return format;

	}

	public static String getMnomicFormat(char format, long number) {
		String mnemonic = "";

		if(number == 0) {
			mnemonic = "nop";
			return mnemonic;
		}

		if(format == 'R') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int rd = Integer.parseInt(temp.substring(16, 21));
			int shamt = Integer.parseInt(temp.substring(21, 26));
			int funct = Integer.parseInt(temp.substring(26, 32));

			String regNick1 = OpMappings.registerNicks[rs];
			String regNick2 = OpMappings.registerNicks[rt];
			String regNick3 = OpMappings.registerNicks[rd];
			String functName = "";

			if(op == 0) {
				if((funct >= 32 && funct <= 39)  || (funct >= 42 && funct <= 43)
						|| (funct >= 10 && funct <= 11) ) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1
							+ " " + regNick2;
					//[funct rd rs rt]
				} else if((funct >= 24 && funct <= 27) || (funct >= 48 && funct <= 54)) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick2;
					//[funct rs rt]
				} else if((funct == 17) || (funct == 19) || (funct == 8)) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1;
					//[funct rs]
				} else if((funct == 18) || (funct == 16)) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3;
					//[funct rd]
				} else if (funct == 13) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + rs + rt + rd + shamt ;
					//[funct code]
				} else if(funct == 12) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName;
					//[functname]
				} else if(funct == 9) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick3;
					//[funct rs rd]
				} else if ((funct >= 6 && funct <= 7) || (funct == 4)) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick2 + " "
					+ regNick1;
					//[funct rd rt rs]
				} else if ((funct >= 2 && funct <= 3) || (funct == 0)) {
					functName = OpMappings.RFunctions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick2 + " " + shamt;
					//[funct rd rt shamt]
				} else if(funct == 1) {
					int bit16 = Integer.parseInt(temp.substring(16, 17));
					functName = OpMappings.op1func1[bit16];

					int cc = Integer.parseInt(temp.substring(11, 14));
					mnemonic = functName + " " + regNick3 + " " + regNick1 + " " + cc;
					//[funct rd rs cc]
				} else {
					mnemonic = "Instruction not known";
				}
			} else if(op == 28) {
				if((funct >= 0 && funct <= 1) || (funct >= 4 && funct <= 5)) {
					functName = OpMappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick1 + " " + regNick2;
					//[funct rs rt]
				} else if(funct == 2) {
					functName = OpMappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1 + " "
					+ regNick2;
					//[funct rd rs rt]
				} else if(funct >= 33 && funct <= 34) {
					functName = OpMappings.OP28Functions[funct];
					mnemonic = functName + " " + regNick3 + " " + regNick1;
					//[funct rd rs]
				} else {
					mnemonic = "Instruction not known";
				}
			}
		} else if(format == 'I') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int imm = Integer.parseInt(temp.substring(16, 32));

			String regNick1 = OpMappings.registerNicks[rs];
			String regNick2 = OpMappings.registerNicks[rt];

			String functName = "";

			if(op == 1) {
				if((rt >= 0 && rt <= 3) || (rt >= 16 && rt <= 19)
						|| (rt >= 8 && rt <= 12) || (rt == 14)) {
					functName = OpMappings.OP1Functions[rt];
					mnemonic = functName + " " + regNick1 + " " +  imm;
					//[funct rs label/imm]
				} else {
					mnemonic = "Instruction not known";
				}
			} else {
				OpCode temp2 = OpMappings.allOP[op];
				functName = temp2.getOpCodeName();

				if((op >= 4 && op <= 5) && (op >= 20 && op <= 21)) {
					mnemonic = functName + " " + regNick1 + " " +  regNick2 + " " + imm;
					//[funct rs rt offset]
				} else if((op >= 6 && op <= 7) || (op >= 22 && op <= 23)) {
					mnemonic = functName + " " + regNick1 + " " + imm;
					//[funct rs offset]
				} else if(op >= 8 && op <= 14) {
					mnemonic = functName + " " + regNick2 + " " +  regNick1 + " " + imm;
					//[funct rt rs imm]
				} else if((op == 15) || (op >= 32 && op <= 38) || (op >= 40 && op <= 43)
						|| (op == 46) || (op == 48) || (op == 50) || (op == 54)
						|| (op == 56) || (op ==58) || (op ==62)) {
					mnemonic = functName + " " + regNick2 + " " + imm;
					//[funct rt imm/offset]
				} else if((op == 47) || (op == 51)) {
					mnemonic = functName + " " + rt + " " + imm;
					//[funct op offset(base)]
				} else {
					mnemonic = "Instruction not known";
				}
			}
		} else if(format == 'J') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int label = Integer.parseInt(temp.substring(6, 32));

			OpCode temp2 = OpMappings.allOP[op];
			String functName = temp2.getOpCodeName();

			mnemonic = functName + " " + label;
		}

		return mnemonic;
	}

}
