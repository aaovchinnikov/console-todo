package ru.hse.todo.todos;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import ru.hse.todo.Output;
import ru.hse.todo.Todo;

public final class SimpleTodo implements Todo {
	private final String name;
	private final String descrition;
	private final ZonedDateTime due;
	private final DateTimeFormatter formatter;
	/**
	 * @param name
	 * @param descrition
	 * @param dueDateTime
	 */
	public SimpleTodo(String name, String descrition, ZonedDateTime due, DateTimeFormatter formatter) {
		this.name = name;
		this.descrition = descrition;
		this.due= due;
		this.formatter = formatter;
	}
	
	@Override
	public void print(Output output) {
		output.writeHeader("todo")
			.writePart("name", this.name)
			.writePart("descrition", this.descrition)
			.writePart("due", this.formatter.format(this.due.toLocalDateTime()))
			.writeTrailer("todo");
	}
}
