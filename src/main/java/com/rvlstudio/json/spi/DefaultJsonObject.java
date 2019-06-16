package com.rvlstudio.json.spi;

import com.rvlstudio.json.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class DefaultJsonObject implements JsonObject {
	private HashMap<String, JsonValue> object;

	public DefaultJsonObject() {
		this.object = new HashMap<>();
	}

	public DefaultJsonObject(JsonObject object) {
		this();
		for(Map.Entry<String, JsonValue> entry : object.entrySet()) {
			this.object.put(entry.getKey(), entry.getValue());
		}
	}

	@Override
	public boolean getBoolean(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.TRUE || value.getValueType() == ValueType.FALSE) {
				return value.getValueType() == ValueType.TRUE;
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public boolean getBoolean(String name, boolean defaultValue) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.TRUE || value.getValueType() == ValueType.FALSE) {
				return value.getValueType() == ValueType.TRUE;
			}
		}
		return defaultValue;
	}

	@Override
	public int getInt(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.NUMBER) {
				return ((JsonNumber)value).intValue();
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public int getInt(String name, int defaultValue) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.NUMBER) {
				return ((JsonNumber)value).intValue();
			}
		}
		return defaultValue;
	}

	@Override
	public JsonArray getJsonArray(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.ARRAY) {
				return (JsonArray) value;
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public JsonNumber getJsonNumber(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.NUMBER) {
				return (JsonNumber) value;
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public JsonObject getJsonObject(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.OBJECT) {
				return (JsonObject) value;
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public JsonString getJsonString(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.STRING) {
				return (JsonString) value;
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public String getString(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.STRING) {
				return ((JsonString) value).getString();
			} else {
				throw new ClassCastException();
			}
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public String getString(String name, String defaultValue) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			if (value.getValueType() == ValueType.STRING) {
				return ((JsonString) value).getString();
			}
		}
		return defaultValue;
	}

	@Override
	public boolean isNull(String name) {
		if(object.containsKey(name)) {
			JsonValue value = object.get(name);
			return (value.getValueType() == ValueType.NULL);
		} else {
			throw new NullPointerException(String.format("JsonValue '%s' is not present", name));
		}
	}

	@Override
	public ValueType getValueType() {
		return ValueType.OBJECT;
	}

	// Map
	@Override
	public int size() {
		return object.size();
	}

	@Override
	public boolean isEmpty() {
		return object.isEmpty();
	}

	@Override
	public boolean containsKey(Object o) {
		return object.containsKey(o);
	}

	@Override
	public boolean containsValue(Object o) {
		return object.containsValue(o);
	}

	@Override
	public JsonValue get(Object o) {
		return object.get(o);
	}

	@Override
	public JsonValue put(String s, JsonValue jsonValue) {
		return object.put(s, jsonValue);
	}

	@Override
	public JsonValue remove(Object o) {
		return object.remove(o);
	}

	@Override
	public void putAll(Map<? extends String, ? extends JsonValue> map) {
		object.putAll(map);
	}

	@Override
	public void clear() {
		object.clear();
	}

	@Override
	public Set<String> keySet() {
		return object.keySet();
	}

	@Override
	public Collection<JsonValue> values() {
		return object.values();
	}

	@Override
	public Set<Entry<String, JsonValue>> entrySet() {
		return object.entrySet();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("{ ");
		for(Map.Entry<String, JsonValue> entry : object.entrySet()) {
			sb.append(entry.getKey())
					.append(": ")
					.append(entry.getValue().toString())
					.append(", ");
		}
		sb.replace(sb.length() - 2, sb.length() - 1, "");
		sb.append("}");
		return sb.toString();
	}
}
