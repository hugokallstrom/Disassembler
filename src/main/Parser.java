package main;

import java.util.ArrayList;

public class Parser {

	ArrayList <Long> decList;
	ArrayList <String> mnemonicList = new ArrayList<String>();
	ArrayList <String> formatList = new ArrayList<String>();

	public Parser(ArrayList<Long> decList) {
		this.decList = decList;
	}

	public void parseOP() {
		int i = 0;

		while(i < decList.size()) {
			long instruction = decList.get(i);
			int op = (int) instruction/67108864;
			/* Insert format in formatList */
			String format = MnomicFormat.getFormat(op);
			formatList.add(format);
			/* Insert mnemonic representaion in mnemonicList */
			String mnemonic = MnomicFormat.getMnomicFormat(format, instruction);
			mnemonicList.add(mnemonic);
			i++;
		}
	}

	public ArrayList<String> getMnemonicList() {
		return mnemonicList;
	}

	public ArrayList<String> getFormatList() {
		return formatList;
	}


}
