package ru.hse.todo.console;

import ru.hse.todo.console.options.ConsoleOption;

public class ConsoleApp {
	private final MainMenu menu;
	private final ConsoleOption option;
	
	/**
	 * @param menu
	 */
	public ConsoleApp(MainMenu menu, ConsoleOption option) {
		this.menu = menu;
		this.option = option;
	}

	public void run() {
		this.menu.print();
		this.option.print();
	}
}
