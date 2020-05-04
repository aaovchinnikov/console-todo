package ru.hse.todo.console.options;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ru.hse.todo.TodoOrderedStorage;

public class AddTodoOption extends AbstarctOption {
	private final TodoOrderedStorage storage;
	private final Scanner scanner;
	private final String format;
	private final DateTimeFormatter formatter;
	
	/**
	 * @param storage
	 */
	public AddTodoOption(TodoOrderedStorage storage, Scanner scanner, String format, DateTimeFormatter formatter) {
		this.storage = storage;
		this.scanner = scanner;
		this.format = format;
		this.formatter = formatter;
	}

	@Override
	public void execute() {
		//TODO split reading of components to separate objects
		System.out.println();
		System.out.println("-------------- Add TODO ---------------");
		System.out.print("Type name for new TODO in one line and press 'Enter' key: ");
		final String name = this.scanner.nextLine();
		//TODO add emptyness check
		System.out.println(name);
		System.out.print("Type description for new TODO in one line and press 'Enter' key: ");
		final String description = this.scanner.nextLine();
		//TODO add emptyness check
		System.out.println(description);
		System.out.print("Type due date and time for new TODO formatted as \'" + this.format + "\' (without surrounding quotes) and press 'Enter' key: ");
		final String dueString = this.scanner.nextLine();
		//TODO add try-catch to handle parse DateTimeParseException
		ZonedDateTime due = LocalDateTime.parse(dueString,formatter).atZone(ZoneId.systemDefault());
		System.out.println(formatter.format(due.toLocalDateTime()));
		System.out.println();
	}
}
