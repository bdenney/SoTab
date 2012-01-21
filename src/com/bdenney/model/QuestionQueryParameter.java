package com.bdenney.model;

import java.util.ArrayList;

/**
 * Defines the query parameters for a question request.
 * @author Brandon
 */
public class QuestionQueryParameter extends QueryParameter {
	// Query parameter key values.
	private static final String ANSWERS_PARAM = "answers";
	private static final String BODY_PARAM = "body";
	private static final String COMMENTS_PARAM = "comments";
	
	// When 'true', the answers to a question will be returned.
	private boolean mShouldReturnAnswers;
	
	// When 'true', a post's body will be included in the response.
	private boolean mShouldReturnBody;
	
	// When 'true', a post's comments will be included in the response.
	private boolean mShouldReturnComments;
	
	// How the questions should be sorted.
	private QuestionSortType mSort;

	// Tags questions must have.
	private ArrayList<String> mTagged;
	
	/**
	 * Return the URL-formatted parameter values.
	 * @remark Currently excludes date values.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append(AMPERSAND);
		sb.append(formatParamValue(ANSWERS_PARAM, mShouldReturnAnswers));
		sb.append(AMPERSAND);
		sb.append(formatParamValue(BODY_PARAM, mShouldReturnBody));
		sb.append(AMPERSAND);
		sb.append(formatParamValue(COMMENTS_PARAM, mShouldReturnComments));
		return sb.toString();
	}
}
