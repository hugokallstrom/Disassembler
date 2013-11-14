package main;

import mappings.OpCode;
import mappings.OpMappings;

public class Mnomic_Format {
	
	
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
	
	public static String getMnomicFormat(String format, long number) {
		if(format.contains("R")) {
			String temp = Long.toBinaryString(number);
			int rs = Integer.parseInt(temp.substring(6, 11));
			int rt = Integer.parseInt(temp.substring(11, 16));
			int rd = Integer.parseInt(temp.substring(16, 21));
			int shamt = Integer.parseInt(temp.substring(21, 26));
			int funct = Integer.parseInt(temp.substring(26, 32));
			
			OpCode temp2 = OpCode.get...
			if()
			String functName = OpCode.get...
			String regNick1 = OpMappings.registerNicks[rs];
			String regNick2 = OpMappings.registerNicks[rt];
			String regNick3 = OpMappings.registerNicks[rd];
			
			String mnemonic = functName + " " + regNick3 + " " + regNick1 + " " + regNick2; 

		}
	}
	
	
	
}
