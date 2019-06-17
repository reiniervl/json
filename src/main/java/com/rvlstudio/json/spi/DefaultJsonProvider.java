package com.rvlstudio.json.spi;

import com.rvlstudio.json.*;
import com.rvlstudio.json.stream.JsonGenerator;
import com.rvlstudio.json.stream.JsonGeneratorFactory;
import com.rvlstudio.json.stream.JsonParser;
import com.rvlstudio.json.stream.JsonParserFactory;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

class DefaultJsonProvider extends JsonProvider {

	@Override
	public JsonArrayBuilder createArrayBuilder() {
		return new DefaultJsonArrayBuilder();
	}

	@Override
	public JsonBuilderFactory createBuilderFactory(Map<String, ?> config) {
		return null;
	}

	@Override
	public JsonGenerator createGenerator(OutputStream out) {
		return null;
	}

	@Override
	public JsonGenerator createGenerator(Writer writer) {
		return null;
	}

	@Override
	public JsonGeneratorFactory createGeneratorFactory(Map<String, ?> config) {
		return null;
	}

	@Override
	public JsonObjectBuilder createObjectBuilder() {
		return new DefaultJsonObjectBuilder();
	}

	@Override
	public JsonParser createParser(InputStream in) {
		return new DefaultJsonParser(in);
	}

	@Override
	public JsonParser createParser(Reader reader) {
		return new DefaultJsonParser(reader);
	}

	@Override
	public JsonParserFactory createParserFactory(Map<String, ?> config) {
		return null;
	}

	@Override
	public JsonReader createReader(InputStream in) {
		return null;
	}

	@Override
	public JsonReader createReader(Reader reader) {
		return null;
	}

	@Override
	public JsonReaderFactory createReaderFactory(Map<String, ?> config) {
		return null;
	}

	@Override
	public JsonWriter createWriter(OutputStream out) {
		return null;
	}

	@Override
	public JsonWriter createWriter(Writer writer) {
		return null;
	}

	@Override
	public JsonWriterFactory createWriterFactory(Map<String, ?> config) {
		return null;
	}
}
