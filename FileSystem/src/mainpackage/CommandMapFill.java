package mainpackage;

import java.util.HashMap;
import java.util.Map;

import commands.ChangeDirectory;
import commands.CommandExecution;
import commands.CreateDirectory;
import commands.CreateFile;
import commands.DisplayContent;
import commands.ListFilesInCurrentDirectory;
import commands.WordCountCombined;
import commands.WriteToFile;

public class CommandMapFill {

	public static Map<String, CommandExecution> fillMap() {
		Map<String, CommandExecution> commandNameToObjectMap = new HashMap<>();

		commandNameToObjectMap.put("cd", new ChangeDirectory());
		commandNameToObjectMap.put("mkdir", new CreateDirectory());
		commandNameToObjectMap.put("create_file", new CreateFile());
		commandNameToObjectMap.put("cat", new DisplayContent());
		commandNameToObjectMap.put("write", new WriteToFile());
		commandNameToObjectMap.put("ls", new ListFilesInCurrentDirectory());
		commandNameToObjectMap.put("wc", new WordCountCombined());

		return commandNameToObjectMap;
	}
}
