package com.interviewprep.trie;

public class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode node = root; // Set the current node to the root

        // Loop through each character in the word
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            // If the character is not in the current node's children, add it
            if (!node.children.containsKey(ch)) {
                node.children.put(ch, new TrieNode());
            }

            // Move to the next node
            node = node.children.get(ch);
        }

        // Mark the end of the word
        node.isEndOfWord = true;
    }

    int query(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.isEndOfWord ? 1 : 0;
    }

    boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.children.containsKey(ch)) return false;
            node = node.children.get(ch);
        }
        return true;
    }
}
