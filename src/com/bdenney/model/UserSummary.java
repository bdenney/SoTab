package com.bdenney.model;

import org.json.JSONObject;

public class UserSummary implements JsonSerializable{
	// The ID of the user.
	private long mId;
	
	// The type of user.
	private UserType mType;
	
	// The display name of the user.
	private String mDisplayName;
	
	// The amount of reputation the user has.
	private long mReputation;
	
	// The hash of the user's email.
	private String mEmailHash;

	public UserSummary(JSONObject jsonObj) {
		fromJson(jsonObj);
	}
	
	// JSON object names.
	private static final String OWNER_ROOT_OBJ = "owner";
	private static final String USER_ID_OBJ = "user_id";
	private static final String USER_TYPE_OBJ = "user_type";
	private static final String DISPLAY_NAME_OBJ = "display_name";
	private static final String REPUTATION_OBJ  = "reputation";
	private static final String EMAIL_HASH_OBJ = "email_hash";
	
	@Override
	public void fromJson(JSONObject jsonObj) {
		// TODO Auto-generated method stub
	}
}
