package main;

import java.util.ArrayList;

public class Parser {

	ArrayList <Long> decList;
	ArrayList <String> mnemonicList;

	public Parser(ArrayList<Long> decList) {
		this.decList = decList;
	}

	public void parseOP() {
		int i = 0;

		while(i < decList.size()) {
			long val = decList.get(i);
			int op = (int) val/67108864;
			System.out.println(op);
			i++;
		}
	}


}
