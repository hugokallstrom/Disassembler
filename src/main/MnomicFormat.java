package main;

import mappings.OpCode;
import mappings.OpMappings;

public class MnomicFormat {


	public static char getFormat(int op) {
		OpCode tempOp;

		if(op == 0) {
			return 'R';
		} else if(op == 28) {
			return 'R';
		} else if(op == 1) {
			return 'I';
		}


		OpCode temp = OpMappings.allOP[op];

		char format = temp.getOpCodeType();

		return format;

	}

	public static String getMnomicFormat(char format, long number) {

		String mnemonic = "";
		if(format == 'R') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int rd = Integer.parseInt(temp.substring(16, 21));
			int shamt = Integer.parseInt(temp.substring(21, 26));
			int funct = Integer.parseInt(temp.substring(26, 32));

			OpCode temp2 = OpMappings.allOP[op];

			String functName = OpMappings.RFunctions[funct];
			String regNick1 = OpMappings.registerNicks[rs];
			String regNick2 = OpMappings.registerNicks[rt];
			String regNick3 = OpMappings.registerNicks[rd];


			mnemonic = functName + " " + regNick3 + " " + regNick1 + " " + regNick2;

		} else if(format == 'I') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int imm = Integer.parseInt(temp.substring(16, 32));


			String functName = "";
			if(op == 1) {
				if(rt < 20 && rt >= 0) {
					functName = OpMappings.OP1Functions[rt];
				}
			} else {
				OpCode temp2 = OpMappings.allOP[op];
				functName = temp2.getOpCodeName();
			}

			OpCode temp2 = OpMappings.allOP[op];

			String functName = temp2.getOpCodeName();

			String regNick1 = OpMappings.registerNicks[rs];
			String regNick2 = OpMappings.registerNicks[rt];

			if(op .....) {

			} else if(fdfdfsf) {

			}else if (adfdf) {

			}


			mnemonic = functName + " " + regNick2 + " " + imm + regNick1;

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
