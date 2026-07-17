package linkedList;

public class ListNode<E> {
	ListNode<E> next;
	ListNode<E> prev;
	E data;
	
	public ListNode(E data) {
		this.data = data;
	}
	
	void delete() {
		prev.next = next;
		next.prev = prev;
		
		next = null;
		prev = null;
		data = null;
		
		/*
		 * finalize(), this method was used in java to destruct objects before being
		 * deprecated in java9, and removed in java 18
		 * if nothing points to the object, java garbage collector cleans it;
		 */
		//finalize();
	}
	
}
