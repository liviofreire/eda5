package br.ufc.crateus.eda.st.trie;

public class RWayTrieST<V> implements StringST<V> {
	private static final int R = 256;
	private Node root = new Node();
	
	private static class Node {
		Object value;
		Node[] next = new Node[R];
	}

	@Override
	public void put(String key, V value) {
		root = put(root, key, value, 0);
	}
	
	private Node put(Node r, String key, V value, int i) {
		if (r == null) r = new Node();
		if (i == key.length()) {
			r.value = value;
			return r;
		}
		int ch = key.charAt(i);
		r.next[ch] = put(r.next[ch], key, value, i + 1);
		return r;
	}

	@SuppressWarnings("unchecked")
	@Override
	public V get(String key) {
		Node node = get(root, key, 0);
		return (node != null)? (V) node.value : null;
	}
	
	private Node get(Node r, String key, int i) {
		if (r == null) return null;
		if (i == key.length()) {
			return (r.value != null)? r : null;
		}
		int ch = key.charAt(i);
		return get(r.next[ch], key, i + 1);
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
