package com.craftproject.dashboard;

public class SitePageData {
	
	private String siteReachability;
	private String pageLoadTime;
	private String userTimePeriod;
	
	public SitePageData() {
		
		this.userTimePeriod = "1day";
		this.siteReachability = "100%";
		this.pageLoadTime = "0sec";
	}
	
	public SitePageData(String userTimePeriod, String siteReachability, String pageLoadTime) {
		
		this.userTimePeriod = userTimePeriod;
		this.siteReachability = siteReachability;
		this.pageLoadTime = pageLoadTime;
	}
	
	public String getSiteReachability() {
		return siteReachability;
	}
	
	public void setSiteReachability(String siteReachability) {
		this.siteReachability = siteReachability;
	}
	
	public String getPageLoadTime() {
		return pageLoadTime;
	}
	
	public void setPageLoadTime(String pageLoadTime) {
		this.pageLoadTime = pageLoadTime;
	}
	
	public String getUserTimePeriod() {
		return userTimePeriod;
	}

	public void setUserTimePeriod(String userTimePeriod) {
		this.userTimePeriod = userTimePeriod;
	}

	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("User Input Timeperiod: %s%n", this.userTimePeriod));
		sb.append(String.format("Site Reachability: %s%n", this.siteReachability));
		sb.append(String.format("Page Load time: %s%n", this.pageLoadTime));
		return sb.toString();
		
	}

}
