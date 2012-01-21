package com.bdenney.model;

/**
 * Defines common query parameters.
 * @author Brandon
 */
public class QueryParameter {
	/**
	 * Static instance of an ampersand.
	 */
	public static final String AMPERSAND = "&";
	
	// Query parameter key values.
	private static final String ORDER_PARAM = "order";
	private static final String PAGE_PARAM = "page";
	private static final String PAGESIZE_PARAM = "pagesize";
	
	// Unix time stamp of the minimum creation date on a returned item. Unix epoch date, range [0,253,402,300,799].
	private long mFromDate;
	
	// Maximum of the range to include in the response according to the current sort. Can be integer or Unix epoch date.
	private long mMax = 30;
	
	// Minimum of the range to include in the response according to the current sort. Can be integer or Unix epoch date.
	private long mMin;
	
	// How the current sort should be ordered.
	private OrderType mOrder = OrderType.DESCENDING;
	
	// The pagination offset for the current collection.  Affected by the specified pagesize.
	private int mPage;
	
	// The number of collection results to display during pagination.  Should be between 0 and 100, inclusive.
	private int mPagesize = 30;
	
	// Unix time stamp of the maximum creation date on a returned item.  Unix epoch date, range [0,253,402,300,799].
	private long mToDate;
	
	/**
	 * Return the URL-formatted parameter values.
	 * @remark Currently excludes date values.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(formatParamValue(ORDER_PARAM,mOrder.value));
		sb.append(AMPERSAND);
		sb.append(formatParamValue(PAGE_PARAM, mPage));
		sb.append(AMPERSAND);
		sb.append(formatParamValue(PAGESIZE_PARAM, mPagesize));
		return sb.toString();
	}
	
	/**
	 * Formats a key-boolean pair into a URL-param value.
	 * @param key the param key.
	 * @param value the param value.
	 * @return the formatted String.
	 */
	public static String formatParamValue(String key, boolean value) {
		return formatParamValue(key, String.valueOf(value));
	}
	
	/**
	 * Formats a key-int pair into a URL-param value.
	 * @param key the param key.
	 * @param value the param value.
	 * @return the formatted String.
	 */
	public static String formatParamValue(String key, int value) {
		return formatParamValue(key, String.valueOf(value));
	}
	
	/**
	 * Formats a key-String pair into a URL-param value. 
	 * @param key the param key.
	 * @param value the param value.
	 * @return the formatted String.
	 */
	public static String formatParamValue(String key, String value) {
		return String.format("%s=%s", key, value);
	}
}
