package binarySearchTree;

public abstract class BinaryTree {
	void preOrderTraverse(Operation op)  {
		// TODO
	}
	
	void postOrderTraverse(Operation op)  {
		// TODO
	}
	
	void inOrderTraverse(Operation op)  {
		// TODO
	}

	void levelOrderTraverse(Operation op)  {
		// TODO
	}

}

@FunctionalInterface
interface Operation {
	void execute(TreeNode treeNode);
}
