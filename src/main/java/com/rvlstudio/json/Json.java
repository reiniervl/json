package com.rvlstudio.json;

import com.rvlstudio.json.spi.JsonProvider;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class Json {
	public static JsonArrayBuilder createArrayBuilder() {
		return JsonProvider.provider().createArrayBuilder();
	}

	public static JsonBuilderFactory createBuilderFactory(java.util.Map<java.lang.String, ?> config) {
		throw new NotImplementedException();
	}

	public static JsonGenerator createGenerator(java.io.OutputStream out) {
		throw new NotImplementedException();
	}

	public static JsonGenerator createGenerator(java.io.Writer writer) {
		throw new NotImplementedException();
	}

	public static JsonGeneratorFactory createGeneratorFactory(java.util.Map<java.lang.String, ?> config) {
		throw new NotImplementedException();
	}

	public static JsonObjectBuilder createObjectBuilder() {
		return JsonProvider.provider().createObjectBuilder();
	}

	public static JsonParser createParser(java.io.InputStream in) {
		throw new NotImplementedException();
	}

	public static JsonParser createParser(java.io.Reader reader) {
		return JsonProvider.provider().createParser(reader);
	}

	public static JsonParserFactory createParserFactory(java.util.Map<java.lang.String, ?> config) {
		throw new NotImplementedException();
	}

	public static JsonReader createReader(java.io.InputStream in) {
		throw new NotImplementedException();
	}

	public static JsonReader createReader(java.io.Reader reader) {
		throw new NotImplementedException();
	}

	public static JsonReaderFactory createReaderFactory(java.util.Map<java.lang.String, ?> config) {
		throw new NotImplementedException();
	}

	public static JsonWriter createWriter(java.io.OutputStream out) {
		throw new NotImplementedException();
	}

	public static JsonWriter createWriter(java.io.Writer writer) {
		throw new NotImplementedException();
	}

	public static JsonWriterFactory createWriterFactory(java.util.Map<java.lang.String, ?> config) {
		throw new NotImplementedException();
	}
}
