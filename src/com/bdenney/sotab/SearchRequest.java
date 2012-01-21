package com.bdenney.sotab;

import java.util.ArrayList;

import com.bdenney.model.QueryParameter;

/**
 * Performs a search on the site.
 * @author Brandon
 */
public class SearchRequest {
	
	// Defines a list of tags to exclude.
	private ArrayList<String> mNotTagged;
	
	// Defines a list of tags to include.
	private ArrayList<String> mTagged;
	
	// Defines common query parameters.
	private QueryParameter mQueryParams;
}
