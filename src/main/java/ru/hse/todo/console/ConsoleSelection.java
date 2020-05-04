package ru.hse.todo.console;

import java.util.List;
import java.util.Scanner;

import ru.hse.todo.Selection;
import ru.hse.todo.Todo;
import ru.hse.todo.console.options.DisplayTodosOption;

public final class ConsoleSelection implements Selection {
	private final List<Todo> todos;
	private final Scanner scanner;
	private final DisplayTodosOption option;
	
	/**
	 * 
	 * @param todos - should be non-empty.
	 */
	public ConsoleSelection(List<Todo> todos, Scanner scanner, DisplayTodosOption option) {
		if (todos.isEmpty()) {
			throw new IllegalArgumentException("Provided TodoList object should be non-empty");
		}
		this.todos = todos;
		this.scanner = scanner;
		this.option = option;
	}

	@Override
	public int index() {
		option.execute();
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
