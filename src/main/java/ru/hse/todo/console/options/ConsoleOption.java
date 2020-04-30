package ru.hse.todo.console.options;

import java.util.Scanner;

public final class ConsoleOption {
	private final Scanner scanner;

	/**
	 * @param scanner
	 */
	public ConsoleOption(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public void print() {
		System.out.println(this.scanner.nextInt());
	}
}
