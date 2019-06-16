package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonLocation;

class JsonToken {
	private String value;
	private TokenType type;
	private JsonLocation location;

	JsonToken(String value, JsonLocation location) {
		this.value = value;
		this.type = TokenType.ofString(value);
		this.location = location;
	}

	public String getValue() {
		return value;
	}

	public TokenType getType() {
		return type;
	}

	public JsonLocation getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return String.format("%s\t-> %s @ %d:%d", type, value, location.getLineNumber(), location.getColumnNumber());
	}

	public enum TokenType {
		START_OBJECT,
		END_OBJECT,
		START_ARRAY,
		END_ARRAY,
		KEY,
		STRING,
		NUMBER,
		TRUE,
		FALSE,
		NULL,
		NAME_SEPARATOR,
		VALUE_SEPARATOR,
		UNKNOWN;

		static TokenType ofString(String value) {
			TokenType type;

			switch (value) {
				case "{":
					type = START_OBJECT;
					break;
				case "[":
					type = START_ARRAY;
					break;
				case "}":
					type = END_OBJECT;
					break;
				case "]":
					type = END_ARRAY;
					break;
				case ",":
					type = VALUE_SEPARATOR;
					break;
				case ":":
					type = NAME_SEPARATOR;
					break;
				default:
					type = ofPattern(value);
					break;
			}
			return type;
		}

		private static TokenType ofPattern(String value) {
			TokenType type;
			if(value.matches("(?i:true)")) {
				type = TRUE;
			} else if(value.matches("(?i:false)")) {
				type = FALSE;
			} else if(value.matches("(?i:null)")) {
				type = NULL;
			} else if(value.matches("\"((\\\")|[^\"(\\\")])+\"")) {
				type = STRING;
			} else if(value.matches("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?")) {
				type = NUMBER;
			} else {
				type = UNKNOWN;
			}
			return type;
		}
	}
}
