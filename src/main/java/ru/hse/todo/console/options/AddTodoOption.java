package ru.hse.todo.console.options;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.console.ConsoleTodoDescription;
import ru.hse.todo.console.ConsoleTodoDue;
import ru.hse.todo.console.ConsoleTodoName;
import ru.hse.todo.todos.SimpleTodo;

public class AddTodoOption extends AbstarctOption {
	private final TodoOrderedStorage storage;
	private final ConsoleTodoName name;
	private final ConsoleTodoDescription description;
	private final ConsoleTodoDue due;
	private final DateTimeFormatter formatter;
	
	/**
	 * @param storage
	 * @param name
	 * @param description
	 * @param due
	 * @param formatter
	 */
	public AddTodoOption(TodoOrderedStorage storage, ConsoleTodoName name, ConsoleTodoDescription description,
			ConsoleTodoDue due, DateTimeFormatter formatter) {
		this.storage = storage;
		this.name = name;
		this.description = description;
		this.due = due;
		this.formatter = formatter;
	}

	@Override
	public void execute() {
		System.out.println();
		System.out.println("-------------- Add TODO ---------------");
		final String todoName = this.name.name();
		final String todoDescription = this.description.description();
		final ZonedDateTime todoDue = this.due.due();
		System.out.println();
		try {
			this.storage.add(new SimpleTodo(todoName, todoDescription, todoDue, this.formatter));
			System.out.println("The new TODO created and saved.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
