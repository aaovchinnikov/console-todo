package ru.hse.todo.todos;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import ru.hse.todo.Output;
import ru.hse.todo.Todo;

public class SimpleTodo implements Todo {
	private final String name;
	private final String descrition;
	private final ZonedDateTime due;
	/**
	 * @param name
	 * @param descrition
	 * @param dueDateTime
	 */
	public SimpleTodo(String name, String descrition, ZonedDateTime due) {
		this.name = name;
		this.descrition = descrition;
		this.due= due;
	}
	
	@Override
	public void print(Output output) {
		// TODO inject formatter
		final DateTimeFormatter yyyy_MM_dd_HH_mm = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
		output.writeHeader("todo")
			.writePart("name", this.name)
			.writePart("descrition", this.descrition)
			.writePart("due", yyyy_MM_dd_HH_mm.format(this.due.toLocalDateTime()))
			.writeTrailer("todo");
	}
}
