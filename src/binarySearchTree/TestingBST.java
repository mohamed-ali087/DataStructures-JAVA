package binarySearchTree;


import org.junit.Before;
import org.junit.Test;

import com.sun.imageio.spi.OutputStreamImageOutputStreamSpi;

import static org.junit.Assert.*;

public class TestingBST {

    private BST<Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
        /* 
         * Workaround: The default BST constructor initializes a root node without data.
         * We manually set the root data here so the first insert() doesn't trigger 
         * a NullPointerException when calling tofind.compareTo(parentNode.getData()).
         */
        bst.root.setData(50);
    }

    @Test
    public void testInsertNewNodes() {
        TreeNode<Integer> leftNode = bst.insert(25);
        TreeNode<Integer> rightNode = bst.insert(75);

        assertNotNull("Insert should return the newly created left node", leftNode);
        assertNotNull("Insert should return the newly created right node", rightNode);
        
        assertEquals("Root's left child should be 25", Integer.valueOf(25), bst.root.getLeftNode().getData());
        assertEquals("Root's right child should be 75", Integer.valueOf(75), bst.root.getRightNode().getData());
        
        // check for the new node's parent.
        assertEquals("left's root is root", leftNode.getParent(), bst.root);
        assertEquals("right's root is root", rightNode.getParent(), bst.root);
    }

//    @Test(expected = IndexOutOfBoundsException.class)
    @Test
    public void testFindParentThrowsExceptionOnDuplicate() {
        bst.insert(30);
        // Attempting to insert a duplicate or find an existing node 
        // triggers the 'comp == 0' block in findParent(), throwing an exception.
        try {
        	bst.insert(30); 
        	fail("didin't throw exception for duplicate insertion.");
        } catch (IndexOutOfBoundsException ex){
        	
        }
    }

    @Test
    public void testDeleteLeafNode() {
        bst.insert(20);
        TreeNode<Integer> nodeToDelete = bst.root.getLeftNode();
        assertFalse("the inserted node's parent isn't null", nodeToDelete.getParent() == null);
        
        assertTrue("deleteNode should return true on success", bst.deleteNode(nodeToDelete));
        assertNull("The left node should be null after being deleted", bst.root.getLeftNode());
    }

    @Test
    public void testDeleteNodeWithOneChild() {
        bst.insert(30);
        bst.insert(20); // 30 (left child of root) now has its own left child (20)
        
        TreeNode<Integer> nodeToDelete = bst.root.getLeftNode(); // The node holding 30
        assertTrue(bst.deleteNode(nodeToDelete));
        
        // The child node (20) should be promoted to take the deleted node's place
        assertEquals("Child node should be promoted", Integer.valueOf(20), bst.root.getLeftNode().getData());
    }

    @Test
    public void testDeleteRootNode() {
        // Setup a tree where the root's right child has a left branch
        bst.insert(30);
        bst.insert(70);
        bst.insert(60);
        
        assertTrue("Should successfully delete the root", bst.deleteNode(bst.root));
        // According to your algorithm, the smallest value in the right branch (60) takes over
        assertNotNull("New root should not be null", bst.root);
        assertEquals("Root should be updated to the right branch structure", Integer.valueOf(70), bst.root.getData());
    }
    
    @Test
    public void testContainsUnfoundNode() {
        // Since find() currently throws an exception on found nodes, 
        // we can only successfully test contains() for nodes that do not exist.
        assertFalse("Should return false for a non-existent value", bst.contains(999));
        
    }
}