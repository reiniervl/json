package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonArrayBuilder;
import com.rvlstudio.json.JsonObject;
import com.rvlstudio.json.JsonObjectBuilder;
import com.rvlstudio.json.JsonValue;

import java.math.BigDecimal;
import java.math.BigInteger;

class DefaultJsonObjectBuilder implements JsonObjectBuilder {
	private DefaultJsonObject object = new DefaultJsonObject();

	@Override
	public JsonObjectBuilder add(String name, BigDecimal value) {
		object.put(name, new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, BigInteger value) {
		object.put(name, new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, boolean value) {
		return null;
	}

	@Override
	public JsonObjectBuilder add(String name, double value) {
		object.put(name, new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, int value) {
		object.put(name, new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, JsonArrayBuilder builder) {
		object.put(name, new DefaultJsonArray(builder.build()));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, JsonObjectBuilder builder) {
		object.put(name, new DefaultJsonObject(builder.build()));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, JsonValue value) {
		object.put(name, value);
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, long value) {
		object.put(name, new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonObjectBuilder add(String name, String value) {
		object.put(name, new DefaultJsonString(value));
		return this;
	}

	@Override
	public JsonObjectBuilder addNull(String name) {
		object.put(name, JsonValue.NULL);
		return this;
	}

	@Override
	public JsonObject build() {
		return this.object;
	}
}
