package linkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class TestingMyLinkedList {

	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> list;
	MyLinkedList<Integer> list1;

	@Before
	public void setUp() {
		
		 list = new MyLinkedList<Integer>();
		 list.add(3);
		 
		 list1 = new MyLinkedList<>();
		 
		 emptyList =  new MyLinkedList<>();
		 
		 
		 Integer arr[] = {(Integer)65, (Integer)21, 42};
		 
		 list1.addAll(arr);
		 
	}
	
	@Test
	public void testGet() {
		
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}

		try {
			list.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		assertEquals(3, list.get(0).intValue());
		
		try {
			System.out.println(list.get(1));
			fail("Out of bound exception didn't work");
		}
		catch(IndexOutOfBoundsException e) {
			
		}

		list.add(44);
		list.add(45);

		assertEquals(45, list.get(2).intValue());

		list.add(67);

		assertEquals(67, list.get(3).intValue());
		
//		list.addAll(3, 4, 5, 5);	how to make it like * in Python
		Integer[] integerList = {7, 8767, 9};
		
		list.addAll(integerList);
//		System.out.println(list.get(4));
//		System.out.println(list.get(5));
//		System.out.println(list.get(6));
		assertEquals(7, list.get(4).intValue());
		assertEquals(8767, list.get(5).intValue());
		assertEquals(9, list.get(6).intValue());

		try {
			list.get(7);
			list.get(8); 
			list.get(9);
			fail("Out of bound exception didn't work");
		}
		catch(IndexOutOfBoundsException e) {
			
		}

	}
	
	@Test
	public void testRemove() {
		
		assertEquals((Integer)65, list1.remove(0));
		assertEquals((Integer)21, list1.get(0));
		assertEquals((Integer)42, list1.get(1));
		
		assertEquals(2, list1.size());
		
		assertEquals(list1.head, list1.getNode(0).prev);

		
	}

	public static void main(String[] args) {

	}
}
