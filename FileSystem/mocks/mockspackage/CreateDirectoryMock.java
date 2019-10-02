package mockspackage;
import mainpackage.TreeNode;

public class CreateDirectoryMock {

	public String execute(TreeNode currentDirectory, String directoryName) {
		currentDirectory.addChildByName(directoryName);
		return "";
	}
}
