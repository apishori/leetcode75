/*
Use trie to store words and to search run dfs on the trie
*/
class WordDictionary {
    class TrieNode {
        TrieNode[] letters;
        boolean isEnd;
        TrieNode() {
            letters = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode head;
    
    public WordDictionary() {
        head = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode trav = head;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(trav.letters[i] == null) trav.letters[i] = new TrieNode();
            trav = trav.letters[i];
        }
        trav.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchTrie(word, head, 0);
    }
    
    private boolean searchTrie(String word, TrieNode trav, int i) {
        if(trav == null) return false;
        if(i == word.length()) return trav.isEnd;
        
        char c = word.charAt(i);
        if(c != '.') return searchTrie(word, trav.letters[c - 'a'], i + 1);
        
        for(TrieNode t : trav.letters) {
            if(searchTrie(word, t, i + 1)) return true;
        }
        return false;
    }
}
