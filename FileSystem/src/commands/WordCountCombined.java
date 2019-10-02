package commands;

import exceptions.MyException;
import helper_methods.LinesCount;
import helper_methods.WordsCount;
import mainpackage.Terminal;
import mainpackage.TreeNode;

//should be fulfilled
public class WordCountCombined implements CommandExecution {

	@Override
	public String execute(Terminal object, String... arguments) throws MyException {

		TreeNode currentDirectory = object.getCurrentDirectory();

		if (!arguments[0].equals("-l")) {
			int wordsCount = 0;
			wordsCount = WordsCount.getWordsCount(currentDirectory, wordsCount, arguments);
			return Integer.toString(wordsCount);
		} else {
			int linesCount = 0;
			linesCount = LinesCount.getLinesCount(currentDirectory, linesCount, arguments);
			return Integer.toString(linesCount);
		}
	}
}
