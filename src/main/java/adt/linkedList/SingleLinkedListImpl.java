package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return head.isNIL();
	}

	@Override
	public int size() {
		int count = 0;

		if (this.isEmpty()) {
			return count;
		}

		SingleLinkedListNode<T> auxHead = head;
		while (!auxHead.isNIL()) {
			count = count + 1;
			auxHead = auxHead.getNext();
		}

		return count;
	}

	@Override
	public T search(T element) {

		SingleLinkedListNode<T> auxHead = head;

		while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
			auxHead = auxHead.getNext();
		}

		return auxHead.getData();
	}

	@Override
	public void insert(T element) {

		if (element == null) {
			return;
		}

		SingleLinkedListNode<T> auxHead = head;
		
		if (head.isNIL()) {

			SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, head);
			head = newHead;

		} else {

			while (!auxHead.isNIL()) {
				auxHead = auxHead.getNext();
			}

			auxHead.setData(element);
			auxHead.setNext(new SingleLinkedListNode<>());
		}

		
		
	}

	@Override
	public void remove(T element) {

		if (element == null) {
			return;
		}

		if (isEmpty()) {
			return;
		}

		if (head.getData().equals(element)) {
			head = head.getNext();
		}

		SingleLinkedListNode<T> auxHead = head;

		while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
			auxHead = auxHead.getNext();
		}

		if (!auxHead.isNIL()) {
			auxHead.setData(auxHead.getNext().getData());
			auxHead.setNext(auxHead.getNext().getNext());
		}
		

	}

	@Override
	public T[] toArray() {
		int size = this.size();
		T[] array = (T[]) new Object[size];

		SingleLinkedListNode<T> auxHead = head;

		int i = 0;
		while (i < size) {
			array[i] = auxHead.getData();
			auxHead = auxHead.getNext();
			i++;
		}

		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
