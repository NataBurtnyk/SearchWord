package com.practicaljava.textsearch;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@WebServlet("/text")
public class TextController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TextSearch fileSearch = new TextSearch();
		
		response.setContentType("application/json");
		
		Text text = new Text(fileSearch.read(request.getParameter("q")));
		
		response.getWriter().write(new Gson().toJson(text));
	}

}
