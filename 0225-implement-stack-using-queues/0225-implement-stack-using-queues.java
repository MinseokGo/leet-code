class MyStack {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public MyStack() {
    }
    
    public void push(int x) {
        queue1.add(x);
    }
    
    public int pop() {
        moveFromOneToTwo();
        return queue1.poll();
    }
    
    public int top() {
        moveFromOneToTwo();
        int top = queue1.poll();
        queue1.add(top);
        return top;
    }

    private void moveFromOneToTwo() {
        if (queue1.size() > 0) {
            while (queue1.size() != 1) {
                queue2.add(queue1.poll());
            }
            while (queue2.size() > 0) {
                queue1.add(queue2.poll());
            }
        }
    }
    
    public boolean empty() {
        return queue1.size() == 0;
    }
}
