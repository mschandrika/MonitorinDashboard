package com.craftproject.dashboard;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

/**
 * Servlet implementation class PageLoadServlet
 */
@WebServlet("/pageLoadData")
public class PageLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageLoadServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SearchOptions searchCriteria = SearchOptions.getOptionFromString(request.getParameter("searchCriteria").trim());
		String searchTerm = request.getParameter("searchTerm").trim().toLowerCase();
		SitePageData result = null;
		if(SearchOptions.contains(searchCriteria)) {
			result = LookupPageLoad.by(searchCriteria, searchTerm);
		} else {
			result = new SitePageData();
		}
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();
		out.print(new JSONObject(result));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
