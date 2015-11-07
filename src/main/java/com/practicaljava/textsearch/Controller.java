package com.practicaljava.textsearch;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/text")
public class Controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		Search fileSearch = new Search();
		String value = request.getParameter("q");
		String length = request.getParameter("length");
		try {
			fileSearch.getAttributes();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MetaData metaData = null;
		try {
			metaData = fileSearch.getAttributes();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		TextDTO text = null;
		if (value == null || value.equals("")) {
			text = new TextDTO(fileSearch.getAllText(), metaData);
		} else if(length == null || length.equals("")) {
			text = new TextDTO(fileSearch.searchByQuery(value, 0), metaData);
		} else {
			text = new TextDTO(fileSearch.searchByQuery(value, Integer.parseInt(length)), metaData);
		}
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		response.getWriter().write(gson.toJson(text));
	}
}