package ru.hse.todo.console.options;

import java.io.IOException;
import java.util.List;

import ru.hse.todo.Selection;
import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.outputs.DetailTodoOutput;

public final class DisplayTodoDetails extends AbstarctOption {
	private final TodoOrderedStorage storage;
	private final DisplayTodosOption option;
	private final Selection selection;
	
	/**
	 * @param todos
	 */
	public DisplayTodoDetails(TodoOrderedStorage storage, DisplayTodosOption option, Selection selection) {
		this.storage = storage;
		this.option = option;
		this.selection = selection;		
	}

	@Override
	public void execute() {
		try {
			final List<Todo> todos = storage.todos();
			System.out.println();
			if (todos.isEmpty()) {
				System.out.println("-------------- Current TODOs --------------");
				System.out.println("\nTodo list is empty. Can't choose Todo to disply from empty list.");
			} else {
				this.option.execute();
				final int index = selection.index();
				DetailTodoOutput output = new DetailTodoOutput();
				System.out.println();
				System.out.println("-------------- Selected TODO --------------");
				System.out.println("Index: " + (index + 1));
				todos.get(index).print(output);
				output.printDetails();
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
