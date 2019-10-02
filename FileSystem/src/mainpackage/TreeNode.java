package mainpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class TreeNode {

	private String name;
	private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
	private TreeNode parent;
	private HashMap<String, TreeMap<Integer, String>> files = new HashMap<>();

	TreeNode() {
		name = "";
		parent = null;
	}

	TreeNode(String name) {
		this.name = name;
		parent = null;
	}

	TreeNode(String name, ArrayList<TreeNode> children, TreeNode parent,
			HashMap<String, TreeMap<Integer, String>> files) {
		this.name = name;
		this.children = children;
		for (int i = 0; i < this.children.size(); i++) {
			this.children.get(i).setParent(this);
		}
		this.parent = parent;
		this.files = files;
	}

	public static TreeNode createRoot() {
		TreeNode root = new TreeNode("/");
		root.setParent(root);
		root.addChildByName("home");
		return root;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addChild(TreeNode child) {
		child.setParent(this);
		children.add(child);
	}

	public void addChildByName(String childName) {
		TreeNode child = new TreeNode(childName);
		child.setParent(this);
		this.children.add(child);
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public void addFile(String fileName, TreeMap<Integer, String> file) {
		this.files.put(fileName, file);
	}

	public String getName() {
		return this.name;
	}

	public ArrayList<TreeNode> getChildren() {
		return this.children;
	}

	public TreeNode getChildByName(String name) {
		for (int i = 0; i < children.size(); i++) {
			if (children.get(i).getName().equals(name)) {
				return children.get(i);
			}
		}
		return null;
	}

	public TreeNode getParent() {
		return this.parent;
	}

	public HashMap<String, TreeMap<Integer, String>> getFiles() {
		return this.files;
	}

	public TreeMap<Integer, String> getFileByName(String fileName) {
		for (String i : files.keySet()) {
			if (i.equals(fileName)) {
				return files.get(i);
			}
		}
		return null;
	}
}
