package com.rvlstudio.json.spi;


import com.rvlstudio.json.JsonLocation;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

class LocationReader extends FilterReader {
	private Location location = new Location();
	private LinkedList<JsonToken> tokens = new LinkedList<>();

	public LocationReader(Reader reader) {
		super(reader);
		scan();
	}

	private void scan() {
		int c = -1;
		StringBuilder temp = new StringBuilder();
		boolean insz = false, escaped = false;
		try {
			while ((c = read()) != -1) {
				if(!insz && (c == 0x09 || c == 0x0A || c == 0x0D || c == 0x20)) {
					if(temp.length() > 0) {
						tokens.add(new JsonToken(temp.toString(), getLocation()));
						temp = new StringBuilder();
					}
					continue;
				}
				temp.append((char) c);
				switch(c) {
					case '\\':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\\");
						escaped = !escaped;
						break;
					case 'b':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\b");
						break;
					case 'f':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\f");
						break;
					case 'n':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\n");
						break;
					case 'r':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\r");
						break;
					case 't':
						if(escaped)	temp.replace(temp.length() - 1, temp.length(), "\t");
						break;
					case '"':
						if(insz && escaped) continue;
						if(insz) {
							tokens.add(new JsonToken(temp.toString(), getLocation()));
							temp = new StringBuilder();
							insz = false;
						} else {
							insz = true;
						}
						break;
					case '{':
					case '}':
					case '[':
					case ']':
					case ':':
					case ',':
						if(!insz) {
							if(temp.length() > 1) {
								tokens.add(new JsonToken(temp.substring(0, temp.length() - 1), getLocation()));
							}
							tokens.add(new JsonToken(Character.toString((char)c), getLocation()));
							temp = new StringBuilder();
						}
						break;
					default:
						break;
				}
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	private String readWhiteSpace() {
		return "";
	}

	public List<JsonToken> getTokens() {
		return tokens;
	}

	public JsonLocation getLocation() {
		return new Location(location);
	}

	/**
	 * Reads a single character.
	 *
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public int read() throws IOException {
		int c = super.read();
		location.updatePosition(c);
		return c;
	}

	/**
	 * Reads characters into a portion of an array.
	 *
	 * @param cbuf
	 * @param off
	 * @param len
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		int n = super.read(cbuf, off, len);
		for(char c : cbuf) location.updatePosition(c);
		return n;
	}

	/**
	 * Skips characters.
	 *
	 * @param n n
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public long skip(long n) throws IOException {
		return super.skip(n);
	}

	/**
	 * Tells whether this stream is ready to be read.
	 *
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public boolean ready() throws IOException {
		return super.ready();
	}

	/**
	 * Tells whether this stream supports the mark() operation.
	 */
	@Override
	public boolean markSupported() {
		return super.markSupported();
	}

	/**
	 * Marks the present position in the stream.
	 *
	 * @param readAheadLimit n to read ahead
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public void mark(int readAheadLimit) throws IOException {
		location.setMarked(true);
		super.mark(readAheadLimit);
	}

	/**
	 * Resets the stream.
	 *
	 * @throws IOException If an I/O error occurs
	 */
	@Override
	public void reset() throws IOException {
		location.setMarked(false);
		super.reset();
	}

	@Override
	public void close() throws IOException {
		super.close();
	}

	private class Location implements JsonLocation {
		private final int tabWidth = 4;
		private int line = 1, column, offset;
		private boolean mark = false;
		private boolean carriageReturn = false;

		Location() {}
		Location(Location location) {
			this.line = location.line;
			this.column = location.column;
			this.offset = location.offset;
		}

		void addLine() { addLine(1); }
		void addLine(int n) { line += n; column = 0; }

		void addColumn() { addColumn(1); }
		void addColumn(int n) { column += n; }

		void addOffset() { addOffset(1); }
		void addOffset(int n) { offset += n; }

		boolean isMarked() { return mark; }
		void setMarked(boolean mark) { this.mark = mark; }

		void updatePosition(int c) {
			if(isMarked()) return;
			if (carriageReturn && c != '\n') {
				line++;
				carriageReturn = false;
			}
			switch (c) {
				case '\r':
					carriageReturn = true;
					addOffset();
					addColumn();
					break;
				case '\n':
					addLine();
					carriageReturn = false;
					addOffset();
					addColumn();
					break;
				case '\t':
					addColumn(tabWidth);
					addOffset();
					addColumn();
					break;
				case -1:
					break;
				default:
					addOffset();
					addColumn();
					break;
			}
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
}
