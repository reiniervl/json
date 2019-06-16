package com.rvlstudio.json;

public interface JsonString extends JsonValue {
	boolean	equals(Object obj);
	java.lang.CharSequence getChars();
	java.lang.String getString();
	int	hashCode();
}
