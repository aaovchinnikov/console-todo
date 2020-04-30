package ru.hse.todo.console;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import ru.hse.todo.SimpleTodo;
import ru.hse.todo.SimpleTodoList;
import ru.hse.todo.Todo;
import ru.hse.todo.TodoList;
import ru.hse.todo.console.options.ChainedOption;
import ru.hse.todo.console.options.ConsoleOption;
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
    	list.add(new SimpleTodo());
    	list.add(new SimpleTodo());
    	list.add(new SimpleTodo());
    	final TodoList todos = new SimpleTodoList(list);
    	final Option option = new NotImplementedOption();
        new ConsoleApp(
        	new MainMenu(),
        	new ConsoleOption(
        		new Scanner(System.in),
        		new ChainedOption(
        			1,
        			new DisplayTodosOption(todos),
        			new ChainedOption(
        				2, 
        				option,
        				new ChainedOption(
        					3,
        					option,
        					new ChainedOption(
        						4,
        						option,
        						new ChainedOption(
        							5,
        							option,
        							new ChainedOption(
        								6,
        								new QuitOption(),
        								option
        							)
        						)
        					)
        				)
        			)
        		)
        	)
        ).run();
    }
}
