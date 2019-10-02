package commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import exceptions.MyException;
import helper_methods.PipeExecuteCommandHelper;
import mainpackage.CommandMapFill;
import mainpackage.Terminal;

public class Pipe implements CommandExecution {
	private Map<String, CommandExecution> commandNameToObjectMap = CommandMapFill.fillMap();

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {
		String command = arguments[0];
		int i = 1;
		List<String> commandArguments = new ArrayList<>();
		while (!arguments[i].equals("|")) {
			commandArguments.add(arguments[i]);
			i++;
		}
		i++;

		String output = "";
		output = PipeExecuteCommandHelper.executeCommand(commandNameToObjectMap, command, output, object,
				commandArguments.toArray(new String[commandArguments.size()]));

		for (int j = i; j < arguments.length; j++) {
			commandArguments.clear();
			command = arguments[j];
			j++;
			while (j < arguments.length && !arguments[j].equals("|")) {
				commandArguments.add(arguments[j]);
				j++;
			}
			commandArguments.add(output);

			output = PipeExecuteCommandHelper.executeCommand(commandNameToObjectMap, command, output, object,
					commandArguments.toArray(new String[commandArguments.size()]));
		}

		System.out.println(output);
		return output;
	}
}
