package com.rvlstudio.json.stream;

public interface JsonLocation {
	long	getColumnNumber();
	long	getLineNumber();
	long	getStreamOffset();
}
