package com.bdenney.sotab;

import com.bdenney.model.QueryParameter;

/**
 * Performs a user request.  Will retrieve all users of a site.
 * @author Brandon
 */
public class UserRequest {
	// String that must appear in returned users' names.
	private String mFilter;
	
	// Common query parameters.
	private QueryParameter mQueryParams;
}
