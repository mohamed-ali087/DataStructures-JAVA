package binarySearchTree;

public class BST<E extends Comparable<? super E> > extends BinaryTree {
	TreeNode<E> root;
	public BST() {
		// TODO Auto-generated constructor stub
		root = new TreeNode<E>();
	}
	
	// find using iteration.
	public TreeNode<E> findParent(E tofind){
		TreeNode<E> parentNode = root;
		TreeNode<E> nodeTofind = root; // any value rather than null.
		int comp;

		while(nodeTofind!=null) {
			parentNode = nodeTofind;
			comp = tofind.compareTo(parentNode.getData());
			if(comp < 0) {
				nodeTofind = parentNode.getLeftNode();
			} else if(comp > 0){
				nodeTofind = parentNode.getRightNode();
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		
		return parentNode;
	}
	public TreeNode<E> find(E tofind){
		TreeNode<E> parentNode = findParent(tofind);
		int comp;

		comp = tofind.compareTo(parentNode.getData());

		if(comp < 0) {
			return parentNode.getLeftNode(); // will return null if the value is not found.
		} else if(comp > 0) {
			return parentNode.getRightNode();// will return null if the value is not found.
		}

		return null;
	}

	public boolean contains(E tofind) {
		TreeNode<E> nodeFound = find(tofind);
		if(nodeFound == null) {
			return false; 
		}	
		return true;
	}
	
	public TreeNode<E> insert(E data){
		TreeNode<E> newNode;
		TreeNode<E> parentNode = findParent(data);
		if(parentNode == null) {
			System.err.println("bst.insert: couldn't find parent for the data.");
		}
		int comp = data.compareTo(parentNode.getData());

		if(comp < 0 && parentNode.getLeftNode()==null) {
			parentNode.setLeftNode(newNode = new TreeNode<E>(data, parentNode));
		} else if(comp > 0 && parentNode.getRightNode()==null){
			parentNode.setRightNode(newNode = new TreeNode<E>(data, parentNode));
		} else {
			return null;
		}
		newNode.setParent(parentNode);
		
		return newNode;
	}
	
	public boolean deleteNode(TreeNode<E> node){

		if(node == null) {
			return false;
//			throw new NullPointerException(); #TODO: why not??
		}

		if(node == root) {
			/* This approach may cause the left branch of the tree to be bigger (deeper)
			 * than the right branch.
			 * a better approach is to decide which branch would replace the root depending on it's size (depth). */
			
			/* find the smallest value node in the right branch */
			/* #NOTICE: the root may not have a right node */
			TreeNode<E> smallest;

			if(node.getRightNode() != null) {
				smallest = node.getRightNode();
			} else {
				if(node.getLeftNode() == null) {
					node.data = null;
					return true;
				} else {
					smallest = node;
				}
			}
			while(smallest.getLeftNode() != null)
				smallest = smallest.getLeftNode();
			
			/* correct the connections. */
			smallest.setLeftNode(node.getLeftNode());
			smallest.getLeftNode().setParent(smallest);
			root = node.getRightNode(); // root updated.
			root.setParent(null);
			
			return true;
		}

		if(node.getRightNode() != null) {
			if(node.getLeftNode() != null) {
				// finding the smallest value in the right branch
				TreeNode<E> smallest = node.getRightNode();
				while(smallest.getLeftNode() != null)
					smallest = smallest.getLeftNode();
				/* override the node's data with
				   the smallest's (the smallest of the right branch) data. */
				node.setData(smallest.getData());
				// delete the "smallest" node
				deleteNode(smallest);
			} else {
				/* connect the right branch to the parent
				 * find out if the node is right or left to the parent */
				if(node.getParent().getRightNode() == node) {
					node.getParent().setRightNode(node.getRightNode());
				} else if(node.getParent().getLeftNode() == node) {
					node.getParent().setLeftNode(node.getRightNode());
				}
			}
			
		} else if(node.getLeftNode() != null) { /* if the node only has left branch*/
			if(node.getParent().getRightNode() == node) {
				node.getParent().setRightNode(node.getLeftNode());
			} else if(node.getParent().getLeftNode() == node) {
				node.getParent().setLeftNode(node.getLeftNode());
			}
			
		} else {
			if(node.getParent().getRightNode() == node) {
				node.getParent().setRightNode(null);
			} else if(node.getParent().getLeftNode() == node) {
				node.getParent().setLeftNode(null);
			}
		}
	
//		node.setRightNode(null);
//		node.setLeftNode(null);
		return true;
	}

	public boolean delete(E data){
		TreeNode<E> node = find(data);
		return deleteNode(node);
	}
	
	/* printing tree in traversal. */
	@SuppressWarnings("unchecked")
	public void printPostOrder() {
		postOrderTraverse(root, node ->{
			System.out.print(node.getData() + "-");
		});
	}

	@SuppressWarnings("unchecked")
	public void printPreOrder() {
		preOrderTraverse(root, node ->{
			System.out.print(node.getData() + "-");
		});
	}

	@SuppressWarnings("unchecked")
	public void printInOrder() {
		inOrderTraverse(root, node ->{
			System.out.print(node.getData() + "-");
		});
	}
	
	@SuppressWarnings("unchecked")
	public void printLevelOrder() {
		levelOrderTraverse(root, node ->{
			System.out.print(node.getData() + "-");
		});
	}
}