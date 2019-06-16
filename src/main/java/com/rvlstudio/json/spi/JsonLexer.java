package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonParser;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

class JsonLexer implements Iterator<JsonParser.Event> {
	private LocationReader reader;
	private List<JsonToken> tokens;
	private int index = -1;
	private boolean isKey = true;

	public JsonLexer(Reader reader) {
		this.reader = new LocationReader(reader);
		this.tokens = this.reader.getTokens();
	}

	public void close() {
		try{
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void scan() {
		for(JsonToken token : reader.getTokens()) {
			System.out.println(token);
		}
	}

	@Override
	public boolean hasNext() {
		return index < tokens.size();
	}

	@Override
	public JsonParser.Event next() {
		
	}
}