package ru.hse.todo;

import java.util.List;

/**
 * Stores {@link Todo}s it provided {@link List} in memory
 * 
 * @author Alexander Ovchinnikov
 *
 */
public class SimpleTodoList implements TodoList {
	private final List<Todo> list;

	/**
	 * @param list
	 */
	public SimpleTodoList(List<Todo> list) {
		this.list = list;
	}

	/**
	 * Prints list of {@link Todo}s to standard output one {@link Todo} per line.
	 * Adds carrier return to the last line.
	 */
	@Override
	public void println() {
		if (this.list.isEmpty()) {
			System.out.println("\nTodo list is empty.\n");
		} else {
			int i=0;
			for(Todo todo : this.list) {
				i++;
				System.out.println(i + ". " + todo);
			}
		}
	}

	@Override
	public int size() {
		return this.list.size();
	}

	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}
}
