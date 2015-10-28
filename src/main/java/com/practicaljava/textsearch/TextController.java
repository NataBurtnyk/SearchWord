package com.practicaljava.textsearch;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/text")
public class TextController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		
		TextSearch fileSearch = new TextSearch();
		String value = request.getParameter("q");
		Text text = null;
		if (value == null || value.equals("")) {
			text = new Text<String>(fileSearch.getAllText());
		} else {
			text = new Text<ArrayList<String>>(fileSearch.searchByQuery(value));
		}
		response.getWriter().write(new Gson().toJson(text));
	}
}