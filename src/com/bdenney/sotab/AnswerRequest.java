package com.bdenney.sotab;

import com.bdenney.model.QueryParameter;

/**
 * Performs an answer request.  Will retrieve all answers on a site.
 * @author Brandon
 */
public class AnswerRequest {	
	// If 'true', a post's body will be included in the response.
	private boolean mShouldIncludeBody;
	
	// If 'true', any comments on a post will be included in the response.
	private boolean mShouldIncludeComments;
	
	// Common query parameters.
	private QueryParameter mQueryParams;
}
