package part1.collections.list;

/**
 * Interface for my implementations of LinkedList and ArrayList
 * @param <E>
 */
public interface MyList<E> {
    boolean add(E item);
    void add(int index, E item);
    E get(int index);
    int indexOf(E item);
    E remove(int index);
    int size();
    E set(int index, E item);
}
