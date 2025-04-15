class MyQueue {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.addLast(x);
    }
    
    public int pop() {
        int pop = -1;
        if (stack1.size() > 0) {
            while (stack1.size() != 1) {
                stack2.addLast(stack1.pollLast());
            }
            pop = stack1.pollLast();

            while (stack2.size() > 0) {
                stack1.addLast(stack2.pollLast());
            }
        }
        return pop;
    }
    
    public int peek() {
        int peek = -1;
        if (stack1.size() > 0) {
            while (stack1.size() > 0) {
                stack2.addLast(stack1.pollLast());
            }
            peek = stack2.peekLast();

            while (stack2.size() > 0) {
                stack1.addLast(stack2.pollLast());
            }
        }
        return peek;
    }
    
    public boolean empty() {
        return stack1.size() == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */