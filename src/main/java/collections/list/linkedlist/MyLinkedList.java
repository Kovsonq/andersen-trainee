package collections.list.linkedlist;

import collections.list.MyList;

/**
 * LinkedList.java
 **/
public class MyLinkedList<E> implements MyList {
    private int size;
    private Node head;

    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    private static class Node<E> {
        public Object item;
        public Node next;
    }

    /**
     * Inserting new node at the end of the linked list
     *
     * @param item - represent the node item to be added to the linked list
     */
    @Override
    public boolean add(Object item) {
        Node node = new Node();
        node.item = item;
        Node current = this.head;

        if (this.head == null) {
            this.head = node;
            this.head.next = null;
            this.size = 1;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
            node.next = null;
            this.size++;
        }
        return true;
    }

    /**
     * Adding node at the first location of the linked list
     *
     * @param item - represent item of the node to be added to LL
     */
    public void addFirst(Object item) {
        Node node = new Node();
        node.item = item;
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    /**
     * Adding node at the nth location of the linked list
     *
     * @param item  - represent the item of the node to be added to the list
     * @param index - position at which the node is to be added
     */
    @Override
    public void add(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of list: " + index);
        } else if (index == 0) {
            addFirst(item);
        } else {
            Node node = new Node();
            node.item = item;
            Node current = this.head;
            if (this.head != null && index <= this.size) {
                for (int i = 1; i < index; i++) {
                    current = current.next;
                }
                node.next = current.next;
                current.next = node;
                this.size += 1;
            }
        }
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index
     * @param item
     * @return
     */
    @Override
    public Object set(int index, Object item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of list: " + index);
        }
        Object oldElementData = getNode(index);
        Node<E> node = getNode(index);
        node.item = item;
        return oldElementData;
    }

    /**
     * Get Node by index parameter.
     *
     * @param index
     * @return
     */
    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of list: " + index);
        }
        return getNode(index).item;
    }

    /**
     * Returns the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.
     *
     * @param item
     * @return
     */
    @Override
    public int indexOf(Object item) {
        int index = 0;
        Node<E> current = this.head;

        while (current != null) {
            if (current.item.equals(item)) {
                return index;
            } else {
                index++;
                current = current.next;
            }
        }
        return -1;
    }

    /**
     * Deleting the first node from the list
     */
    public void deleteFirst() {
        if (head != null) {
            this.head = this.head.next;
            this.size--;
        } else {
            throw new IndexOutOfBoundsException("List is empty.");
        }
    }

    /**
     * Deleting the last node from the list
     */
    public void deleteLast() {
        Node currentNode = this.head;
        if (size == 1) {
            head = null;
            size = 0;
        } else {
            Node prevNode = null;
            while (currentNode.next != null) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            prevNode.next = null;
            this.size--;
        }
    }

    /**
     * Deleting the node by index in the list
     *
     * @param index - location of the node to be deleted
     */
    @Override
    public Object remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of list: " + index);
        } else if (index == 0) {
            this.head = this.head.next;
            size--;
            return head.item;
        } else {
            Node currentNode = this.head;
            Node prevNode = null;
            for (int i = 0; i < index; i++) {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            Object deletedElement = prevNode.next.item;
            prevNode.next = currentNode.next;
            this.size--;
            return deletedElement;
        }
    }

    /**
     * Size of the list
     *
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

}
