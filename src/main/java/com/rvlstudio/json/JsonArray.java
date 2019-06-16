package com.rvlstudio.json;

import java.util.List;

public interface JsonArray extends JsonStructure, List<JsonValue> {
	boolean getBoolean(int index);

	boolean getBoolean(int index, boolean defaultValue);

	int getInt(int index);

	int getInt(int index, int defaultValue);

	JsonArray getJsonArray(int index);

	JsonNumber getJsonNumber(int index);

	JsonObject getJsonObject(int index);

	JsonString getJsonString(int index);

	java.lang.String getString(int index);

	String getString(int index, String defaultValue);

	<T extends JsonValue> List<T> getValuesAs(Class<T> clazz);

	boolean isNull(int index);
}
