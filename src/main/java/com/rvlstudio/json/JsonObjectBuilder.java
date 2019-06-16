package com.rvlstudio.json;

public interface JsonObjectBuilder {
	JsonObjectBuilder add(java.lang.String name, java.math.BigDecimal value);
	JsonObjectBuilder add(java.lang.String name, java.math.BigInteger value);
	JsonObjectBuilder add(java.lang.String name, boolean value);
	JsonObjectBuilder add(java.lang.String name, double value);
	JsonObjectBuilder add(java.lang.String name, int value);
	JsonObjectBuilder add(java.lang.String name, JsonArrayBuilder builder);
	JsonObjectBuilder add(java.lang.String name, JsonObjectBuilder builder);
	JsonObjectBuilder add(java.lang.String name, JsonValue value);
	JsonObjectBuilder add(java.lang.String name, long value);
	JsonObjectBuilder add(java.lang.String name, java.lang.String value);
	JsonObjectBuilder addNull(java.lang.String name);
	JsonObject build();
}
