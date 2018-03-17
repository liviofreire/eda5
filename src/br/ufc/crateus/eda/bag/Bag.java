package br.ufc.crateus.eda.bag;

public interface Bag<E> extends Iterable<E>{
	boolean add(E e);
	
	void addAll(Bag<? extends E> c);
	
	void clear();
	
	boolean contains(E o);
	
	boolean containsAll(Bag<E> c);
	
	boolean isEmpty();
	
	boolean remove(E e);
	
	void removeAll(Bag<E> c);
	
	void retainAll(Bag<E> c);
	
	int size();
}
