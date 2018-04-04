package br.ufc.crateus.eda.st;

public class BinarySearchTreeST<K extends Comparable<K>, V> implements OrderedST<K, V> {
	
	private class Node {
		K key;
		V value;
		Node left;
		Node right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	Node root;
	
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new Node(key, value); 
		
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
	
		return r;
	}

	@Override
	public void put(K key, V value) {
		if (value != null) 
			root = put(root, key, value);
		else
			this.delete(key);
	}
	
	private Node getNode(Node r, K key) {
		if (r == null) return null;
		
		int cmp = key.compareTo(r.key);
		if (cmp < 0) return getNode(r.left, key);
		if (cmp > 0) return getNode(r.right, key);
		return r;
	}

	@Override
	public V get(K key) {
		Node node = getNode(root, key);
		return (node != null)? node.value : null;
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public void delete(K key) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterable<K> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K min() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K max() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K floor(K e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K ceiling(K e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K select(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int rank(K e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteMin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMax() {
		// TODO Auto-generated method stub

	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
	}

}
