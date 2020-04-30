package ru.hse.todo.console;

public class ConsoleApp {
	private final MainMenu menu;
	private final Option option;
	
	/**
	 * @param menu
	 */
	public ConsoleApp(MainMenu menu, Option option) {
		this.menu = menu;
		this.option = option;
	}

	public void run() {
		this.menu.print();
		this.option.print();
	}
}
