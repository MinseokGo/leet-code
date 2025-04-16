class MyCircularQueue {

    int maxSize;
    int front;
    int rear;
    int size;
    int[] queue;

    public MyCircularQueue(int k) {
        maxSize = k;
        front = -1;
        rear = -1;
        size = 0;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            if (size == 0) {
                queue[0] = value;
                front = 0;
                rear = 0;
            } else {
                queue[++rear % maxSize] = value;
            }
            size += 1;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % maxSize;
            size -= 1;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (!isEmpty()) {
            return queue[front % maxSize];
        }
        return -1;
    }
    
    public int Rear() {
         if (!isEmpty()) {
            return queue[rear % maxSize];
        }
        return -1;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}
