package ru.hse.todo.console;

import java.util.Scanner;

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
        	new Option(
        		new Scanner(System.in)
        	)
        ).run();
    }
}
