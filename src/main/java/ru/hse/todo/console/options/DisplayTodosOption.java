package ru.hse.todo.console.options;

import java.util.List;

import ru.hse.todo.Todo;
import ru.hse.todo.outputs.BriefTodoOutput;

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
		if (this.todos.isEmpty()) {
			System.out.println("\nTodo list is empty.\n");
			return;
		}
		BriefTodoOutput output = new BriefTodoOutput();
		int index = 0;
		for(Todo todo: this.todos) {
			index++;
			System.out.print(index + ". ");
			todo.print(output);
			output.printBrief();
			System.out.println();
		}
		System.out.println();
	}
}
