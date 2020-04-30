package ru.hse.todo.console;

import java.util.Scanner;

public final class Option {
	private final Scanner scanner;

	/**
	 * @param scanner
	 */
	public Option(Scanner scanner) {
		this.scanner = scanner;
	}
	
	void print() {
		System.out.println(this.scanner.nextInt());
	}
}
