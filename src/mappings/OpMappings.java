/**
 * class containing all the opcodes stored depending on
 * it's opcode decimal value.
 * @author oi11mhn
 * date: 2013-10-14
 */

package mappings;

public class OpMappings {


	public static OpCode allOP[];
	public static String OP1Functions[];
	public static String RFunctions[];
	public static String OP28Functions[];
	public static String OP161718Functions[];
	public static String registerNicks[];

	public OpMappings(){

			allOP = new OpCode[63];
			OP1Functions = new String[31];
			RFunctions = new String[55];
			OP28Functions = new String[35];
			OP161718Functions = new String[31];

			allOP[2] = new OpCode("j",'J');
			allOP[3] = new OpCode("jal",'J');
			allOP[4] = new OpCode("beq",'I');
			allOP[5] = new OpCode("bne",'I');
			allOP[6] = new OpCode("blez",'I');
			allOP[7] = new OpCode("bgtz",'I');
			allOP[8] = new OpCode("addi",'I');;
			allOP[9] = new OpCode("addiu",'I');
			allOP[10] = new OpCode("slti",'I');
			allOP[11] = new OpCode("sltiu",'I');
			allOP[12] = new OpCode("andi",'I');
			allOP[13] = new OpCode("ori",'I');
			allOP[14] = new OpCode("xori",'I');
			allOP[15] = new OpCode("lui",'I');

			allOP[20] = new OpCode("beql",'I');
			allOP[21] = new OpCode("bnel",'I');
			allOP[22] = new OpCode("blezl",'I');
			allOP[23] = new OpCode("bgtzl",'I');

			allOP[32] = new OpCode("lb",'I');
			allOP[33] = new OpCode("lh",'I');
			allOP[34] = new OpCode("lwl",'I');
			allOP[35] = new OpCode("lw",'I');
			allOP[36] = new OpCode("lbu",'I');
			allOP[37] = new OpCode("lhu",'I');
			allOP[38] = new OpCode("lwr",'I');

			allOP[40] = new OpCode("sb",'I');
			allOP[41] = new OpCode("sh",'I');
			allOP[42] = new OpCode("swl",'I');
			allOP[43] = new OpCode("sw",'I');

			allOP[46] = new OpCode("swr",'I');
			allOP[47] = new OpCode("cache",'I');	//!!!!!!!!!!
			allOP[48] = new OpCode("ll",'I');
			allOP[49] = new OpCode("lwc1",'I');
			allOP[50] = new OpCode("lwc2",'I');
			allOP[51] = new OpCode("pref",'I');

			allOP[53] = new OpCode("ldc1",'I');
			allOP[54] = new OpCode("ldc2",'I');

			allOP[56] = new OpCode("sc",'I');
			allOP[57] = new OpCode("swc1",'I');
			allOP[58] = new OpCode("swc2",'I');

			allOP[61] = new OpCode("sdc1",'I');
			allOP[61] = new OpCode("sdc2",'I');

			//filling in values for Rfunctions (with opCode 0x00)

			RFunctions[0] = "sll";
			RFunctions[2] = "srl";
			RFunctions[3] = "sra";
			RFunctions[4] = "sllv";

			RFunctions[6] = "srlv";
			RFunctions[7] = "srav";
			RFunctions[8] = "jr";
			RFunctions[9] = "jalr";
			RFunctions[10] = "movz";
			RFunctions[11] = "movn";
			RFunctions[12] = "syscall";
			RFunctions[13] = "break";

			RFunctions[15] = "sync";
			RFunctions[16] = "mfhi";
			RFunctions[17] = "mthi";
			RFunctions[18] = "mflo";
			RFunctions[19] = "mtlo";

			RFunctions[24] = "mult";
			RFunctions[25] = "multu";
			RFunctions[26] = "div";
			RFunctions[27] = "divu";

			RFunctions[32] = "add";
			RFunctions[33] = "addu";
			RFunctions[34] = "sub";
			RFunctions[35] = "subu";
			RFunctions[36] = "and";
			RFunctions[37] = "or";
			RFunctions[38] = "xor";
			RFunctions[39] = "nor";

			RFunctions[42] = "slt";
			RFunctions[43] = "sltu";

			RFunctions[48] = "tge";
			RFunctions[49] = "tgeu";
			RFunctions[50] = "tlt";
			RFunctions[51] = "tltu";
			RFunctions[52] = "teq";

			RFunctions[54] = "tne";

			//filling in values for the opcode 28.

			OP28Functions[0] = "madd";
			OP28Functions[1] = "maddu";
			OP28Functions[2] = "mul";

			OP28Functions[4] = "msub";
			OP28Functions[5] = "msubu";

			OP28Functions[33] = "clz";
			OP28Functions[34] = "clo";

			//filling in values for the opcode 1.

			OP1Functions[0] = "bltz";
			OP1Functions[1] = "bgez";
			OP1Functions[2] = "bltzl";
			OP1Functions[3] = "bgezl";

			OP1Functions[8] = "tgei";
			OP1Functions[9] = "tgeiu";
			OP1Functions[10] = "tlti";
			OP1Functions[11] = "tltiu";
			OP1Functions[12] = "tegi";

			OP1Functions[14] = "tnei";

			OP1Functions[16] = "bltzal";
			OP1Functions[17] = "bgezal";
			OP1Functions[18] = "bltzall";
			OP1Functions[19] = "bgczall";

			//filling op161718 with values

			OP161718Functions[0] = "mfc";
			OP161718Functions[2] = "cfc";
			OP161718Functions[4] = "mtc";
			OP161718Functions[6] = "ctc";

			OP161718Functions[16] = "mfc";



			//filling in registers
			registerNicks[0] = "$zero";
			registerNicks[1] = "$at";
			registerNicks[2] = "$v0";
			registerNicks[3] = "$v1";
			registerNicks[4] = "$a0";
			registerNicks[5] = "$a1";
			registerNicks[6] = "$a2";
			registerNicks[7] = "$a3";
			registerNicks[8] = "$t0";
			registerNicks[9] = "$t1";
			registerNicks[10] = "$t2";
			registerNicks[11] = "$t3";
			registerNicks[12] = "$t4";
			registerNicks[13] = "$t5";
			registerNicks[14] = "$t6";
			registerNicks[15] = "$t7";
			registerNicks[16] = "$s0";
			registerNicks[17] = "$s1";
			registerNicks[18] = "$s2";
			registerNicks[19] = "$s3";
			registerNicks[20] = "$s4";
			registerNicks[21] = "$s5";
			registerNicks[22] = "$s6";
			registerNicks[23] = "$s7";
			registerNicks[24] = "$t8";
			registerNicks[25] = "$t9";
			registerNicks[26] = "$k0";
			registerNicks[27] = "$k1";
			registerNicks[28] = "$gp";
			registerNicks[29] = "$sp";
			registerNicks[30] = "$fp";
			registerNicks[31] = "$ra";
	}


}
