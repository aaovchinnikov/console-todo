package ru.hse.todo.console.options;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.console.ConsoleSelection;
import ru.hse.todo.outputs.DetailTodoOutput;

public final class DisplayTodoDetails extends AbstarctOption {
	private final TodoOrderedStorage storage;
	private final ConsoleSelection selection;
	private final DateTimeFormatter formatter;
	
	/**
	 * @param todos
	 */
	public DisplayTodoDetails(TodoOrderedStorage storage, ConsoleSelection selection, DateTimeFormatter formatter) {
		this.storage = storage;
		this.selection = selection;	
		this.formatter = formatter;
	}

	@Override
	public void execute() {
		try {
			final List<Todo> todos = storage.todos();
			if (todos.isEmpty()) {
				System.out.println();
				System.out.println("-------------- Current TODOs --------------");
				System.out.println("\nTodo list is empty. Can't choose Todo to disply from empty list.");
			} else {
				final int index = selection.index();
				final DetailTodoOutput output = new DetailTodoOutput(formatter);
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
