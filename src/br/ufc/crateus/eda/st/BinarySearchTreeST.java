package br.ufc.crateus.eda.st;

public class BinarySearchTreeST<K extends Comparable<K>, V> implements OrderedST<K, V> {
	
	private class Node {
		K key;
		V value;
		int count;
		Node left;
		Node right;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.count = 1;
		}
	}
	
	Node root;
	
	
	private Node put(Node r, K key, V value) {
		if (r == null) return new Node(key, value); 
		
		int cmp = key.compareTo(r.key);
		if (cmp < 0) r.left = put(r.left, key, value);
		else if (cmp > 0) r.right = put(r.right, key, value);
		else r.value = value;
		
		r.count = count(r.left) + count(r.right) + 1;
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
	
	private Node delete(Node r, K key) {
		if (r == null) return null;
		
		int cmp = key.compareTo(r.key); 
		if (cmp < 0) r.left = delete(r.left, key);
		else if (cmp > 0) r.right = delete(r.right, key);
		else {
			if (r.left == null) return r.right;
			if (r.right == null) return r.left;
			Node t = r;
			r = maxNode(r.left);
			r.right = t.right;
			r.left = deleteMax(t.left);
		}
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}

	@Override
	public boolean isEmpty() {
		return root == null;
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
	
	private Node minNode(Node r) {
		if (r == null) return null;
		while (r.left != null) r = r.left;
		return r;
	}

	@Override
	public K min() {
		Node m = minNode(root);
		return (m != null)? m.key : null;
	}
	
	private Node maxNode(Node r) {
		if (r == null) return null;
		while (r.right != null) r = r.right;
		return r;
	}

	@Override
	public K max() {
		Node m = maxNode(root);
		return (m != null)? m.key : null;
	}
	
	private K floor(Node r, K e) {
		if (r == null) return null;
		int cmp = e.compareTo(r.key);
		if (cmp < 0) return floor(r.left, e);
		if (cmp > 0) {
			K tmp = floor(r.right, e);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	}

	@Override
	public K floor(K e) {
		return floor(root, e);
	}
	
	private K ceiling(Node r, K e) {
		if (r == null) return null;
		int cmp = e.compareTo(r.key);
		if (cmp > 0) return ceiling(r.right, e);
		if (cmp < 0) {
			K tmp = ceiling(r.left, e);
			return (tmp != null)? tmp : r.key;
		}
		return r.key;
	}

	@Override
	public K ceiling(K e) {
		return ceiling(root, e);
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
	
	private int rank(Node r, K e) {
		if (r == null) return 0;
		
		int cmp = e.compareTo(r.key);
		if (cmp < 0)  return rank(r.left, e);
		if (cmp > 0) return count(r.left) + rank(r.right, e) + 1;
		return count(r.left) + 1;
	}

	@Override
	public int rank(K e) {
		return rank(root, e);
	}
	
	private Node deleteMin(Node r) {
		if (r.left == null) return r.right;
		r.left = deleteMin(r.left);
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}

	@Override
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	private Node deleteMax(Node r) {
		if (r.right == null) return r.left;
		r.right = deleteMax(r.right);
		
		r.count = count(r.left) + count(r.right) + 1;
		return r;
	}

	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}

	@Override
	public int size(K lo, K hi) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	private int count(Node node) {
		return (node != null)? node.count : 0;
	}

}
