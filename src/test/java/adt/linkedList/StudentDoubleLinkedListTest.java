package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentDoubleLinkedListTest extends StudentLinkedListTest {

	private DoubleLinkedList<Integer> lista3;

	@Before
	public void setUp() throws Exception {

		getImplementations();

		// Lista com 3 elementos.
		lista1.insert(3);
		lista1.insert(2);
		lista1.insert(1);

		// Lista com 1 elemento.
		lista3.insert(1);
	}

	private void getImplementations() {
		// TODO O aluno deve ajustar aqui para instanciar sua implementação
		lista1 = new DoubleLinkedListImpl<Integer>();
		lista2 = new DoubleLinkedListImpl<Integer>();
		lista3 = new DoubleLinkedListImpl<Integer>();
	}

	// Métodos de DoubleLinkedList

	@Test
	public void testInsertFirst() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Assert.assertArrayEquals(new Integer[] { 4, 3, 2, 1 }, lista1.toArray());
	}

	@Test
	public void testInsert() {
		((DoubleLinkedList<Integer>) lista1).insert(4);
		Integer data = ((DoubleLinkedListImpl<Integer>) lista1).getLast().getData();
		assertEquals( new Integer(4), data);
	}

	@Test
	public void testInsertFirst2() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Integer data = ((DoubleLinkedListImpl<Integer>) lista1).getHead().getData();
		assertEquals( new Integer(4), data);
	}

	@Test
	public void testInsertFirst3() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		Integer data = ((DoubleLinkedListImpl<Integer>) lista1).getHead().getNext().getNext().getData();
		assertEquals( new Integer(2), data);
	}

	@Test
	public void testToArray() {
		Assert.assertArrayEquals(new Integer[] {3, 2, 1}, lista1.toArray());
	}

	@Test
	public void testToArray2() {
		Assert.assertArrayEquals(new Integer[] {1}, lista3.toArray());
	}

	@Test
	public void testRemoveFirst() {
		((DoubleLinkedList<Integer>) lista1).removeFirst();
		Assert.assertArrayEquals(new Integer[] { 2, 1 }, lista1.toArray());
	}

	@Test
	public void testRemoveLast() {
		((DoubleLinkedList<Integer>) lista1).removeLast();
		Assert.assertArrayEquals(new Integer[] { 3, 2 }, lista1.toArray());
	}

	@Test
	public void testSize() {
		int size = ((DoubleLinkedList<Integer>) lista1).size();
		assertEquals(3, size);
	}

	@Test
	public void testSize2() {
		((DoubleLinkedList<Integer>) lista1).insertFirst(4);
		int size = ((DoubleLinkedList<Integer>) lista1).size();
		assertEquals(4, size);
	}

	@Test
	public void testRemove1() {
		lista1.remove(3);
		assertArrayEquals(new Integer[] {2, 1}, lista1.toArray());
	}

	@Test
	public void testRemove2() {
		lista1.remove(2);
		assertArrayEquals(new Integer[] {3, 1}, lista1.toArray());
	}

	@Test
	public void testRemove3() {
		lista1.remove(1);
		assertArrayEquals(new Integer[] {3, 2}, lista1.toArray());
	}
}