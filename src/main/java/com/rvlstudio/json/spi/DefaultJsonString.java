package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonString;

class DefaultJsonString implements JsonString {
	private String string;

	public DefaultJsonString(String string) {
		this.string = string;
	}

	@Override
	public CharSequence getChars() {
		return string.subSequence(0, string.length() - 1);
	}

	@Override
	public String getString() {
		return string;
	}

	@Override
	public ValueType getValueType() {
		return ValueType.STRING;
	}

	@Override
	public String toString() {
		return string;
	}
}
