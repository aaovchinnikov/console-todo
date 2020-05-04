package ru.hse.todo.console.options;

import java.util.List;

import ru.hse.todo.Todo;

public final class DisplayTodosOption extends AbstarctOption {
	private final List<Todo> todos;
	
	/**
	 * @param todos
	 */
	public DisplayTodosOption(List<Todo> todos) {
		this.todos = todos;
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("-------------- Current TODOs --------------");
		for(Todo todo: this.todos) {
			todo.print();	
		}
		System.out.println();
	}
}
