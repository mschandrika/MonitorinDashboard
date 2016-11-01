package com.craftproject.dashboard;

public enum SearchOptions {
	
USER_TIMEPERIOD("userTimePeriod"), SITE_REACHABILITY("siteReachability"), PAGE_LOAD_TIME("pageLoadTime");
	
	private String databaseColumnName;
	
	private SearchOptions(String databaseColumnName) {
		this.databaseColumnName = databaseColumnName;
	}
	
	public String getColumnName() {
		return this.databaseColumnName;
	}
	
	public static SearchOptions getOptionFromString(String value) {
		for(SearchOptions s : SearchOptions.values()) {
			String item = s.getColumnName();
			if(item.equalsIgnoreCase(value)) {
				return s;
			}
		}
		return USER_TIMEPERIOD;
	}
	
	public static boolean contains(SearchOptions value) {
		for(SearchOptions s : SearchOptions.values()) {
			if(s.equals(value)) {
				return true;
			}
		}
		return false;
	}

}
