package ru.hse.todo;

public interface TodoList {
	/**
	 * Prints list of {@link Todo}s
	 */
	void println();

/*
	/**
	 * Returns representation of {@link TodoList} as {@link List} of {@link Todo}s. Returned {@link List} is not
	 * backed by internal representation of {@link TodoList}, any changes to returned
	 * {@link List} are not propagated to original {@link TodoList} object.
	 */
//	List<Todo> asList();

	/**
	 * Returns the number of elements in this TodoList.
	 * @return
	 */
	int size();
	
	/**
	 * Returns true if this {@link TodoList} List contains no {@link Todo}s. Otherwise returns false.
	 */
	boolean isEmpty();
	
}
