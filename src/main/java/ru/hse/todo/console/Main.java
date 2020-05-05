package ru.hse.todo.console;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import ru.hse.todo.TodoOrderedStorage;
import ru.hse.todo.console.options.AddTodoOption;
import ru.hse.todo.console.options.ChainedOption;
import ru.hse.todo.console.options.ConsoleOption;
import ru.hse.todo.console.options.DisplayTodoDetails;
import ru.hse.todo.console.options.DisplayTodosOption;
import ru.hse.todo.console.options.NotImplementedOption;
import ru.hse.todo.console.options.QuitOption;
import ru.hse.todo.console.options.RemoveTodoOption;
import ru.hse.todo.storages.InMemoryTodoList;
import ru.hse.todo.todos.SimpleTodo;

/**
 * Hello world!
 *
 */
public final class Main 
{
    public static void main( String[] args ) throws IOException
    {
    	final String format = "yyyy.MM.dd HH:mm";
    	final DateTimeFormatter yyyy_MM_dd_HH_mm = DateTimeFormatter.ofPattern(format);
    	final TodoOrderedStorage storage = new InMemoryTodoList(yyyy_MM_dd_HH_mm);
    	storage.add(
    		new SimpleTodo(
       			"Task 1",
           		"Description 1",
           		LocalDateTime.of(2020, 05, 03, 14, 00).atZone(ZoneId.systemDefault()),
       			yyyy_MM_dd_HH_mm
            )
    	);
    	storage.add(
           	new SimpleTodo(
           		"Task 2",
           		"Description 2",
           		LocalDateTime.parse(
           			"2020.05.04 15:00",
                	yyyy_MM_dd_HH_mm
                ).atZone(ZoneId.systemDefault()),
           		yyyy_MM_dd_HH_mm
           	)
    	);
    	storage.add(
    		new SimpleTodo(
    			"Task 3",
    			"Description 3",
    			LocalDateTime.parse(
    				"2020.05.05 15:00",
    				yyyy_MM_dd_HH_mm
    			).atZone(ZoneId.systemDefault()),
    			yyyy_MM_dd_HH_mm
    		)
    	);
    	final Option notImplemented = new NotImplementedOption();
    	final Scanner scanner = new Scanner(System.in);
    	final DisplayTodosOption displayTodos = new DisplayTodosOption(storage);
    	final ConsoleSelection selection = new ConsoleSelection(
			storage,
			scanner,
			displayTodos
		);
        new ConsoleApp(
        	new MainMenu(),
        	new ConsoleOption(
        		scanner,
        		new ChainedOption(
        			1,
        			displayTodos,
       				new ChainedOption(
       					2,
       					new DisplayTodoDetails(
       						storage,
       						selection,
       						yyyy_MM_dd_HH_mm
       					),
       					new ChainedOption(
       						3,
       						new AddTodoOption(
       							storage,
       							new ConsoleTodoName(scanner),
       							new ConsoleTodoDescription(scanner),
       							new ConsoleTodoDue(
       								scanner,
           							format,
           							yyyy_MM_dd_HH_mm
								),
       							yyyy_MM_dd_HH_mm
       						),
       						new ChainedOption(
       							4,
       							new RemoveTodoOption(
       								storage,
       								selection
       							),
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
