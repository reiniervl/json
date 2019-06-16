package com.rvlstudio.json;

import java.util.Map;

public interface JsonObject extends JsonStructure, Map<String, JsonValue> {
	boolean getBoolean(java.lang.String name);

	boolean getBoolean(java.lang.String name, boolean defaultValue);

	int getInt(java.lang.String name);

	int getInt(java.lang.String name, int defaultValue);

	JsonArray getJsonArray(java.lang.String name);

	JsonNumber getJsonNumber(java.lang.String name);

	JsonObject getJsonObject(java.lang.String name);

	JsonString getJsonString(java.lang.String name);

	java.lang.String getString(java.lang.String name);

	java.lang.String getString(java.lang.String name, java.lang.String defaultValue);

	boolean isNull(java.lang.String name);
}
