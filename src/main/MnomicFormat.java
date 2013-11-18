package main;

import mappings.OpCode;
import mappings.OpMappings;

public class MnomicFormat {


	public static char getFormat(int op) {
		if(op == 0) {
			return 'R';
		} else if(op == 28) {
			return 'R';
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
			
			if((funct >= 32 && funct <= 39)  || (funct >= 42 && funct <= 43) || (funct >= 10 && funct <= 11) ) {
				mnemonic = functName + " " + regNick3 + " " + regNick1 + " " + regNick2;
				//[funct rd rs rt]
			} else if((funct >= 24 && funct <= 27) || (funct >= 48 && funct <= 54)) {
				mnemonic = functName + " " + regNick1 + " " + regNick2;
				//[funct rs rt]
			} else if((funct == 17) || (funct == 19) || (funct == 8)) {
				mnemonic = functName + " " + regNick1;
				//[funct rs]
			} else if((funct == 18) || (funct == 16)) {
				mnemonic = functName + " " + regNick3;
				//[funct rd]
			} else if (funct == 13) {
				mnemonic = functName + " " + rs + rt + rd + shamt ;
				//[funct code]
			} else if(funct == 12) {
				mnemonic = functName;
				//[functname]
			} else if(funct == 9) {
				mnemonic = functName + " " + regNick1 + " " + regNick3;
				//[funct rs rd]
			} else if ((funct >= 6 && funct <= 7) || (funct == 4)) {
				mnemonic = functName + " " + regNick3 + " " + regNick2 + " " + regNick1;
				//[funct rd rt rs]
			} else if ((funct >= 2 && funct <= 3) || (funct == 0)) {
				mnemonic = functName + " " + regNick3 + " " + regNick2 + " " + shamt;
				//[funct rd rt shamt]
			} else if(funct == 1) {
				int bit16 = Integer.parseInt(temp.substring(16, 17));
				String functName = OpMappings.op1func1[bit16];
			}
			

		} else if(format == 'I') {
			String temp = Long.toBinaryString(number);
			int op = Integer.parseInt(temp.substring(0, 6));
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int imm = Integer.parseInt(temp.substring(16, 32));

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
