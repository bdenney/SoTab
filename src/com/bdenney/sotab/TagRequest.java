package com.bdenney.sotab;

import com.bdenney.model.QueryParameter;

/**
 * Performs a tag request.  Will retrieve all tags on the site.
 * @author Brandon
 */
public class TagRequest {
	// Defines a filter that must be contained in returned tag.
	private String mFilter;
	
	// Defines common query parameters.
	private QueryParameter mQueryParams;
}
