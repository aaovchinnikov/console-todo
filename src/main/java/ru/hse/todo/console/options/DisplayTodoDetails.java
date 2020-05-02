package ru.hse.todo.console.options;

import java.util.List;

import ru.hse.todo.Selection;
import ru.hse.todo.Todo;

public class DisplayTodoDetails extends AbstarctOption {
	private final List<Todo> todos;
	private final Selection selection;
	
	/**
	 * @param todos
	 */
	public DisplayTodoDetails(List<Todo> todos, Selection selection) {
		this.todos = todos;
		this.selection = selection;
	}

	@Override
	public void execute() {
		System.out.println();
		if (this.todos.isEmpty()) {
			System.out.println("Todo list is empty");
		} else {
			final int index = selection.index();
			System.out.println();
			System.out.println("-------------- Selected TODO --------------");
			System.out.println("Index: " + (index + 1));
			this.todos.get(index).print();
		}
		System.out.println();
	}
}
