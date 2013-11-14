/**
 * class containing all the opcodes and methods for retreiveng an opcode
 * depending on the sent in decimal value.
 * @author oi11mhn
 * date: 2013-10-14
 */


public class OpCodes {


	public static String allOP[];

	public OpCodes(){

		allOP = new String[63];

		allOP[2] = "j";
		allOP[3] = "jal";
		allOP[4] = "beq";
		allOP[5] = "bne";
		allOP[6] = "blez";
		allOP[7] = "bgtz";
		allOP[8] = "addi";
		allOP[9] = "addiu";
		allOP[10] = "slti";
		allOP[11] = "sltiu";
		allOP[12] = "andi";
		allOP[13] = "ori";
		allOP[14] = "xori";
		allOP[15] = "lui";

		allOP[20] = "beql";
		allOP[21] = "bnel";
		allOP[22] = "blezl";
		allOP[23] = "bgtzl";

		allOP[32] = "lb";
		allOP[33] = "lh";
		allOP[34] = "lwl";
		allOP[35] = "lw";
		allOP[36] = "lbu";
		allOP[37] = "lhu";
		allOP[38] = "lwr";

		allOP[40] = "sb";
		allOP[41] = "sh";
		allOP[42] = "swl";
		allOP[43] = "sw";

		allOP[46] = "swr";
		allOP[47] = "cache";
		allOP[48] = "ll";
		allOP[49] = "lwc1";
		allOP[50] = "lwc2";
		allOP[51] = "pref";

		allOP[53] = "ldc1";
		allOP[54] = "ldc2";

		allOP[56] = "sc";
		allOP[57] = "swc1";
		allOP[58] = "swc2";

		allOP[61] = "sdc1";
		allOP[62] = "sdc2";

	}





}
