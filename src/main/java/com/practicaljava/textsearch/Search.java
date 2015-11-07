package com.practicaljava.textsearch;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Search {

	private static String fileName = ("Text.txt");
	
	public MetaData getAttributes() throws IOException, ParseException{
		File file = new File(accessToFile());
		
		BasicFileAttributes attr = Files.readAttributes(Paths.get(accessToFile()), BasicFileAttributes.class);
		
		double size = (file.length() / 1024.0);
	
		String date = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss.S").format(attr.creationTime().toMillis());
	
		return new MetaData(file.getName(), Double.toString(size) + "KB", date);
	}
	
	public ArrayList<String> searchByQuery(String q,int length)
			throws FileNotFoundException { 
		long size = 0;
		
		isFileExists();
		
		Scanner sc = new Scanner(new File(accessToFile())).useDelimiter("\\s*[<,\". >]\\s*");
		ArrayList<String> result = new ArrayList<String>();
		String s = null;
		while (sc.hasNext()) {
			s = sc.next();
			if (s.equalsIgnoreCase(q) || s.contains(q)) {
				if(s.length() <= length && length !=0) {
					size += s.length();
					if(size>=15){
						break;
					}
					result.add(s);
				} else if(length != 0) {
					size += s.substring(0, length).length();
					if(size>=15){
						break;
					}
					result.add(s.substring(0, length));
				} else {
					size += s.length();
					if(size>=15){
						break;
					}
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
		return Search.class.getClassLoader().getResource(fileName)
				.getFile();
	}
}
