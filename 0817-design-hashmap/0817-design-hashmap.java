class MyHashMap {
    
    private static final int SIZE = 10000;

    private Node[] table;

    public MyHashMap() {
        table = new Node[SIZE];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new Node(key, value);
            return;
        }
        
        Node node = table[index];
        while (true) {
            if (node.key == key) {
                node.value = value;
                return;
            }
            if (node.next == null) {
                break;
            }
            node = node.next;
        }
        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node node = table[index];

        while (node != null) {
            if (node.key == key) {
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node current = table[index];
        Node prev = null;

        if (current == null) {
            return;
        }

        if (current.key == key) {
            table[index] = current.next;
            return;
        }

        while (current != null) {
            if (current.key == key) {
                if (prev == null) {
                    table[index] = current.next;
                    return;
                }
                prev.next = current.next;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    private int hash(int key) {
        return key % SIZE;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
