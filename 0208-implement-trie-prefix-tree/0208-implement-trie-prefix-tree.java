class Trie {
    
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord;
    }

    private final TrieNode rootNode;

    public Trie() {
        rootNode = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode currentNode = rootNode;
        for (char currentChar : word.toCharArray()) {
            int charIndex = currentChar - 'a';
            if (currentNode.children[charIndex] == null) {
                currentNode.children[charIndex] = new TrieNode();
            }
            currentNode = currentNode.children[charIndex];
        }
        currentNode.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode endNode = findNode(word);
        return endNode != null && endNode.isEndOfWord;
    }
    
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    private TrieNode findNode(String str) {
        TrieNode currentNode = rootNode;
        for (char currentChar : str.toCharArray()) {
            int charIndex = currentChar - 'a';
            if (currentNode.children[charIndex] == null) {
                return null;
            }
            currentNode = currentNode.children[charIndex];
        }
        return currentNode;
    }
}
