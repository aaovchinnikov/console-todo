package ru.hse.todo.console.options;

public final class NotImplementedOption extends AbstarctOption {

	@Override
	public void execute() {
		System.out.println("\nEntered menu item is not implemented. Type the other option number.\n");
	}

}
