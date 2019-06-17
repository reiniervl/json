package com.rvlstudio.json.spi;

import com.rvlstudio.json.stream.JsonLocation;
import com.rvlstudio.json.stream.JsonParser;

import java.util.Optional;

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
		START_OBJECT(KeyName, JsonParser.Event.START_OBJECT),
		END_OBJECT(End, JsonParser.Event.END_OBJECT),
		START_ARRAY(Value, JsonParser.Event.START_ARRAY),
		END_ARRAY(End, JsonParser.Event.END_ARRAY),
		STRING(End.or(NameSeperator), JsonParser.Event.VALUE_STRING),
		NUMBER(End, JsonParser.Event.VALUE_NUMBER),
		TRUE(End, JsonParser.Event.VALUE_TRUE),
		FALSE(End, JsonParser.Event.VALUE_FALSE),
		NULL(End, JsonParser.Event.VALUE_NULL),
		NAME_SEPARATOR(Value, null),
		VALUE_SEPARATOR(KeyName.or(Value), null),
		UNKNOWN(null, null);

		private Expected next;

		private JsonParser.Event event;

		public Expected getNext() {
			return next;
		}

		public Optional<JsonParser.Event> getEvent() {
			return Optional.ofNullable(event);
		}

		TokenType(Expected expected, JsonParser.Event event) {
			this.next = expected;
			this.event = event;
		}

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
			if (value.matches("(?i:true)")) {
				type = TRUE;
			} else if (value.matches("(?i:false)")) {
				type = FALSE;
			} else if (value.matches("(?i:null)")) {
				type = NULL;
			} else if (value.matches("\"((\\\")|[^\"(\\\")])+\"")) {
				type = STRING;
			} else if (value.matches("-?(?:0|[1-9]\\d*)(?:\\.\\d+)?(?:[eE][+-]?\\d+)?")) {
				type = NUMBER;
			} else {
				type = UNKNOWN;
			}
			return type;
		}
	}


	@FunctionalInterface
	interface Expected {
		boolean isExpected(JsonToken.TokenType type);

		default Expected or(Expected other) {
			return (t) -> isExpected(t) || other.isExpected(t);
		}
	}

	static final Expected ObjectStart = (t) -> t == TokenType.START_OBJECT;
	static final Expected KeyName = (t) -> t == TokenType.STRING;
	static final Expected Value = (t) -> t == TokenType.START_OBJECT ||
					t == TokenType.START_ARRAY ||
					t == TokenType.STRING ||
					t == TokenType.TRUE ||
					t == TokenType.FALSE ||
					t == TokenType.NULL ||
					t == TokenType.NUMBER;
	static final Expected ArrayEnd = (t) -> t == TokenType.END_ARRAY;
	static final Expected End = (t) -> t == TokenType.VALUE_SEPARATOR ||
					t == TokenType.END_OBJECT ||
					t == TokenType.END_ARRAY;
	static final Expected NameSeperator = (t) -> t == TokenType.NAME_SEPARATOR;
}