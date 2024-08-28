package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<T>();
		this.last = (DoubleLinkedListNode<T>) this.head;
	}

	@Override
	public void insert(T element) {
		DoubleLinkedListNode<T> auxLast = new DoubleLinkedListNode<>();
		auxLast.setData(element);
		auxLast.setPrevious(last);
		auxLast.setNext(new DoubleLinkedListNode<>());

		last.setNext(auxLast);

		if (last.isNIL()) {
			head = auxLast;
		}

		last = auxLast;
	}

	@Override
	public void insertFirst(T element) {
		DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<>();
		newHead.setData(element);
		newHead.setNext(head);
		newHead.setPrevious(new DoubleLinkedListNode<T>());

		((DoubleLinkedListNode<T>) this.head).setPrevious(newHead);

		if (head.isNIL()) {
			last = newHead;
		}

		head = newHead;
		
	}

	@Override
	public void removeFirst() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void removeLast() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}


	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
