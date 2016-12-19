package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	public RecursiveDoubleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next,
			RecursiveDoubleLinkedListImpl<T> previous) {
		super(data, next);
		this.previous = previous;
	}

	@Override
	public void insertFirst(T element) {
		if (isEmpty()) {
			this.setData(element);
		} else {
			RecursiveDoubleLinkedListImpl<T> node = new RecursiveDoubleLinkedListImpl<T>();
			node.data = this.data;
			node.next = this.next;
			node.previous = this.previous;
			this.data = element;
			this.next = node;

		}
	}

	@Override
	public void removeFirst() {
		if (isEmpty()) {
			return;
		} else {
			this.data = this.next.data;
			this.next = this.next.next;
		}
	}

	@Override
	public void removeLast() {
		if (next.isEmpty()) {
			this.previous.next= new RecursiveSingleLinkedListImpl<>() ;
		} else {
			((DoubleLinkedList<T>) next).removeLast();
		}
	}
	

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}