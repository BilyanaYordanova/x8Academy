package mainpackage;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import mainpackage.TreeNode;

class TreeNodeTest {

	@Test
	void test1_ConstructorWithoutParameters() {
		TreeNode obj = new TreeNode();
		assertEquals("", obj.getName());
		assertEquals(null, obj.getParent());
		assertEquals(0, obj.getChildren().size());
		assertEquals(0, obj.getFiles().size());
	}

	@Test
	void test2_ConstructorWithOneParameter() {
		TreeNode obj = new TreeNode("node");
		assertEquals("node", obj.getName());
		assertEquals(null, obj.getParent());
		assertEquals(0, obj.getChildren().size());
		assertEquals(0, obj.getFiles().size());
	}

	@Test
	void test3_ConstructorWithAllFieldsAsParameters() {
		TreeNode child = new TreeNode("child");
		ArrayList<TreeNode> arrayNode = new ArrayList<>();
		arrayNode.add(child);

		HashMap<String, TreeMap<Integer, String>> files = new HashMap<>();

		TreeNode parentOfParent = new TreeNode("parentOfParent");

		TreeNode parent = new TreeNode("parent", arrayNode, parentOfParent, files);
		assertEquals("parent", parent.getName());
		assertEquals(parentOfParent, parent.getParent());
		assertEquals(1, parent.getChildren().size());
		assertEquals(0, parent.getFiles().size());

		assertEquals(parent, child.getParent());
	}

	@Test
	void test4_GetNameAndSetName() {
		TreeNode obj = new TreeNode("node");
		assertEquals("node", obj.getName());

		obj.setName("newName");
		assertEquals("newName", obj.getName());
	}

	@Test
	void test5_GetChildrenAndAddChildren1() {
		TreeNode obj = new TreeNode("task");
		obj.addChild(new TreeNode("firstTask"));
		obj.addChildByName("secondTask");

		ArrayList<TreeNode> arrayChildren = obj.getChildren();
		assertEquals(2, obj.getChildren().size());
		assertEquals(2, arrayChildren.size());
	}

	@Test
	void test6_GetChildrenAndAddChildren2() {
		TreeNode obj = new TreeNode("task");
		TreeNode firstTask = new TreeNode("firstTask");
		TreeNode secondTask = new TreeNode("secondTask");

		obj.addChild(firstTask);
		obj.addChild(secondTask);

		assertEquals(firstTask, obj.getChildByName("firstTask"));
		assertEquals(secondTask, obj.getChildByName("secondTask"));
	}

}
