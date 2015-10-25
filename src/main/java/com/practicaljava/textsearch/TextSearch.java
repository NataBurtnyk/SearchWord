package com.practicaljava.textsearch;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextSearch {

	private static String fileName = ("Text.txt");
	public static void main(String[] args) throws FileNotFoundException {

	}
	
	public String read(String q) throws FileNotFoundException {
		isFileExists();
		
		StringBuilder sb = new StringBuilder();
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(accessToFile()));
			String s;

			while ((s = in.readLine()) != null) {
				
					
					sb.append(s);
					sb.append("\n");
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
	
	private String accessToFile() {
		return this.getClass().getClassLoader().getResource(fileName).getFile();
	}
}
