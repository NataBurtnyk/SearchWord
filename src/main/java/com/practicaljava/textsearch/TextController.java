package com.practicaljava.textsearch;

import java.io.IOException;

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
		Text text = new Text(fileSearch.read(request.getParameter("q")));
		
		response.getWriter().write(new Gson().toJson(text));
	}

}