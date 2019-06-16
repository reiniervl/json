package com.rvlstudio.json.spi;

import com.rvlstudio.json.*;

import java.util.*;
import java.util.function.UnaryOperator;

class DefaultJsonArray implements JsonArray {
	private List<JsonValue> values;

	public DefaultJsonArray() {
		values = new ArrayList<>();
	}

	public DefaultJsonArray(JsonArray array) {
		this.values = array.subList(0, array.size());
	}
	@Override
	public boolean getBoolean(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.TRUE || val.getValueType() == ValueType.TRUE) {
			return values.get(index).getValueType() == ValueType.TRUE;
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public boolean getBoolean(int index, boolean defaultValue) {
		if(index < size() && (values.get(index).getValueType() == ValueType.TRUE || values.get(index).getValueType() == ValueType.TRUE)) {
			return values.get(index).getValueType() == ValueType.TRUE;
		} else {
			return defaultValue;
		}
	}

	@Override
	public int getInt(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.NUMBER) {
			return ((JsonNumber)val).intValue();
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public int getInt(int index, int defaultValue) {
		if(index < values.size() && values.get(index).getValueType() == ValueType.NUMBER) {
			return ((JsonNumber)values.get(index)).intValue();
		} else {
			return defaultValue;
		}
	}

	@Override
	public JsonArray getJsonArray(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.ARRAY) {
			return (JsonArray) val;
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public JsonNumber getJsonNumber(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.NUMBER) {
			return (JsonNumber) val;
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public JsonObject getJsonObject(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.OBJECT) {
			return (JsonObject) val;
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public JsonString getJsonString(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.STRING) {
			return (JsonString) val;
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public String getString(int index) {
		JsonValue val = values.get(index);
		if(val.getValueType() == ValueType.STRING) {
			return ((JsonString) val).getString();
		} else {
			throw new ClassCastException();
		}
	}

	@Override
	public String getString(int index, String defaultValue) {
		if(index < values.size() && values.get(index).getValueType() == ValueType.STRING) {
			return ((JsonString) values.get(index)).getString();
		} else {
			return defaultValue;
		}
	}

	@Override
	public <T extends JsonValue> List<T> getValuesAs(Class<T> clazz) {
		return Arrays.asList(values.toArray((T[]) values.toArray()));
	}

	@Override
	public boolean isNull(int index) {
		return values.get(index).getValueType() == ValueType.NULL;
	}

	@Override
	public ValueType getValueType() {
		return ValueType.ARRAY;
	}

	// List
	@Override
	public int size() {
		return values.size();
	}

	@Override
	public boolean isEmpty() {
		return values.isEmpty();
	}

	@Override
	public boolean contains(Object o) {
		return values.contains(o);
	}

	@Override
	public Iterator<JsonValue> iterator() {
		return values.iterator();
	}

	@Override
	public Object[] toArray() {
		return values.toArray();
	}

	@Override
	public <T> T[] toArray(T[] ts) {
		return values.toArray(ts);
	}

	@Override
	public boolean add(JsonValue jsonValue) {
		return values.add(jsonValue);
	}

	@Override
	public boolean remove(Object o) {
		return values.remove(o);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return values.containsAll(collection);
	}

	@Override
	public boolean addAll(Collection<? extends JsonValue> collection) {
		return values.addAll(collection);
	}

	@Override
	public boolean addAll(int i, Collection<? extends JsonValue> collection) {
		return values.addAll(collection);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return values.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return removeAll(collection);
	}

	@Override
	public void replaceAll(UnaryOperator<JsonValue> operator) {
		values.replaceAll(operator);
	}

	@Override
	public void sort(Comparator<? super JsonValue> c) {
		values.sort(c);
	}

	@Override
	public void clear() {
		values.clear();
	}

	@Override
	public JsonValue get(int i) {
		return values.get(i);
	}

	@Override
	public JsonValue set(int i, JsonValue jsonValue) {
		return values.set(i, jsonValue);
	}

	@Override
	public void add(int i, JsonValue jsonValue) {
		values.add(i, jsonValue);
	}

	@Override
	public JsonValue remove(int i) {
		return values.remove(i);
	}

	@Override
	public int indexOf(Object o) {
		return values.indexOf(o);
	}

	@Override
	public int lastIndexOf(Object o) {
		return values.lastIndexOf(o);
	}

	@Override
	public ListIterator<JsonValue> listIterator() {
		return values.listIterator();
	}

	@Override
	public ListIterator<JsonValue> listIterator(int i) {
		return values.listIterator(i);
	}

	@Override
	public List<JsonValue> subList(int i, int i1) {
		return values.subList(i, i1);
	}

	@Override
	public Spliterator<JsonValue> spliterator() {
		return values.spliterator();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("[");
		for(JsonValue value : values) {
			sb.append(value.toString());
			sb.append(", ");
		}
		sb.replace(sb.length() - 2, sb.length(), "");
		sb.append("]");
		return sb.toString();
	}
}
