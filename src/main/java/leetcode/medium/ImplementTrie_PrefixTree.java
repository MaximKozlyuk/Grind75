package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/implement-trie-prefix-tree/description/
 */
public class ImplementTrie_PrefixTree {

    public ImplementTrie_PrefixTree() {}

    private final Set<String> state = new HashSet<>();

    public void insert(String word) {
        state.add(word);
    }

    public boolean search(String word) {
        return state.contains(word);
    }

    public boolean startsWith(String prefix) {
        return state.stream().anyMatch(word -> word.startsWith(prefix));
    }

}
