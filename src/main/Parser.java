package main;

import java.util.ArrayList;

public class Parser {

	ArrayList <Long> decList;

	public Parser(ArrayList<Long> decList) {
		this.decList = decList;
	}

	public void parseOP() {
		int i = 0;

		while(i < decList.size()) {
			long val = decList.get(i);
			long op = val/67108864;
			System.out.println(op);
			i++;
		}
	}
}
