package ru.hse.todo.storages;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ru.hse.todo.Todo;

public final class InMemoryTodoList implements TodoOrderedStorage {
	private final List<Todo> todos;
	
	/**
	 * @param todos
	 */
	public InMemoryTodoList() {
		this.todos = new LinkedList<Todo>();
	}

	@Override
	synchronized public Todo add(Todo todo) throws IOException {
		TodoDtoOuput output = new TodoDtoOuput();
		todo.print(output);
		Todo added = output.build();
		this.todos.add(added);
		return added;
	}

	@Override
	synchronized public void remove(int index, Todo todo) throws IOException {
		Todo compared = this.todos.get(index); 
		if (compared.equals(todo)) {
			this.todos.remove(index);
		}
	}

	@Override
	public List<Todo> todos() throws IOException {
		return Collections.unmodifiableList(this.todos);
	}

}
