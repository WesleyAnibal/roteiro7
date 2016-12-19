package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}

	public RecursiveSingleLinkedListImpl(T data, RecursiveSingleLinkedListImpl<T> next) {
		this.data = data;
		this.next = next;
	}

	@Override
	public boolean isEmpty() {
		return this.data == null;
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		}
		return 1 + next.size();
	}

	@Override
	public T search(T element) {
		if (isEmpty()) {
			return null;
		}
		if (this.data.equals(element)) {
			return this.data;
		}
		if (next.getData() == null) {
			return null;
		}
		return next.search(element);
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			this.setData(element);
			this.setNext(new RecursiveSingleLinkedListImpl<>());
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (!isEmpty()) {
			if (this.data.equals(element)) {
				this.setData(getNext().getData());
				this.setNext(getNext().getNext());
			} else {
				next.remove(element);
			}
		} else {
			return;
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] x = (T[]) new Comparable[this.size()];
		toArray(x, 0);
		return x;

	}

	private void toArray(T[] array, int indice) {
		if (indice < array.length) {
			array[indice] = this.data;
			next.toArray(array, ++indice);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
