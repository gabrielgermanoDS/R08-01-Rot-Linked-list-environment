package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {
		
	}

	@Override
	public void insertFirst(T element) {

		if (element == null) {
			return;
		}

		RecursiveDoubleLinkedListImpl<T> auxFirst = new RecursiveDoubleLinkedListImpl<>();
		auxFirst.setData(this.data);
		auxFirst.setNext(this.next);
		auxFirst.setPrevious(this);

		this.next = auxFirst;
		this.data = element;

	}

	@Override
	public void insert(T element) {

		if (element == null) {
			return;
		}

		if (isEmpty()) {
			data = element;
			next = new RecursiveDoubleLinkedListImpl<>();
			if (previous == null) {
				previous = new RecursiveDoubleLinkedListImpl<>();
			}
			((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
		} else {
			next.insert(element);
		}
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			return;
		}
	
		if (next.isEmpty() && previous.isEmpty()) {
			next = null;
			previous = null;
			data = null;
		} else {
			data = next.data;
			next = next.getNext();
			((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			if (next.isEmpty()) {
				if (previous.isEmpty()) {
					previous = null;
				}
				next = null;
				data = null;
			} else {
				((RecursiveDoubleLinkedListImpl<T>) next).removeLast();
			}
		} 
	}

	@Override
	public void remove(T element) {
		if (data.equals(element)) {
			if (previous.isEmpty()) {
				removeFirst();
			} else if (next.isEmpty()){
				removeLast();
			} else {
				this.data = next.getData();
				this.next = next.getNext();

				((RecursiveDoubleLinkedListImpl<T>) next).setPrevious(this);
			}
		} else {
			next.remove(element);
		}
	}


	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
