class MyCircularDeque {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /** Initialize your deque with the size k */
    public MyCircularDeque(int k) {
        capacity = k;
        data = new int[capacity];
        front = 0;  // points to the front element
        rear = 0;   // points to the next insertion at rear
        size = 0;
    }

    /** Adds an item at the front of Deque. Return true if successful */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        // Move front backward in a circular manner
        front = (front - 1 + capacity) % capacity;
        data[front] = value;
        size++;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if successful */
    public boolean insertLast(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if successful */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if successful */
    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }

    /** Get the front item. Returns -1 if deque is empty */
    public int getFront() {
        if (isEmpty()) return -1;
        return data[front];
    }

    /** Get the last item. Returns -1 if deque is empty */
    public int getRear() {
        if (isEmpty()) return -1;
        return data[(rear - 1 + capacity) % capacity];
    }

    /** Checks whether deque is empty */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether deque is full */
    public boolean isFull() {
        return size == capacity;
    }

    // Example usage
    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);

        System.out.println(deque.insertLast(1));   // true
        System.out.println(deque.insertLast(2));   // true
        System.out.println(deque.insertFront(3));  // true
        System.out.println(deque.insertFront(4));  // false, deque is full
        System.out.println(deque.getRear());       // 2
        System.out.println(deque.isFull());        // true
        System.out.println(deque.deleteLast());    // true
        System.out.println(deque.insertFront(4));  // true
        System.out.println(deque.getFront());      // 4
    }
}