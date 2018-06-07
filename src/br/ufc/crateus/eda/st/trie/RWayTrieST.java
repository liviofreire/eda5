package br.ufc.crateus.eda.st.trie;

import java.util.LinkedList;
import java.util.Queue;

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
			return r;
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
		delete(root, key, 0);
	}
	
	private Node delete(Node r, String key, int i) {
		if (r == null) return null;
		if (i == key.length()) r.value = null;
		else {
			char ch = key.charAt(i);
			r.next[ch] = delete(r.next[ch], key, i + 1);
		}
		
		if (r.value != null) return r;
		for (Node n : r.next) if (n != null) return r;
		return null;
	}
	
	private void collect(Node r, String prefix, Queue<String> queue) {
		if (r != null) {
			if (r.value != null) queue.add(prefix); 
			for (char i = 0; i < R; i++)
				collect(r.next[i], prefix + i, queue);
		}
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
		Queue<String> queue = new LinkedList<>();
		collect(root, "", queue);
		return queue;
	}

	@Override
	public String longestPrefixOf(String str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<String> keysWithPrefix(String prefix) {
		Node node = get(root, prefix, 0);
		Queue<String> queue = new LinkedList<>();
		collect(node, prefix, queue);
		return queue;
	}
	
	public static void main(String[] args) {
		StringST<Integer> st = new RWayTrieST<>();
		st.put("shells", 0);
		st.put("sea", 0);
		st.put("by", 0);
		st.put("shore", 0);
		st.put("the", 0);
		st.put("sells", 0);
		
		for (String str : st.keysWithPrefix(""))
			System.out.println(str);
	}
}
