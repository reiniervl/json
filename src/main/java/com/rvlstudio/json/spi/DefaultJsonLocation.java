package com.rvlstudio.json.spi;

import com.rvlstudio.json.JsonLocation;

class DefaultJsonLocation implements JsonLocation {
	private int line, column, offset;

	public DefaultJsonLocation(int line, int column, int offset) {
		this.line = line;
		this.column = column;
		this.offset = offset;
	}

	@Override
	public long getColumnNumber() {
		return column;
	}

	@Override
	public long getLineNumber() {
		return line;
	}

	@Override
	public long getStreamOffset() {
		return offset;
	}
}
