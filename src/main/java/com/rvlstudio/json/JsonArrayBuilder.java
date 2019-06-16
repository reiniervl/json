package com.rvlstudio.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonArrayBuilder {
	JsonArrayBuilder add(BigDecimal value);

	JsonArrayBuilder add(BigInteger value);

	JsonArrayBuilder add(boolean value);

	JsonArrayBuilder add(double value);

	JsonArrayBuilder add(int value);

	JsonArrayBuilder add(JsonArrayBuilder builder);

	JsonArrayBuilder add(JsonObjectBuilder builder);

	JsonArrayBuilder add(JsonValue value);

	JsonArrayBuilder add(long value);

	JsonArrayBuilder add(java.lang.String value);

	JsonArrayBuilder addNull();

	JsonArray build();
}
