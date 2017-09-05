package treesAndGraphs;

import java.util.HashMap;

public class Trie {
	private class TrieNode {
		boolean endOfWord;
		HashMap<Character, TrieNode> neighbour;

		public TrieNode() {
			this.endOfWord = false;
			this.neighbour = new HashMap<>();
		}
	}

	private final TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.neighbour.get(ch);
			if (node == null) {
				node = new TrieNode();
				current.neighbour.put(ch, node);
			}
			current = node;
		}
		current.endOfWord = true;

	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = current.neighbour.get(ch);
			if (node == null) {
				return false;
			} else {
				current = node;
			}
		}
		return current.endOfWord;
	}

	public void delete(String word) {
		deleteRecursion(root, word, 0);
	}

	public boolean deleteRecursion(TrieNode current, String word, int index) {
		if (index == word.length()) {
			if (!current.endOfWord) {
				return false;
			}
			current.endOfWord = false;
			return current.neighbour.size() == 0;
		}
		char ch = word.charAt(index);
		TrieNode node = current.neighbour.get(ch);
		if (node == null) {
			return false;
		}
		boolean flagToDelete = deleteRecursion(node, word, index + 1);
		if (flagToDelete) {
			current.neighbour.remove(ch);
			return current.neighbour.size() == 0;
		}
		return false;
	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("abc");
		trie.insert("abdd");
		trie.insert("abcd");
		trie.insert("abhc");
		trie.delete("abhc");
		System.out.println(trie.search("abhc"));
	}

}
