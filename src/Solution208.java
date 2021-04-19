/**
 * @Author Yifan Wu
 * Date on 2021/4/16  19:10
 */
public class Solution208 {
    class Trie {
        Trie[] children;
        boolean isEnd;
        /** Initialize your data structure here. */
        public Trie() {
            children = new Trie[26];
            isEnd = false ;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie node = this;
            char[] chars = word.toCharArray();
            for(char c:chars){
                int ch = c-'a';
                if(node.children[ch]==null){
                    node.children[ch] = new Trie();
                }
                node = node.children[ch];
            }
            node.isEnd = true; //该单词的末尾
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie node = searchPrefix(word);
            return node!=null&&node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie node = searchPrefix(prefix);
            return node!=null;
        }

        private Trie searchPrefix(String word){
            Trie node = this;
            char[] chars = word.toCharArray();
            for(char c : chars){
                int ch = c-'a';
                if(node.children[ch]==null){
                    return null;
                }
                node = node.children[ch];
            }
            return node;
        }


    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
