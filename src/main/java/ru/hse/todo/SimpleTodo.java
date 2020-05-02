package ru.hse.todo;

import java.time.ZonedDateTime;

public class SimpleTodo implements Todo {
	private final String name;
	private final String descrition;
	private final ZonedDateTime due;
	/**
	 * @param name
	 * @param descrition
	 * @param dueDateTime
	 */
	public SimpleTodo(String name, String descrition, ZonedDateTime due) {
		this.name = name;
		this.descrition = descrition;
		this.due= due;
	}
	
	@Override
	public void print() {
		System.out.println("Name: " + this.name);
		System.out.println("Description: " + this.descrition);
		System.out.println("Due to: " + this.due.toLocalDateTime());
	}
}
