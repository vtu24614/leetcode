class MyCircularQueue {
    private int[] data;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        data = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
    }

    // Inserts an element into the circular queue
    public boolean enQueue(int value) {
        if (isFull()) return false;
        data[rear] = value;
        rear = (rear + 1) % capacity;
        size++;
        return true;
    }

    // Deletes an element from the circular queue
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % capacity;
        size--;
        return true;
    }

    // Gets the front item
    public int Front() {
        if (isEmpty()) return -1;
        return data[front];
    }

    // Gets the last item
    public int Rear() {
        if (isEmpty()) return -1;
        // rear points to next insertion index, so need to go back one
        return data[(rear - 1 + capacity) % capacity];
    }

    // Checks if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Checks if queue is full
    public boolean isFull() {
        return size == capacity;
    }
}