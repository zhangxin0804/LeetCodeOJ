// Solution 1 --- 注意：search操作中涉及到backtracking递归回溯, 调整代码！！！
// 时间复杂度: O( 26 ^ k ) ~~ Worst Case, 假设k个字符都为.
// 空间复杂度: O( 26 ^ k ), k为每个word的平均长度。

class Trie{
    // inner class
    class TrieNode{
        char letter;
        boolean isWord;
        TrieNode[] branch;
        
        TrieNode(){
            branch = new TrieNode[26]; 
        }
        TrieNode(char c){
            letter = c;
            branch = new TrieNode[26]; 
        }
    }
    // instance variable
    TrieNode root;
    // constructor
    public Trie(){
       root = new TrieNode(); 
    }
    
    public void insert(String word){
        if( word == null || word.length() == 0 ){
            return;
        }
        TrieNode tmp = root;
        int length = word.length();
        for(int i = 0; i < length; i++){
            char c = word.charAt(i);
            if( tmp.branch[c-'a'] == null ){
                TrieNode newNode = new TrieNode(c);
                tmp.branch[c-'a'] = newNode;
            }
            tmp = tmp.branch[c-'a'];
        }
        tmp.isWord = true;
    }
    
    public boolean search(String word){
        if( word == null || word.length() == 0 ){
            return false;
        }
        TrieNode tmp = root;
        return helper(tmp, word, 0);
    }
    
    private boolean helper(TrieNode crt, String word, int index){
        // 注意递归终止条件的顺序，不能轻易调换。
        if( crt == null ){
            return false;
        }
        if( index == word.length() ){
            if( crt.isWord ){
                return true;
            }
            return false;
        }
        char c = word.charAt(index);
        if( c == '.' ){
            for(int i = 0; i < crt.branch.length; i++){
                if( helper(crt.branch[i], word, index + 1) ){
                    return true;
                }
            }
            return false;
        }else{
            return helper(crt.branch[c-'a'], word, index + 1);
        }
    }
}


public class WordDictionary {
    
    private Trie trie;

    public WordDictionary(){
        trie = new Trie();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        if( word == null || word.length() == 0 ){
            return;
        }
        trie.insert(word);
    }
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return trie.search(word);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");
