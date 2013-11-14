package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class FileParser {

	ArrayList <String> codeList = new ArrayList<String>();
	ArrayList <String> hexList = new ArrayList<String>();
	ArrayList <Long> decList = new ArrayList<Long>();
	String file;

	public FileParser(String file) {
		this.file = file;
	}

	public void readFile() {
		String line = null;

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			while((line = br.readLine()) != null) {
				codeList.add(line);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void divideList() {
		int i = 0;
		String hex = null;
		long dec = 0;

		while(i < codeList.size()) {
			String code = codeList.get(i);

			if(code.contains("x") && code != null) {
				hexList.add(i, code);
				hex = code.substring(2);
				dec = Long.parseLong(hex, 16);
				decList.add(dec);
			} else {
				decList.add(i, (long) Integer.parseInt(code));
				hex = Integer.toHexString(Integer.parseInt(code));
				hexList.add(hex);
			}
			i++;
		}
		System.out.println("Hex list:" + hexList.toString());
		System.out.println("Dec list:" + decList.toString());
	}

	public ArrayList<String> getHexList() {
		return hexList;
	}

	public ArrayList<Long> getDecList() {
		return decList;
	}
}
