package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonNumber;

import java.math.BigDecimal;
import java.math.BigInteger;

class DefaultJsonNumber implements JsonNumber {
	private BigDecimal number;

	public DefaultJsonNumber(int number) {
		this.number = new BigDecimal(number);
	}

	public DefaultJsonNumber(long number) {
		this.number = new BigDecimal(number);
	}

	public DefaultJsonNumber(double number) {
		this.number = new BigDecimal(number);
	}

	public DefaultJsonNumber(BigDecimal number) {
		this.number = number;
	}

	public DefaultJsonNumber(BigInteger number) {
		this.number = new BigDecimal(number);
	}

	public DefaultJsonNumber(JsonNumber number) {
		this.number = number.bigDecimalValue();
	}

	@Override
	public BigDecimal bigDecimalValue() {
		return number;
	}

	@Override
	public BigInteger bigIntegerValue() {
		return number.toBigInteger();
	}

	@Override
	public BigInteger bigIntegerValueExact() {
		return number.toBigIntegerExact();
	}

	@Override
	public double doubleValue() {
		return number.doubleValue();
	}

	@Override
	public int intValue() {
		return number.intValue();
	}

	@Override
	public int intValueExact() {
		return number.intValueExact();
	}

	@Override
	public boolean isIntegral() {
		return false;
	}

	@Override
	public long longValue() {
		return number.longValue();
	}

	@Override
	public long longValueExact() {
		return number.longValueExact();
	}

	@Override
	public ValueType getValueType() {
		return ValueType.NUMBER;
	}

	@Override
	public String toString() { return number.toString(); }
}
