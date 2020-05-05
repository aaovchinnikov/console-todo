package ru.hse.todo.console;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.console.options.DisplayTodosOption;

public final class ConsoleSelection {
	private final TodoOrderedStorage storage;
	private final Scanner scanner;
	private final DisplayTodosOption option;

	/**
	 * @param storage
	 * @param scanner
	 * @param option
	 */
	public ConsoleSelection(TodoOrderedStorage storage, Scanner scanner, DisplayTodosOption option) {
		this.storage = storage;
		this.scanner = scanner;
		this.option = option;
	}

	/**
	 * Asks user to select one of {@link Todo} from {@link TodoOrderedStorage} by
	 * typing its index in list, then handles user input.
	 * 
	 * @return selected {@link Todo} index in {@link TodoOrderedStorage}, indexes starts from 0.
	 */
	public int index() {
		try {
			List<Todo> todos = this.storage.todos();
			if (todos.isEmpty()) {
				throw new IllegalStateException("Todo list is empty. Can't select on empty list.");
			}
			this.option.execute();
			while (true) {
				System.out.print("Type TODO number and press \'Enter\' key to select it: ");
				final String input = this.scanner.nextLine();
				try {
					final int parsed = Integer.parseInt(input);
					if ((parsed < 1) || (parsed > todos.size())) {
						System.out.println(
								"\nInvalid value entered. Integer value from 1.." + todos.size() + " expected.");
					} else {
						return parsed - 1;
					}
				} catch (NumberFormatException e) {
					System.out.println("\nNot integer entered. Integer value from 1.." + todos.size() + " expected.");
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
