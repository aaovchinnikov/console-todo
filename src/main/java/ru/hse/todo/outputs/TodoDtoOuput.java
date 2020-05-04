package ru.hse.todo.outputs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import ru.hse.todo.Output;
import ru.hse.todo.Todo;
import ru.hse.todo.todos.SimpleTodo;

/**
 * Single-use only {@link Output} for building in-memory {@link Todo}.
 * @author Alexander Ovchinnikov
 *
 */
public final class TodoDtoOuput implements Output {
	private boolean ready = false;
	private String name;
	private String descrition;
	private ZonedDateTime due;
	// TODO inject formatter
	private final DateTimeFormatter yyyy_MM_dd_HH_mm = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");

	@Override
	public Output writeHeader(String header) {
		if (this.ready) {
			throw new IllegalStateException(
					"Todo already has enogh data to be built. No writeXXX invocations are allowed now.");
		}
		return this;
	}

	@Override
	public Output writePart(String name, String value) {
		if (this.ready) {
			throw new IllegalStateException(
					"Todo already has enogh data to be built. No writeXXX invocations are allowed now.");
		}
		switch (name) {
		case "name": {
			this.name = value;
			return this;
		}
		case "descrition": {
			this.descrition = value;
			return this;
		}
		case "due": {
			this.due = LocalDateTime.parse(value, yyyy_MM_dd_HH_mm).atZone(ZoneId.systemDefault());
			return this;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + name);
		}
	}

	@Override
	public void writeTrailer(String trailer) {
		this.ready = true;
	}

	public Todo build() {
		if (this.ready) {
			return new SimpleTodo(name, descrition, due);
		} else {
			throw new IllegalStateException("Todo has not enogh data to be built.");
		}
	}
}
