package com.rvlstudio.json.spi;

import com.rvlstudio.json.stream.JsonParser;
import com.rvlstudio.json.stream.JsonParsingException;

import static com.rvlstudio.json.spi.JsonToken.*;
import static com.rvlstudio.json.stream.JsonParser.Event;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class JsonLexer implements Iterator<JsonParser.Event> {
	private LocationReader reader;
	private List<Event> events = new ArrayList<>();
	private int index = 0;

	JsonLexer(Reader reader) {
		this.reader = new LocationReader(reader);
		scan();
	}

	void close() {
		try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void scan() {
		Expected exp = ObjectStart;
		for (JsonToken token : reader.getTokens()) {
			if(exp.isExpected(token.getType())) {
				System.out.println(token);
				exp = token.getType().getNext();
				if(token.getType().getEvent().isPresent()) {
					events.add(token.getType().getEvent().get());
				}
			} else {
				throw new JsonParsingException(String.format("Unexpected character: %s, expected %s ", token.getValue(), token.getType().getNext()), token.getLocation());
			}
		}

		for(Event e : events) System.out.println(e);
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Event next() {
		if(index != 0) index++;
		return events.get(index);
	}
}