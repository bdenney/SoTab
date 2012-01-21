package com.bdenney.model;

/**
 * Defines a StackOverflow tag.  Used to categorize questions.
 * @author Brandon
 */
public class Tag {
	// The name of the tag.
	private String mName;
	
	/**
	 * Gets the name of the tag.
	 * @return the name of the tag.
	 */
	public String getName() {
		if (mName == null) {
			return "";
		}
		return mName;
	}
	
	// The number of questions with the tag.
	private long mCount;
	
	// TODO: Figure out what this is for.
	private boolean mFulfillsRequired;	
	
	/**
	 * Constructor.
	 * @param name the name of the tag.
	 */
	public Tag(String name) {
		mName = name;
	}
	
	/**
	 * Returns the name of the tag.
	 */
	@Override 
	public String toString() {
		return getName();
	}
}
