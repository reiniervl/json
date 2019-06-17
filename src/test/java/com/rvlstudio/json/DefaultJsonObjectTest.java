package com.rvlstudio.json;

import com.rvlstudio.json.stream.JsonParser;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;

public class DefaultJsonObjectTest {
	@Test
	public void testCreation() {
		JsonObject o = Json.createObjectBuilder()
				.add("first", "first")
				.add("second", 2)
				.add("third", Json.createArrayBuilder()
						.add(1)
						.add("two")
						.add(true)
						.add(false)
						.add(JsonValue.NULL))
				.add("fourth", Json.createObjectBuilder()
					.add("f1", 6))
				.build();
		System.out.println(o.toString());
	}

	@Test
	public void testParser() {
		try {
			JsonParser parser = Json.createParser(new FileReader("/home/reinier/Projects/java/test.json"));
			parser.next();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}