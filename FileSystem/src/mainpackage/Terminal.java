package mainpackage;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

import commands.CommandExecution;
import commands.Pipe;
import exceptions.MyException;

public class Terminal {
	private TreeNode currentDirectory = TreeNode.createRoot().getChildByName("home");
	private Map<String, CommandExecution> commandNameToObjectMap = CommandMapFill.fillMap();;

	public TreeNode getCurrentDirectory() {
		return currentDirectory;
	}

	public void setCurrentDirectory(TreeNode currentDirectory) {
		this.currentDirectory = currentDirectory;
	}

	public void commandCalling() {
		Scanner s = new Scanner(System.in);
		System.out.println("To close the terminal type exit. ");
		String commandAndArguments = s.nextLine();

		String result = "";

		while (!commandAndArguments.equals("exit")) {
			String[] arrayOfCommandAndArguments = commandAndArguments.split("\\s+");
			String[] argumentsOnly = Arrays.copyOfRange(arrayOfCommandAndArguments, 1,
					arrayOfCommandAndArguments.length);

			if (Arrays.asList(arrayOfCommandAndArguments).contains("|")) {
				Pipe pipeObject = new Pipe();
				try {
					pipeObject.execute(this, arrayOfCommandAndArguments);
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
			} else if (commandNameToObjectMap.containsKey(arrayOfCommandAndArguments[0])) {
				try {
					result = commandNameToObjectMap.get(arrayOfCommandAndArguments[0]).execute(this, argumentsOnly);
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
				if (!result.equals("")) {
					System.out.println(result);
				}
			} else {
				System.out.println(arrayOfCommandAndArguments[0] + ": command not found");
			}

			commandAndArguments = s.nextLine();
		}
		s.close();
	}

	public static void main(String[] args) {
		Terminal object = new Terminal();
		object.commandCalling();
	}
}
