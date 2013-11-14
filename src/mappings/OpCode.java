/**
 * class containing simple facts about one OpCode
 * @autor Mattias Hinnerson, oi11mhn
 */
package mappings;


public class OpCode {

	private String opCodeName;
	private char opCodeType;

	public OpCode(String opName, char opType){

		opCodeName = opName;
		opCodeType = opType;
	}

	/**
	 * method for getting the opCode name
	 * @return String OpCodeName
	 */
	public String getOpCodeName(){
		return opCodeName;
	}

	/**
	 * method for getting the opCode type
	 * @return char OpCodeType
	 */
	public char getOpCodeType(){
		return opCodeType;
	}
}
