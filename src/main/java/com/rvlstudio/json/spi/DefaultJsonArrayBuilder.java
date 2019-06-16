package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonArray;
import com.rvlstudio.json.JsonArrayBuilder;
import com.rvlstudio.json.JsonObjectBuilder;
import com.rvlstudio.json.JsonValue;

import java.math.BigDecimal;
import java.math.BigInteger;

class DefaultJsonArrayBuilder implements JsonArrayBuilder {
	private DefaultJsonArray array = new DefaultJsonArray();

	@Override
	public JsonArrayBuilder add(BigDecimal value) {
		array.add(new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonArrayBuilder add(BigInteger value) {
		array.add(new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonArrayBuilder add(boolean value) {
		if(value) array.add(JsonValue.TRUE);
		else array.add(JsonValue.FALSE);
		return this;
	}

	@Override
	public JsonArrayBuilder add(double value) {
		array.add(new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonArrayBuilder add(int value) {
		array.add(new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonArrayBuilder add(JsonArrayBuilder builder) {
		array.add(new DefaultJsonArray(builder.build()));
		return this;
	}

	@Override
	public JsonArrayBuilder add(JsonObjectBuilder builder) {
		array.add(new DefaultJsonObject(builder.build()));
		return this;
	}

	@Override
	public JsonArrayBuilder add(JsonValue value) {
		array.add(value);
		return this;
	}

	@Override
	public JsonArrayBuilder add(long value) {
		array.add(new DefaultJsonNumber(value));
		return this;
	}

	@Override
	public JsonArrayBuilder add(String value) {
		array.add(new DefaultJsonString(value));
		return this;
	}

	@Override
	public JsonArrayBuilder addNull() {
		array.add(JsonValue.NULL);
		return this;
	}

	@Override
	public JsonArray build() {
		return this.array;
	}
}
