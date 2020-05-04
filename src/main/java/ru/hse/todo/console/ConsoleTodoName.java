package ru.hse.todo.console;

import java.util.Scanner;

public final class ConsoleTodoName {
	private final Scanner scanner;

	/**
	 * @param scanner
	 */
	public ConsoleTodoName(Scanner scanner) {
		this.scanner = scanner;
	}

	public String name() {
		String name;
		while (true) {
			System.out.print("Type name for new TODO in one line and press 'Enter' key: ");
			name = this.scanner.nextLine();
			if (name.isBlank()) {
				System.out.println("Todo name should be non-blank.\n");
			} else {
				System.out.println("Name accepted.\n");
				return name;
			}
		}
	}
}
