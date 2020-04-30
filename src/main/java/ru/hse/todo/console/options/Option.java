package ru.hse.todo.console.options;

public interface Option {
	/**
	 * Non-parameterized call to functionality
	 */
	void execute();

	/**
	 * Used to organize responsibility chain and pass <b>number</b> to next Option
	 * object
	 */
	void execute(int number);
}
