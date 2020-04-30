package ru.hse.todo.console;

import java.util.Scanner;

import ru.hse.todo.console.options.ChainedOption;
import ru.hse.todo.console.options.ConsoleOption;
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
    	Option option = new NotImplementedOption();
        new ConsoleApp(
        	new MainMenu(),
        	new ConsoleOption(
        		new Scanner(System.in),
        		new ChainedOption(
        			1,
        			option,
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
