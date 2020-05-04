package ru.hse.todo.outputs;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import ru.hse.todo.Output;
import ru.hse.todo.Todo;

/**
 * Single-use only {@link Output} for printing detailed {@link Todo} information
 * to standard output. Use {@link #printDetails()} when all data has been
 * provided.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class DetailTodoOutput implements Output {
	private boolean ready = false;
	private String name;
	private String descrition;
	private ZonedDateTime due;
	private final DateTimeFormatter formatter;

	/**
	 * @param formatter
	 */
	public DetailTodoOutput(DateTimeFormatter formatter) {
		this.formatter = formatter;
	}

	@Override
	public Output writeHeader(String header) {
		if (this.ready) {
			throw new IllegalStateException(
					"Output already has enogh data to print the Todo. No writeXXX invocations are allowed now.");
		}
		return this;
	}

	@Override
	public Output writePart(String name, String value) {
		if (this.ready) {
			throw new IllegalStateException(
					"Output already has enogh data to print the Todo. No writeXXX invocations are allowed now.");
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
			this.due = LocalDateTime.parse(value, this.formatter).atZone(ZoneId.systemDefault());
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

	public void printDetails() {
		if (this.ready) {
			System.out.println("Name: " + this.name);
			System.out.println("Description: " + this.descrition);
			System.out.println("Due to: " + formatter.format(this.due.toLocalDateTime()));
		} else {
			throw new IllegalStateException("Output doesn't have enogh data to print the Todo.");
		}
	}
}
