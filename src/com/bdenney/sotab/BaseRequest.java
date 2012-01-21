package com.bdenney.sotab;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.json.JSONException;
import org.json.JSONObject;

import android.net.http.AndroidHttpClient;
import android.util.Log;

import com.bdenney.model.QueryParameter;

/**
 * Provides base StackOverflow request functionality.
 * @author Brandon
 */
public abstract class BaseRequest {
	// Logging tag.
	private static final String TAG = "SoTab";
	
	// Defines the host to send all requests to.
	private static final String HOST = "http://api.stackoverflow.com/1.1";
	
	// Defines the user agent of the application.
	private static final String USER_AGENT = "com.bdenney.sotab";
	
	// Holds the JSON response object.
	private JSONObject mResponseObject;
	
	/**
	 * Returns the JSON response object.
	 * @return the JSON response object.
	 */
	public JSONObject getResponseObject() {
		return mResponseObject;
	}
	
	/**
	 * Returns the base path of the StackOverflow request.
	 * @return the base path of the StackOverflow request.
	 */
	protected abstract String getBasePath(); 
	
	/**
	 * Returns the {@link QueryParameter} of the StackOverflow request.
	 * @return the {@link QueryParameter} of the StackOverflow request.
	 */
	protected abstract QueryParameter getQueryParameters();
	
	/**
	 * Callback method that will be called after the response is received.
	 * @param jsonObj the JSON response object.
	 */
	protected abstract void translate(JSONObject jsonObj);
	
	/**
	 * Sends the request to the SO APIs.
	 */
	public void send() {
		// Get the client.
		AndroidHttpClient client = AndroidHttpClient.newInstance(USER_AGENT);
		
		// Create the HTTP request.
		HttpGet request = new HttpGet(buildUrl());
		
		// Indicate that we want GZIP responses (SO doesn't give us an option anyway).
		AndroidHttpClient.modifyRequestToAcceptGzipResponse(request);
		
		try {
			// Get the response.
			HttpResponse response = client.execute(request);
			
			// Un-GZip the results.
			InputStream is = AndroidHttpClient.getUngzippedContent(
					response.getEntity());
			
			// Create a byte output stream.
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			// Read all bytes from the response.
			int bytesRead;
			byte[] buffer = new byte[1024];
			while ((bytesRead = is.read(buffer, 0, buffer.length)) != 0) {
				baos.write(buffer, 0, bytesRead);
			}
			
			// Convert the response to a string.
			String responseStr = baos.toString();
			Log.d(TAG, String.format("Response received from server: %s",
					responseStr));
			
			// ...and now to a JSON object.
			mResponseObject = new JSONObject(responseStr);
			
			// Call the callback method.
			translate(mResponseObject);
		} catch (IOException e) {
			Log.e(TAG, "Error in sending/receiving request.", e);
		} catch (JSONException e) {
			Log.e(TAG, "Error in converting response to a JSON object", e);
		}
	}
	
	/**
	 * Builds the URL for the request.
	 * @return the URL for the request.
	 */
	private String buildUrl() {
		return String.format("%s%s%s", 
				HOST, 
				getBasePath(), 
				getQueryParameters().toString());
	}
}
