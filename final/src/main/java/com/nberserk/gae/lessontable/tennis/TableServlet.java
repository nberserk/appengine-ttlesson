package com.nberserk.gae.lessontable.tennis;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.google.gson.Gson;
import com.nberserk.gae.lessontable.Common;

public class TableServlet extends HttpServlet {	
	private static final long serialVersionUID = -6535578691334962972L;
	private static Gson sGson = new Gson();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response)
			throws ServletException, IOException {
		
		String date = req.getParameter(VoteServlet.PARAM_DATE);
		if(date==null)
			date = VoteServlet.getTodayDate();
		
		//response.addHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        TimeTable tt = VoteServlet.getTimeTable(date);
        if (tt==null)
        	tt = new TimeTable();
        String jsonString = sGson.toJson(tt);
        Common.info(jsonString);
        response.getWriter().write(jsonString);		
	}
	
	
	
}
// [END all]
