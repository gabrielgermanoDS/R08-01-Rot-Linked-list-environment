package adt.linkedList;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class RecursiveDoubleLinkedListTest {

    private RecursiveDoubleLinkedListImpl<Integer> lista1;
    private RecursiveDoubleLinkedListImpl<Integer> lista2;

    @Before
    public void setUp() {
        getImplementations();

        lista1.insert(1);
        lista1.insert(2);
        lista1.insert(3);
    }

    private void getImplementations() {
        this.lista1 = new RecursiveDoubleLinkedListImpl<>();
        this.lista2 = new RecursiveDoubleLinkedListImpl<>();
    }

    @Test
    public void testInsert() {
        lista1.insert(4);
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, lista1.toArray());
    }

    @Test
    public void testSearch() {
        assertEquals(new Integer(3), lista1.search(3));
    }

    @Test
    public void insertFirst() {
        lista1.insertFirst(4);
        assertArrayEquals(new Integer[] {4, 1, 2, 3}, lista1.toArray());
    }

    @Test
    public void insertFirst2() {
        lista2.insertFirst(1);
        assertArrayEquals(new Integer[] {1}, lista2.toArray());
    }

    @Test
    public void insert() {
        lista1.insert(4);
        assertArrayEquals(new Integer[] {1, 2, 3, 4}, lista1.toArray());
    }

    @Test
    public void insert2() {
        lista2.insert(1);
        assertArrayEquals(new Integer[] {1}, lista2.toArray());
    }

    @Test
    public void removeFirst1() {
        lista1.removeFirst();
        assertArrayEquals(new Integer[] {2, 3}, lista1.toArray());
    }

    @Test
    public void removeLast1() {
        lista1.removeLast();
        assertArrayEquals(new Integer[] {1, 2}, lista1.toArray());
    }

    @Test
    public void remove1() {
        lista1.remove(2);
        assertArrayEquals(new Integer[] {1, 3}, lista1.toArray());
    }

    @Test
    public void remove2() {
        lista1.remove(3);
        assertArrayEquals(new Integer[] {1, 2}, lista1.toArray());
    }

    
}
