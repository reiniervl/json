package com.rvlstudio.json.stream;

import com.rvlstudio.json.JsonException;

public class JsonGenerationException extends JsonException {
	public JsonGenerationException(String message) {
		super(message);
	}

	public JsonGenerationException(String message, Throwable cause) {
		super(message, cause);
	}
}
