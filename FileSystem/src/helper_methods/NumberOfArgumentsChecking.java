package helper_methods;

import exceptions.MyException;

public class NumberOfArgumentsChecking {
	public static void printErrorMessage(String[] arguments, int limitNumberOfArguments, String messageToPrint)
			throws MyException {

		if (arguments.length > limitNumberOfArguments) {
			throw new MyException(messageToPrint);
		}
	}
}
