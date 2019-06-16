package com.rvlstudio.json;

public interface JsonValue {
	JsonValue.ValueType getValueType();

	String toString();

	public static JsonValue TRUE = new JsonValue() {
		@Override
		public ValueType getValueType() {
			return ValueType.TRUE;
		}

		@Override
		public String toString() {
			return ValueType.TRUE.toString();
		}
	};

	public static JsonValue FALSE = new JsonValue() {
		@Override
		public ValueType getValueType() {
			return ValueType.FALSE;
		}

		@Override
		public String toString() {
			return ValueType.FALSE.toString();
		}
	};

	public static JsonValue NULL = new JsonValue() {
		@Override
		public ValueType getValueType() {
			return ValueType.NULL;
		}

		@Override
		public String toString() {
			return ValueType.NULL.toString();
		}
	};

	public static enum ValueType {
		NULL("null"),
		TRUE("true"),
		FALSE("false"),
		STRING("string"),
		NUMBER("number"),
		ARRAY("array"),
		OBJECT("object");

		private String type;

		ValueType(String type) {
			this.type = type;
		}

		@Override
		public String toString() {
			return this.type;
		}
	}
}
