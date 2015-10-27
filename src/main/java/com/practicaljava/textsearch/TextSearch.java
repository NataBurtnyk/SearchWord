package com.practicaljava.textsearch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextSearch {

	private static String fileName = ("Text.txt");

	public ArrayList<String> read(String q) throws FileNotFoundException { // Назание не очень
		isFileExists();
		Scanner sc = new Scanner(new File(accessToFile())).useDelimiter(" ");
		ArrayList<String> result = new ArrayList<String>();
		while (sc.hasNext()) {
			if (q.equalsIgnoreCase(sc.next())) {
				result.add(q);
			}
		}
		return result;
	}

	private void isFileExists() throws FileNotFoundException {
		File file = new File(accessToFile());
		if (!file.exists()) {
			throw new FileNotFoundException(file.getAbsolutePath());
		}
	}

	private static String accessToFile() { // Название не очень
		return TextSearch.class.getClassLoader().getResource(fileName)
				.getFile();
	}
}
