package ru.hse.todo.console.options;

import java.util.Scanner;

/**
 * Menu option that reads input from standard input, extracts menu item number and
 * delegates processing of this number to encapsulated Option with @{@link #execute(int)} call.
 * 
 * @author Alexander Ovchinnikov
 *
 */
public final class ConsoleOption implements Option {
	private final Scanner scanner;
	private final Option option;

	/**
	 * @param scanner
	 */
	public ConsoleOption(Scanner scanner, Option option) {
		this.scanner = scanner;
		this.option = option;
	}

	@Override
	public void execute() {
		String input = this.scanner.nextLine();
		if (input.length() != 1) {
			System.out.println("\nInvalid value entered. Integer value from 0..9 expected.\n");
		} else {
			char symbol = input.charAt(0);
			if (Character.getType(symbol) == Character.DECIMAL_DIGIT_NUMBER) {
				int number = Character.getNumericValue(symbol);
				this.option.execute(number);
			} else {
				System.out.println("\nInvalid value entered. Integer value from 0..9 expected.\n");
			}
		}
	}

	/**
	 * Ignores <b>number</b> argument and delegates to {@link #execute()} call
	 */
	@Override
	public void execute(int number) {
		this.execute();
	}
}
