package ru.hse.todo.console.options;

import java.io.IOException;
import java.util.List;

import ru.hse.todo.Todo;
import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.outputs.BriefTodoOutput;

public final class DisplayTodosOption extends AbstarctOption {
	private final TodoOrderedStorage storage;
	
	/**
	 * @param todos
	 */
	public DisplayTodosOption(TodoOrderedStorage storage) {
		this.storage = storage;
	}

	@Override
	public void execute() {
		try {
			final List<Todo> todos = this.storage.todos();
			System.out.println();
			System.out.println("-------------- Current TODOs --------------");
			if (todos.isEmpty()) {
				System.out.println("\nTodo list is empty.");
			} else {
				final BriefTodoOutput output = new BriefTodoOutput();
				int index = 0;
				for(Todo todo: todos) {
					index++;
					System.out.print(index + ". ");
					todo.print(output);
					output.printBrief();
					System.out.println();
				}
			}
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
