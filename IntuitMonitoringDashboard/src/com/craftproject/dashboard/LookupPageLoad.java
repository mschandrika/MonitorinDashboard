package com.craftproject.dashboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LookupPageLoad {
	
	public static SitePageData by(SearchOptions searchCriteria, String value) {
		SitePageData spd = new SitePageData();
		try {
			spd = getElementFromDb(searchCriteria, value);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return spd;
	}
	
	private static SitePageData getElementFromDb(SearchOptions column, String value) throws SQLException, ClassNotFoundException {
		SitePageData e = new SitePageData();
		Class.forName("org.h2.Driver");
        	Connection conn = DriverManager.
            		getConnection("jdbc:h2:~/test", "sa", "");
        	String SQLQuery = String.format("Select * from CSVREAD('http://localhost:8080/IntuitMonitoringDashboard/static_pageload_data.csv') WHERE LOWER(%s) LIKE ?", column.getColumnName());
        	PreparedStatement getAnElementRow = conn.prepareStatement(SQLQuery);
        	getAnElementRow.setString(1, String.format("%s%s%s", "%", value, "%"));
        	ResultSet theElementSet = getAnElementRow.executeQuery();
        	if(theElementSet.next()) {
        		e = new SitePageData(
        			theElementSet.getString(SearchOptions.USER_TIMEPERIOD.getColumnName()), 
        			theElementSet.getString(SearchOptions.SITE_REACHABILITY.getColumnName()), 
        			theElementSet.getString(SearchOptions.PAGE_LOAD_TIME.getColumnName())
        					);
        	}
        	conn.close();
        	return e;
	}

}
