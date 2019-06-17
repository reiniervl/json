package com.rvlstudio.json.spi;

import com.rvlstudio.json.stream.JsonLocation;
import com.rvlstudio.json.stream.JsonParser;

import java.io.*;
import java.math.BigDecimal;

class DefaultJsonParser implements JsonParser {
	JsonLexer lexer;

	DefaultJsonParser(InputStream in) {
		this(new InputStreamReader(in));
	}

	DefaultJsonParser(Reader reader) {
		lexer = new JsonLexer(reader);
	}

	@Override
	public void close() {
		lexer.close();
	}

	@Override
	public BigDecimal getBigDecimal() {
		return null;
	}

	@Override
	public int getInt() {
		return 0;
	}

	@Override
	public JsonLocation getLocation() {
		return null;
	}

	@Override
	public long getLong() {
		return 0;
	}

	@Override
	public String getString() {
		return null;
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public boolean isIntegralNumber() {
		return false;
	}

	@Override
	public Event next() {
		return lexer.next();
	}
}
