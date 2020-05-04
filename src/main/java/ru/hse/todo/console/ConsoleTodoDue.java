package ru.hse.todo.console;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public final class ConsoleTodoDue {
	private final Scanner scanner;
	private final String format;
	private final DateTimeFormatter formatter;

	/**
	 * @param scanner
	 * @param format
	 * @param formatter
	 */
	public ConsoleTodoDue(Scanner scanner, String format, DateTimeFormatter formatter) {
		this.scanner = scanner;
		this.format = format;
		this.formatter = formatter;
	}

	public ZonedDateTime due() {
		String line;
		while (true) {
			System.out.print("Type due date and time for new TODO formatted as \'" + this.format
					+ "\' (without surrounding quotes) and press 'Enter' key: ");
			line = this.scanner.nextLine();
			if (line.isBlank()) {
				System.out.println("Todo due date and time should be non-blank.\n");
			} else {
				try {
					ZonedDateTime due = LocalDateTime.parse(line, formatter).atZone(ZoneId.systemDefault());
					System.out.println("Due date and time accepted.\n");
					return due;
				} catch (DateTimeParseException e) {
					System.out.println("Incorrect date and time format. Todo due date and time should be in format \'"
							+ this.format + "\'.\n");
				}
			}
		}
	}
}
