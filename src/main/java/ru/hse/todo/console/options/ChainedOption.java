package ru.hse.todo.console.options;

import ru.hse.todo.console.Option;

public final class ChainedOption implements Option {
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
	
	public void execute(int number) {
		if (number == this.number) {
			this.origin.execute();
		} else {
			this.next.execute(number);
		}
	}

	@Override
	public void execute() {
		this.origin.execute();
	}
}
