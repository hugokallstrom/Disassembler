package mappings;



public class OpCode {

	private String opCodeName;
	private char opCodeType;

	public OpCode(){

		opCodeName = new String();

	}

	/**
	 * method for setting a name to this opCode.
	 * @param String name
	 */
	public void setOpCodeName(String name){
		opCodeName = name;
	}

	/**
	 * method for setting a type to this opCode.
	 * @param Char OpType
	 */
	public void setOpCodeType(char OpType){
		opCodeType = OpType;
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
