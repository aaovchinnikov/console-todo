package ru.hse.todo.console;

import ru.hse.todo.console.options.Option;

public class ChainedOption implements Option {
	private final Option origin;
	private final Option next;
	private final int number;
	/**
	 * @param origin
	 * @param next
	 */
	public ChainedOption(int number, Option origin, Option next) {
		this.number = number;
		this.origin = origin;
		this.next = next;
	}
	
	@Override
	public void execute() {
		if (5 == this.number) {
			this.origin.execute();
		} else {
			this.next.execute();
		}
	}
}
