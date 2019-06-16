package com.rvlstudio.json;

import java.math.BigDecimal;

public interface JsonParser extends AutoCloseable {
	void close();

	BigDecimal getBigDecimal();

	int getInt();

	JsonLocation getLocation();

	long getLong();

	String getString();

	boolean hasNext();

	boolean isIntegralNumber();

	JsonParser.Event next();

enum Event {
		END_ARRAY,
		END_OBJECT,
		KEY_NAME,
		START_ARRAY,
		START_OBJECT,
		VALUE_FALSE,
		VALUE_NULL,
		VALUE_NUMBER,
		VALUE_STRING,
		VALUE_TRUE;
	}
}
