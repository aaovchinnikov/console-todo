package ru.hse.todo;

public interface Todo {
	/**
	 * Supposed implementation is
	 * <pre>{@code
	 * Output print(Output output) {
	 *	return output.writeHeader("head")
	 * 		.writePart("name1", "value1")
	 * 		...
	 * 		.writePart("nameN", "valueN")
	 * 		.writeTrailer("trailer");
	 *}}</pre>
	 * 
	 * @param output
	 * @return
	 */
	Output print(Output output);
}
