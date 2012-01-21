package com.bdenney.sotab;

import org.json.JSONObject;

import com.bdenney.model.QueryParameter;
import com.bdenney.model.QuestionQueryParameter;

/**
 * Performs a question request.  Will retrieve all questions on the site.
 * @author Brandon
 */
public class QuestionRequest extends BaseRequest {
	// Defines the base path of a questions request. 
	private static final String BASE_PATH = "/questions";
	
	private QuestionQueryParameter mQueryParams;

	@Override
	protected String getBasePath() {
		return BASE_PATH;
	}

	@Override
	protected QueryParameter getQueryParameters() {
		return mQueryParams;
	}

	@Override
	protected void translate(JSONObject jsonObj) {
	}
}
