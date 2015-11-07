package com.practicaljava.textsearch;

public class MetaData {
		
	private String fileName;
	private String fileSize;
	private final String fileCreationDate;
	
	public MetaData(String fileName, String fileSize, String fileCreationDate) {
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.fileCreationDate = fileCreationDate;
	
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getFileCreationDate() {
		return fileCreationDate;
	}

}
