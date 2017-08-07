package myList;

import java.util.ArrayList;
import java.util.Collection;

public class MyArrayList<E> extends ArrayList<E>{
	
	private static final String invalidMessage = "In this arraylist you cannot delete elements. Sorry";
	
	@Override
	public E set(int index, Object element) {
		throw new UnsupportedOperationException(invalidMessage);
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException(invalidMessage);
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException(invalidMessage);
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException(invalidMessage);
	}

	@Override
	protected void removeRange(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException(invalidMessage);
	}

	@Override
	public boolean removeAll(Collection c) {
		throw new UnsupportedOperationException(invalidMessage);
	}
}