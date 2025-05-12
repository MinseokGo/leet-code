class Trie {

    Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        root.insert(word, 0);
    }
    
    public boolean search(String word) {
        return root.search(word, 0);
    }
    
    public boolean startsWith(String prefix) {
        return root.startsWith(prefix, 0);
    }

    static class Node {
        Node[] nodes;
        boolean hasEnd;

        Node() {
            nodes = new Node[26];
        }

        private void insert(String word, int index) {
            if (index >= word.length()) {
                return;
            }

            int insertIndex = word.charAt(index) - 'a';
            if (nodes[insertIndex] == null) {
                nodes[insertIndex] = new Node();
            }

            if (index == word.length() - 1) {
                nodes[insertIndex].hasEnd = true;
            }

            nodes[insertIndex].insert(word, index + 1);
        }

        private boolean search(String word, int index) {
            if (index >= word.length()) {
                return false;
            }

            int searchIndex = word.charAt(index) - 'a';
            Node findNode = nodes[searchIndex];
            if (findNode == null) {
                return false;
            }

            if (index == word.length() - 1 && findNode.hasEnd) {
                return true;
            }

            return findNode.search(word, index + 1);
        }

        private boolean startsWith(String word, int index) {
            if (index >= word.length()) {
                return false;
            }

            int searchIndex = word.charAt(index) - 'a';
            Node findNode = nodes[searchIndex];
            if (findNode == null) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            return findNode.startsWith(word, index + 1);
        }
    }  
}
