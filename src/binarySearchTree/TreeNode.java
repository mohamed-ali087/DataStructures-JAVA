package binarySearchTree;

public class TreeNode<E>{

	E data;
	TreeNode<E> parent;
	TreeNode<E> leftNode;
	TreeNode<E> rightNode;

	/* Constructors */
	public TreeNode(){
		this(null, null, null, null);
	}
	
	public TreeNode(E data) {
		this(data,null ,null, null);
	}

	public TreeNode(E data, TreeNode<E> parent) {
		this(data,parent ,null, null);
	}

	public TreeNode(E data,TreeNode<E> parent, TreeNode<E> leftNode, TreeNode<E> rightNode) {
		this.data = data;
		this.rightNode = rightNode;
		this.leftNode = leftNode;
	}
	
	public boolean isLeaf() {

		return false;
	}

	// getters
	public E getData() {
		return data;
	}

	public TreeNode<E> getParent() {
		return parent;
	}

	public TreeNode<E> getLeftNode() {
		return leftNode;
	}

	public TreeNode<E> getRightNode() {
		return rightNode;
	}
	

	// setters
	public void setData(E data) {
		this.data = data;
	}

	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}


	public void setLeftNode(TreeNode<E> leftNode) {
		this.leftNode = leftNode;
	}


	public void setRightNode(TreeNode<E> rightNode) {
		this.rightNode = rightNode;
	}

	
}
