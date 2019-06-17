package com.rvlstudio.json.stream;

import com.rvlstudio.json.JsonException;

public class JsonParsingException extends JsonException {
	public JsonParsingException(String message, JsonLocation location) {
		super(String.format("%s @%d:%d", message, location.getLineNumber(), location.getColumnNumber()));
	}

	public JsonParsingException(String message, Throwable cause, JsonLocation location) {
		super(String.format("%s @%s", message, location), cause);
	}
}
