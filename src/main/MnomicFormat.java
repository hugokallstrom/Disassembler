package main;

import mappings.OpMappings;

public class MnomicFormat {

	public static String getFormat(int op) {
		if(op == 0) {
			return "R";
		} else if(op == 28) {
			return "R";
		}


		OpCode temp = OpMappings.allOP[op];

		String format = OpCode.get...

		return format;

	}

	public static String getMnomicFormat(String format, long number) {
		if(format.contains("R")) {

		}
	}



}
