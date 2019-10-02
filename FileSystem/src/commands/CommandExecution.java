package commands;

import exceptions.MyException;
import mainpackage.Terminal;

public interface CommandExecution {
	public String execute(Terminal object, String... arguments) throws MyException;
}
