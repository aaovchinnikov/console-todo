package ru.hse.todo.console.options;

public class SimpleOption implements Option {

	@Override
	public void execute() {
		System.out.println("Default Option implementation");
	}
}
