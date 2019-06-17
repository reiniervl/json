package com.rvlstudio.json.spi;

import com.rvlstudio.json.*;
import com.rvlstudio.json.stream.JsonGenerator;
import com.rvlstudio.json.stream.JsonGeneratorFactory;
import com.rvlstudio.json.stream.JsonParser;
import com.rvlstudio.json.stream.JsonParserFactory;

public abstract class JsonProvider {
	private static JsonProvider provider = new DefaultJsonProvider();

	public abstract JsonArrayBuilder createArrayBuilder();

	public abstract JsonBuilderFactory createBuilderFactory(java.util.Map<java.lang.String, ?> config);

	public abstract JsonGenerator createGenerator(java.io.OutputStream out);

	public abstract JsonGenerator createGenerator(java.io.Writer writer);

	public abstract JsonGeneratorFactory createGeneratorFactory(java.util.Map<java.lang.String, ?> config);

	public abstract JsonObjectBuilder createObjectBuilder();

	public abstract JsonParser createParser(java.io.InputStream in);

	public abstract JsonParser createParser(java.io.Reader reader);

	public abstract JsonParserFactory createParserFactory(java.util.Map<java.lang.String, ?> config);

	public abstract JsonReader createReader(java.io.InputStream in);

	public abstract JsonReader createReader(java.io.Reader reader);

	public abstract JsonReaderFactory createReaderFactory(java.util.Map<java.lang.String, ?> config);

	public abstract JsonWriter createWriter(java.io.OutputStream out);

	public abstract JsonWriter createWriter(java.io.Writer writer);

	public abstract JsonWriterFactory createWriterFactory(java.util.Map<java.lang.String, ?> config);

	public static JsonProvider provider() {
		return provider;
	}
}
