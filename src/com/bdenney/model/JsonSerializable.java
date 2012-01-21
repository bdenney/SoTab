package com.bdenney.model;

import org.json.JSONException;
import org.json.JSONObject;

public interface JsonSerializable {
	void fromJson(JSONObject jsonObj) throws JSONException;
}
