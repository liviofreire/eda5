package br.ufc.crateus.eda.bag;

import java.util.Iterator;

public class LinkedListBag<E> extends AbstractListBag<E> {
	
	private class Node {
		E element;
		Node next;
	}
	
	private Node list;

	@Override
	public boolean add(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(E e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iterator<E>() {
			
			Node lst = list;

			@Override
			public boolean hasNext() {
				return lst != null;
			}

			@Override
			public E next() {
				E element = lst.element;
				lst = lst.next;
				return element;
			}
		};
	}

	@Override
	public int indexOf(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(E o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public E remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractListBag<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
