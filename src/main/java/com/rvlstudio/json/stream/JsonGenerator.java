package com.rvlstudio.json.stream;

import com.rvlstudio.json.JsonValue;

public interface JsonGenerator {
	void close();

	void flush();

	JsonGenerator write(java.math.BigDecimal value);

	JsonGenerator write(java.math.BigInteger value);

	JsonGenerator write(boolean value);

	JsonGenerator write(double value);

	JsonGenerator write(int value);

	JsonGenerator write(JsonValue value);

	JsonGenerator write(long value);

	JsonGenerator write(java.lang.String value);

	JsonGenerator write(java.lang.String name, java.math.BigDecimal value);

	JsonGenerator write(java.lang.String name, java.math.BigInteger value);

	JsonGenerator write(java.lang.String name, boolean value);

	JsonGenerator write(java.lang.String name, double value);

	JsonGenerator write(java.lang.String name, int value);

	JsonGenerator write(java.lang.String name, JsonValue value);

	JsonGenerator write(java.lang.String name, long value);

	JsonGenerator write(java.lang.String name, java.lang.String value);

	JsonGenerator writeEnd();

	JsonGenerator writeNull();

	JsonGenerator writeNull(java.lang.String name);

	JsonGenerator writeStartArray();

	JsonGenerator writeStartArray(java.lang.String name);

	JsonGenerator writeStartObject();

	JsonGenerator writeStartObject(java.lang.String name);
}
