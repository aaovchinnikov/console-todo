package ru.hse.todo.console.options;

/**
 * Defines default implemenation of {@link Option} interface with
 * {@link #execute(int)} method delegating directly to {@link #execute()} call 
 * 
 * @author Alexander Ovchinnikov
 *
 */
public abstract class AbstarctOption implements Option {

	/**
	 * Ignores <b>number</b> argument and delegates to {@link #execute()} call
	 */
	@Override
	public void execute(int number) {
		this.execute();
	}
}
