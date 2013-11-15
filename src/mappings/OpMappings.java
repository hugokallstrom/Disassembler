/**
 * class containing all the opcodes stored depending on
 * it's opcode decimal value.
 * @author oi11mhn
 * date: 2013-10-14
 */

package mappings;

public class OpMappings {


	public static OpCode allOP[];
	public static String RFunctions[];
	public static String OP28Functions[];
	public static String registerNicks[];

	public OpMappings(){

			allOP = new OpCode[63];
			RFunctions = new String[55];
			OP28Functions = new String[39];

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
			RFunctions[11] = "";
			RFunctions[12] = "";
			RFunctions[13] = "";

			RFunctions[15] = "";
			RFunctions[16] = "";
			RFunctions[17] = "";
			RFunctions[18] = "";
			RFunctions[19] = "";

			RFunctions[24] = "";
			RFunctions[25] = "";
			RFunctions[26] = "";
			RFunctions[27] = "";

			RFunctions[32] = "";
			RFunctions[33] = "";
			RFunctions[34] = "";
			RFunctions[35] = "";
			RFunctions[36] = "";
			RFunctions[37] = "";
			RFunctions[38] = "";
			RFunctions[39] = "";

			RFunctions[42] = "";
			RFunctions[43] = "";

			RFunctions[48] = "";
			RFunctions[49] = "";
			RFunctions[50] = "";
			RFunctions[51] = "";
			RFunctions[52] = "";

			RFunctions[54] = "";

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
