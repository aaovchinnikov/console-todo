package ru.hse.todo.console;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ru.hse.todo.SimpleTodo;
import ru.hse.todo.SimpleTodoList;
import ru.hse.todo.Todo;
import ru.hse.todo.TodoList;
import ru.hse.todo.console.options.ChainedOption;
import ru.hse.todo.console.options.ConsoleOption;
import ru.hse.todo.console.options.DisplayTodoDetails;
import ru.hse.todo.console.options.DisplayTodosOption;
import ru.hse.todo.console.options.NotImplementedOption;
import ru.hse.todo.console.options.Option;
import ru.hse.todo.console.options.QuitOption;

/**
 * Hello world!
 *
 */
public final class Main 
{
    public static void main( String[] args )
    {
    	final List<Todo> list = new LinkedList<Todo>();
    	final DateTimeFormatter yyyy_MM_dd_HH_mm = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm");
    	list.add(
    		new SimpleTodo(
    			"Task 1",
    			"Description 1",
    			LocalDateTime.parse(
    				"2020.05.03 14:00",
    				yyyy_MM_dd_HH_mm
    			).atZone(ZoneId.systemDefault())
    		)
    	);
    	list.add(
        	new SimpleTodo(
        		"Task 2",
        		"Description 2",
        		LocalDateTime.parse(
        			"2020.05.04 15:00",
        			yyyy_MM_dd_HH_mm
        		).atZone(ZoneId.systemDefault())
        	)
        );
    	list.add(
           	new SimpleTodo(
           		"Task 3",
           		"Description 3",
           		LocalDateTime.parse(
           			"2020.05.06 15:00",
           			yyyy_MM_dd_HH_mm
           		).atZone(ZoneId.systemDefault())
           	)
        );   	
    	final TodoList todos = new SimpleTodoList(list);
    	final Option notImplemented = new NotImplementedOption();
    	final Scanner scanner = new Scanner(System.in);
        new ConsoleApp(
        	new MainMenu(),
        	new ConsoleOption(
        		scanner,
        		new ChainedOption(
        			1,
        			new DisplayTodosOption(todos),
       				new ChainedOption(
       					2,
       					new DisplayTodoDetails(list, new ConsoleSelection(todos, scanner)),
       					new ChainedOption(
       						3,
       						notImplemented,
       						new ChainedOption(
       							4,
       							notImplemented,
       							new ChainedOption(
       								5,
       								new QuitOption(),
       								notImplemented
       							)
       						)
       					)
       				)
        		)
        	)
        ).run();
    }
}
