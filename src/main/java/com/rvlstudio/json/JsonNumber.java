package com.rvlstudio.json;

import java.math.BigDecimal;
import java.math.BigInteger;

public interface JsonNumber extends JsonValue {
	BigDecimal bigDecimalValue();

	BigInteger bigIntegerValue();

	BigInteger bigIntegerValueExact();

	double doubleValue();

	boolean equals(Object obj);

	int hashCode();

	int intValue();

	int intValueExact();

	boolean isIntegral();

	long longValue();

	long longValueExact();

	String toString();
}
