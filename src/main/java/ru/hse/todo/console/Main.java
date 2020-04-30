package ru.hse.todo.console;

import java.util.Scanner;

import ru.hse.todo.console.options.ConsoleOption;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        new ConsoleApp(
        	new MainMenu(),
        	new ConsoleOption(
        		new Scanner(System.in)
        	)
        ).run();
    }
}
