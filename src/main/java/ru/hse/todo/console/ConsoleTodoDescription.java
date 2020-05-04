package ru.hse.todo.console;

import java.util.Scanner;

public final class ConsoleTodoDescription {
	private final Scanner scanner;

	/**
	 * @param scanner
	 */
	public ConsoleTodoDescription(Scanner scanner) {
		this.scanner = scanner;
	}

	public String description() {
		String description;
		while (true) {
			System.out.print("Type description for new TODO in one line and press 'Enter' key: ");
			description = this.scanner.nextLine();
			if (description.isBlank()) {
				System.out.println("Todo description should be non-blank.\n");
			} else {
				System.out.println("Description accepted.\n");
				return description;
			}
		}
	}
}
