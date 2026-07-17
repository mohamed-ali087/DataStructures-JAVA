package linkedList;

public class MyLinkedList<E> /*implements List*/{
	protected ListNode<E> head;
	protected ListNode<E> tail;
	protected int size;
	
	public MyLinkedList() {
		
		size = 0;
		head = new ListNode<E>(null);
		tail = new ListNode<E>(null);
		
		head.data = null;
		tail.data = null;
		
		head.next = tail;
		tail.prev = head;
	}

	/*	Programming Assignment
	 * #TODO: Implement
	 * - size()
	 * - get()
	 * - add()
	 * - remove()
	 * 
	 */
	public int size() {
		return size;
	}
	
	protected ListNode<E> getNode(int index) {


		if(index > (size - 1) || index < 0) {

			throw new IndexOutOfBoundsException();
			
		}
		
		/*
		 * #TODO:
		 * 	start from either the head or the tail depending on which one is closer to the element
		 * #DONE
		 */

		ListNode<E> currentNode;

		if(index + 1 <= size()/2) {
			currentNode = head;
			
			int currentIndex = -1;
			
			// dereference next node till reaching the element index
			while(currentIndex < index && currentIndex < size) {
				currentNode = currentNode.next;
				
				currentIndex++;
			}
		} else {
			currentNode = tail;
			
			int currentIndex = size;
			
			// dereference next node till reaching the element index
			while(currentIndex > index && currentIndex <= size) {
				currentNode = currentNode.prev;
				
				currentIndex--;
			}
			
		}
		
		
		return currentNode;
		

	}
	
	public E get(int index) {
		return getNode(index).data;
	}
	
	public void add(E data) throws NullPointerException{
		
		if(data == null) {
			throw new NullPointerException();
		}
		
		ListNode<E> newNode = new ListNode<>(data);
		
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		
		size++;
	}
	
	public void addFront(E data) {

		if(data == null) {
			throw new NullPointerException();
		}

		ListNode<E> newNode = new ListNode<E>(data);
		
		newNode.next = head.next;
		newNode.prev = head; // a more general: newNode.next.prev;
		head.next.prev = newNode; // newNode.next.prev
		head.next = newNode; 
		
		size++;
		
	}
	
	public void addAll(E[] data) {

		
		for(E element: data) {
			if(element == null) {
				throw new NullPointerException();
			}
			add(element);
		}
	}
	
	public E removeDataFromFront(E data) {
		int currentIndex = -1;
		ListNode<E> currentNode = head;
		
		while(currentIndex <= size()) {
			
			currentNode = currentNode.next;
			
			if(currentNode.data == data) {
				currentNode.delete();
			}
			
			currentIndex++;
		}
		return data;
	}
	
	
	protected ListNode<E> removeNode(int index){
		ListNode<E> node = getNode(index); // this holds the reference of the data
		
		node.next.prev = node.prev;
		node.prev.next = node.next;
		
		node.next = null;
		node.prev = null;
		
		size--;

		return node; // returning the reference of the removed data, garbage collector won't delete data from memory if this reference is stored.
		
	}
	
	public E remove(int index) {
		return removeNode(index).data;
	}
}
