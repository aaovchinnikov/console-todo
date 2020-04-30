package ru.hse.todo.console.options;

import ru.hse.todo.TodoList;

public final class DisplayTodosOption extends AbstarctOption {
	private final TodoList todos;
	
	/**
	 * @param todos
	 */
	public DisplayTodosOption(TodoList todos) {
		this.todos = todos;
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("-------------- Current TODOs --------------");
		this.todos.println();
		System.out.println();
	}

}
