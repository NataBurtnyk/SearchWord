package com.practicaljava.textsearch;


public class TextDTO<T> {
	
	private T text;
	private MetaData metaData;
	
	public TextDTO(T text, MetaData metaData) {
		this.text = text;
		this.metaData = metaData;
	}

	public T getText() {
		return text;
	}
	
	public void setText(T text) {
		this.text = text;
	}

	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	
	
}
