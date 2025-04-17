class MyCircularDeque {

    int[] deque;
    int front;
    int rear;
    int size;
    int maxSize;

    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = -1;
        size = 0;
        maxSize = k;
    }
    
    public boolean insertFront(int value) {
        if (!isFull()) {
            if (rear == -1) {
                deque[front] = value;
                rear = 0;
                size += 1;
                return true;
            }
            front -= 1;
            if (front < 0) {
                front = maxSize - 1;
            }
            deque[front] = value;
            size += 1;
            return true;
        }
        return false;
    }
    
    public boolean insertLast(int value) {
        if (!isFull()) {
            rear = (rear + 1) % maxSize;
            deque[rear] = value;
            size += 1;
            return true;
        }
        return false;
    }
    
    public boolean deleteFront() {
        if (!isEmpty()) {
            front = (front + 1) % maxSize;
            size -= 1;
            return true;
        }
        return false;
    }
    
    public boolean deleteLast() {
        if (!isEmpty()) {
            rear -= 1;
            if (rear < 0) {
                rear = maxSize - 1;
            }
            size -= 1;
            return true;
        }
        return false;
    }
    
    public int getFront() {
        if (size == 0) {
            return -1;
        }
        return deque[front];
    }
    
    public int getRear() {
        if (size == 0) {
            return -1;
        }
        return deque[rear];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == maxSize;
    }
}
