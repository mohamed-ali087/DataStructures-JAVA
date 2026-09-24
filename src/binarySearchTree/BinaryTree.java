package binarySearchTree;

import java.util.Queue;
import java.util.LinkedList;

public abstract class BinaryTree<E> {
	/* depth first traversals. */
	void preOrderTraverse(TreeNode<E> node, TraversalOperation op)  {
		if(node!=null) {
			op.execute(node);
			preOrderTraverse(node.getLeftNode(), op);
			preOrderTraverse(node.getRightNode(), op);
		}
	}
	
	void postOrderTraverse(TreeNode<E> node, TraversalOperation op)  {
		if(node!=null) {
			postOrderTraverse(node.getLeftNode(), op);
			postOrderTraverse(node.getRightNode(), op);
			op.execute(node);
		}
	}
	
	void inOrderTraverse(TreeNode<E> node, TraversalOperation op)  {
		if(node!=null) {
			inOrderTraverse(node.getLeftNode(), op);
			op.execute(node);
			inOrderTraverse(node.getRightNode(), op);
		}
	}

	/* Breadth first traversal. */
	void levelOrderTraverse(TreeNode<E> node, TraversalOperation op)  {
		if(node != null) {
			Queue<TreeNode<E>> q = new LinkedList<TreeNode<E>>();
			q.add(node);
			
			while(!q.isEmpty()) {
				TreeNode<E> currNode = q.remove();
				
				if(currNode != null) {
					op.execute(currNode);
					q.add(currNode.getLeftNode());
					q.add(currNode.getRightNode());
				}
			}
		}
	}
}

@FunctionalInterface
interface TraversalOperation {
	void execute(TreeNode treeNode);
}
