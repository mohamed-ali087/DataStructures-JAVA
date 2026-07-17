package linkedList;

public class SLLNode<E> {
	SLLNode<E> next;
	E data;
	
	public SLLNode() {
		next = null;
		data = null;
	}
	
	public SLLNode(E data) {
		this.data = data;
	}
	
	public SLLNode(E data, SLLNode<E> prevNode) {
		this(data);

		this.next = prevNode.next;
		prevNode.next = this;
		
	}
	
}
