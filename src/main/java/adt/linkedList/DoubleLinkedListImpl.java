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

		if (element == null) {
			return;
		}

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
		if (!head.isNIL()) {
			head = head.getNext();
			if (head.isNIL()) {
				last = (DoubleLinkedListNode<T>) head;
			} else {
				((DoubleLinkedListNode<T>) head).setPrevious(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void removeLast() {
		if (!last.isNIL()) {
			last = last.getPrevious();

			if (last.isNIL()) {
				head = last;
			} else {
				last.setNext(new DoubleLinkedListNode<T>());
			}
		}
	}

	@Override
	public void remove(T element) {

		if (element == null) {
			return;
		}

		if (head.getData().equals(element)) {
			removeFirst();
		} else {
			DoubleLinkedListNode<T> auxHead = (DoubleLinkedListNode<T>) head;

			while (!auxHead.isNIL() && !auxHead.getData().equals(element)) {
				auxHead = (DoubleLinkedListNode<T>) auxHead.getNext();
			}

			if (!auxHead.isNIL()) {
				((DoubleLinkedListNode<T>) auxHead.getNext()).setPrevious(auxHead.getPrevious());
				auxHead.getPrevious().setNext(auxHead.getNext());
			}
		}
	}


	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
