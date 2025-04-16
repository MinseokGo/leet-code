class MyCircularQueue {

    int maxSize;
    int front;
    int rear;
    int size;
    int[] queue;

    public MyCircularQueue(int k) {
        maxSize = k;
        front = 0;
        rear = -1;
        size = 0;
        queue = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            queue[rear] = value;
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
            return queue[front];
        }
        return -1;
    }
    
    public int Rear() {
         if (!isEmpty()) {
            return queue[rear];
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
