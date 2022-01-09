/*
create TrieNode which contains an array of 26 TrieNodes representing the 26 letters
and a boolean flag that represents the end of a word.
*/
class Trie {
    class TrieNode {
        TrieNode[] letters;
        boolean isEnd;
        TrieNode() {
            letters = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode head;
    public Trie() {
        head = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode trav = head;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(trav.letters[i] == null) {
                trav.letters[i] = new TrieNode();
            }
            trav = trav.letters[i];
        }
        trav.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode trav = head;
        for(char c : word.toCharArray()) {
            int i = c - 'a';
            if(trav.letters[i] == null) return false;
            trav = trav.letters[i];
        }
        return trav.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode trav = head;
        for(char c : prefix.toCharArray()) {
            int i = c - 'a';
            if(trav.letters[i] == null) return false;
            trav = trav.letters[i];
        }
        return true;
    }
}