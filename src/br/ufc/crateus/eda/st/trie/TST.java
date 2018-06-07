package br.ufc.crateus.eda.st.trie;

public class TST<V> implements StringST<V> {
	
	private Node root;
	
	private class Node {
		V value;
		char ch;
		Node left, mid, right;
		
		public Node(char ch) {
			this.ch = ch;
		}
	}
	
	private Node put(Node r, String key, V value, int i) {
		char ch = key.charAt(i);
		if (r == null) r = new Node(ch);
		if (ch < r.ch) r.left = put(r.left, key, value, i);
		else if (ch > r.ch) r.right = put(r.right, key, value, i);
		else if (i == key.length() - 1) r.value = value;
		else r.mid = put(r.mid, key, value, i + 1);
		return r;
	}

	@Override
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}

	@Override
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? node.value : null;
	}
	
	private Node get(Node r, String key, int i) {
		if (r == null) return null;
		char ch = key.charAt(i);
		if (ch < r.ch) return get(r.left, key, i);
		if (ch > r.ch) return get(r.right, key, i);
		if (i == key.length() - 1) return r;
		return get(r.mid, key, i + 1);
	}

	@Override
	public boolean contains(String key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void delete(String key) {
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
	public Iterable<String> keys() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String longestPrefixOf(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<String> keysWithPrefix(String str) {
		// TODO Auto-generated method stub
		return null;
	}

}
