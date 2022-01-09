import java.util.*;
/*
Store word list as a Trie and run dfs on each board character across the trie to see if it exists.
Optimize by pruning leaf node if visited and removing word from TrieNodes if added to result.
*/
class Solution {
    class TrieNode {
        Map<Character, TrieNode> letters;
        String word;
        TrieNode() {
            letters = new HashMap<>();
            word = null;
        }
    }
    
    char[][] board;
    List<String> res;
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode head = new TrieNode();
        for(String word : words) addWordToTrie(head, word);
        this.board = board;
        this.res = new ArrayList<>();
        
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[0].length; ++j) {
                if(head.letters.containsKey(board[i][j])) {
                    wordSearch(head, i, j);
                }
            }
        }
        return res;
    }
    
    private void addWordToTrie(TrieNode trav, String word) {
        for(char c : word.toCharArray()) {
            trav.letters.putIfAbsent(c, new TrieNode());
            trav = trav.letters.get(c);
        }
        trav.word = word;
    }
    
    private void wordSearch(TrieNode parent, int i, int j){
        char c = board[i][j];
        TrieNode curr = parent.letters.get(c);
        
        if(curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        
        board[i][j] = '#';
        
        for(int[] d : dirs) {
            int newI = i + d[0];
            int newJ = j + d[1];
            if(newI < 0 || newJ < 0 || newI == board.length || newJ == board[0].length) continue;
            if(curr.letters.containsKey(board[newI][newJ])) {
                wordSearch(curr, newI, newJ);
            }
        }
        
        board[i][j] = c;
        
        if(curr.letters.isEmpty()) parent.letters.remove(c);
    }
}