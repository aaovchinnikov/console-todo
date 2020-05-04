package ru.hse.todo.console.options;

import java.io.IOException;
import java.util.List;

import ru.hse.todo.Selection;
import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;

public final class RemoveTodoOption extends AbstarctOption {
	private final TodoOrderedStorage storage;
	private final Selection selection;

	/**
	 * @param storage
	 * @param selection
	 */
	public RemoveTodoOption(TodoOrderedStorage storage, Selection selection) {
		this.storage = storage;
		this.selection = selection;
	}

	@Override
	public void execute() {
		try {
			final List<Todo> todos = this.storage.todos();
			if (todos.isEmpty()) {
				System.out.println();
				System.out.println("-------------- Current TODOs --------------");
				System.out.println("\nTodo list is empty. Can't remove from empty list.");
			} else {
				final int index = selection.index();
				final Todo removing = todos.get(index);
				this.storage.remove(index, removing);
				System.out.println("\nSelected Todo removed.");
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
