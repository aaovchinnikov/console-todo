package ru.hse.todo.console;

import java.util.Scanner;

import ru.hse.todo.Selection;
import ru.hse.todo.TodoList;

public final class ConsoleSelection implements Selection {
	private final TodoList todos;
	private final Scanner scanner;
	
	/**
	 * 
	 * @param todos - should be non-empty.
	 */
	public ConsoleSelection(TodoList todos, Scanner scanner) {
		if (todos.isEmpty()) {
			throw new IllegalArgumentException("Provided TodoList object should be non-empty");
		}
		this.todos = todos;
		this.scanner = scanner;
	}

	@Override
	public int index() {
		System.out.println("-------------- Current TODOs --------------");
		this.todos.println();
		while (true) {
			System.out.print("Type TODO number and press \'Enter\' key to select it: ");
			final String input = this.scanner.nextLine();
			try {
				final int parsed = Integer.parseInt(input);
				if ((parsed < 1) || (parsed > this.todos.size())) {
					System.out.println("\nInvalid value entered. Integer value from 1.." + this.todos.size() + " expected.");
				} else {
					return parsed - 1;
				}
			} catch (NumberFormatException e) {
				System.out.println("\nNot integer entered. Integer value from 1.." + this.todos.size() + " expected.");
			}
		}
	}
}
