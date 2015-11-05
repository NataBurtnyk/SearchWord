package com.practicaljava.textsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class TextSearch {

	private static String fileName = ("Text.txt");

	public ArrayList<String> searchByQuery(String q, int length)
			throws FileNotFoundException { 
		isFileExists();
		Scanner sc = new Scanner(new File(accessToFile())).useDelimiter("\\s*[<,\". >]\\s*");
		ArrayList<String> result = new ArrayList<String>();
		String s = null;
		while (sc.hasNext()) {
			s = sc.next();
			if (s.equalsIgnoreCase(q) || s.contains(q)) {
				if(s.length() <= length && length !=0) {					
					result.add(s);
				} else if(length != 0) {
					result.add(s.substring(0, length));
				} else {
					result.add(s);
				}
			}
		}
		return result;
	}
	
	public String getAllText() throws FileNotFoundException {																													
		isFileExists();
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null;


		try {
			in = new BufferedReader(new FileReader(accessToFile()));
			String s;

			while ((s = in.readLine()) != null) {
				sb.append(s);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}

	private void isFileExists() throws FileNotFoundException {
		File file = new File(accessToFile());
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
	}

	private static String accessToFile() {
		return TextSearch.class.getClassLoader().getResource(fileName)
				.getFile();
	}
}
