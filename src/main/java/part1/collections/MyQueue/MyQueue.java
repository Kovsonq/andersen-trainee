package part1.collections.MyQueue;

public class MyQueue<E> {
    private int maxSize;
    private Object[] myQueue;
    private int front;
    private int rear;
    private int size;

    public MyQueue(int size){
        this.maxSize = size;
        this.myQueue = new Object[maxSize];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions, returning true upon
     * success and throwing an IllegalStateException if no space is currently
     * available.
     * @param item
     */
    public boolean add(E item){
        if (isFull()){
            throw new IllegalStateException("Queue is full: " + maxSize);
        } else {
            if (rear == maxSize-1)
                rear = -1;
            myQueue[++rear] = item;
            size++;
            return true;
        }
    }

    /**
     * Retrieves and removes the head of this queue.
     * @return
     */
    public Object remove(){
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty: " + size);
        } else {
            Object temp = myQueue[front++];
            if (front == maxSize)
                front = 0;
            size--;
            return temp;
        }
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
     * @return
     */
    public Object peekFront(){
        if (isEmpty()) {
            return null;
        }
        return myQueue[front];
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     * @return
     */
    public Object pollFront(){
        if (isEmpty()) {
            return null;
        } else {
            Object temp = myQueue[front++];
            if (front == maxSize)
                front = 0;
            size--;
            return temp;
        }
    }

    public boolean isEmpty(){
        return size==0;
    }

    public boolean isFull(){
        return size==maxSize;
    }

    public int size(){
        return size;
    }

}
