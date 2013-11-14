/**
 * class containing all the opcodes and methods for retreiveng an opcode
 * depending on the sent in decimal value.
 * @author oi11mhn
 * date: 2013-10-14
 */

package mappings;

public class OpMappings {


	public static OpCode allOP[];
	public static String OP0Functions[];
	public static String OP28Functions[];


	public OpMappings(){

			allOP = new OpCode[63];
			OP0Functions = new String[55];
			OP28Functions = new String[39];

			allOP[2] = new OpCode("j",'J');
			allOP[3] = new OpCode("jal",'J');
			allOP[4] = new OpCode("beq",'I');
			allOP[5] = new OpCode("bne",'I');
			allOP[6] = new OpCode("blez",'?');  //!!!!!!!!!!!!!!!!
			allOP[7] = new OpCode("bgtz",'?');  //!!!!!!!!!!!!!!
			allOP[8] = new OpCode("addi",'I');;
			allOP[9] = new OpCode("addiu",'I');
			allOP[10] = new OpCode("slti",'I');
			allOP[11] = new OpCode("sltiu",'I');
			allOP[12] = new OpCode("andi",'I');
			allOP[13] = new OpCode("ori",'I');
			allOP[14] = new OpCode("xori",'R');
			allOP[15] = new OpCode("lui",'I');

			allOP[20] = new OpCode("beql",'I');  //!!!!!!!!!!
			allOP[21] = new OpCode("bnel",'I');  //!!!!!!!
			allOP[22] = new OpCode("blezl",'I');  //!!!!!!!!!
			allOP[23] = new OpCode("bgtzl",'I');  //!!!!!!!!!

			allOP[32] = new OpCode("lb",'I');	//!!!!!!!!!!
			allOP[33] = new OpCode("lh",'I');
			allOP[34] = new OpCode("lwl",'I');
			allOP[35] = new OpCode("lw",'I');
			allOP[36] = new OpCode("lbu",'I');   //!!!!!!!!!!
			allOP[37] = new OpCode("lhu",'I');
			allOP[38] = new OpCode("lwr",'I');

			allOP[40] = new OpCode("sb",'I');
			allOP[41] = new OpCode("sh",'I');
			allOP[42] = new OpCode("swl",'I');
			allOP[43] = new OpCode("sw",'I');

			allOP[46] = new OpCode("swr",'I');	//!!!!!!!!
			allOP[47] = new OpCode("cache",'I');	//!!!!!!!!!!
			allOP[48] = new OpCode("ll",'I');		//!!!!!!1
			allOP[49] = new OpCode("lwc1",'I');		//!!!!!!
			allOP[50] = new OpCode("lwc2",'I');		//!!!!!!
			allOP[51] = new OpCode("pref",'I');		//!!!!!

			allOP[53] = new OpCode("ldc1",'J');		//alla nedan är osäkra angående typ.
			allOP[54] = new OpCode("ldc2",'J');

			allOP[56] = new OpCode("sc",'J');
			allOP[57] = new OpCode("swc1",'J');
			allOP[58] = new OpCode("swc2",'J');

			allOP[61] = new OpCode("sdc1",'J');
			allOP[61] = new OpCode("sdc2",'J');
	}



}
