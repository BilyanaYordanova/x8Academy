package helper_methods;

import java.util.Map;

import commands.CommandExecution;
import exceptions.MyException;
import mainpackage.Terminal;

public class PipeExecuteCommandHelper {
	public static String executeCommand(Map<String, CommandExecution> commandNameToObjectMap, String command,
			String output, Terminal object, String[] commandArgumentsArray) throws MyException {

		if (commandNameToObjectMap.containsKey(command)) {
			try {
				output = commandNameToObjectMap.get(command).execute(object, commandArgumentsArray);
			} catch (MyException e) {
				throw new MyException(e.getMessage());
			}
		} else {
			throw new MyException(command + ": command not found");
		}
		return output;
	}
}
