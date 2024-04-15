package com.rapidai.jsonhandler;

import java.io.FileReader;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonProcessor {

	public String getTestData(String testCaseName, String key) throws Exception {
		String data = null;
		FileReader reader = new FileReader(System.getProperty("user.dir") + "/src/main/resources/testdata.json");

		// Parse the JSON string into a JSONObject
		JSONObject jsonObject = new JSONObject(reader);

		// Retrieve the JSONArray for "verify_login_using_valid_username_and_password"
		JSONArray jsonArray = jsonObject.getJSONArray(testCaseName);

		// Iterate through the JSONArray
		for (int i = 0; i < jsonArray.length(); i++) {
			// Get the JSONObject at index i
			JSONObject loginObject = jsonArray.getJSONObject(i);

			// Retrieve values
			data = loginObject.getString(key);

		}
		return data;
	}

}
