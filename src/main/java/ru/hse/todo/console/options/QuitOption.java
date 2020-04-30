package ru.hse.todo.console.options;

public final class QuitOption extends AbstarctOption {

	@Override
	public void execute() {
		System.out.println("Exiting...");
		System.exit(0);
	}
}
