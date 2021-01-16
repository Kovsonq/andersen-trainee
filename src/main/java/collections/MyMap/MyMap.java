package collections.MyMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MyMap<K,V> {
    private int size;
    private static final int DEFAULT_CAPACITY = 16;
    private MyEntry<K,V>[] values = new MyEntry[DEFAULT_CAPACITY];

    /**
     * Returns the value to which the specified key is mapped,
     * or null if this map contains no mapping for the key.
     * @param key
     * @return
     */
    public V get(K key){
        for (int i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getKey().equals(key)){
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    /**
     * Associates the specified value with the specified key in this map (optional operation).
     * @param key
     * @param value
     */
    public void put(K key, V value){
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)){
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert){
            values[size++] = new MyEntry<K,V>(key, value);
            ensureCapacity();
        }
    }

    /**
     * Increases the capacity of this array instance, if necessary
     */
    private void ensureCapacity() {
        if (size == values.length){
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    /**
     * Returns the number of key-value mappings in this map.
     * @return
     */
    public int size(){
        return this.size;
    }

    /**
     * Removes the mapping for a key from this map if it is present (optional operation).
     * @param key
     */
    public void remove(K key){
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)){
                values[i] = null;
                size--;
                for (int j = i; j < size; j++) {
                    values[j] = values[j+1];
                }
            }
        }
    }

    /**
     * Returns true if this map contains a mapping for the specified key.
     * @param key
     * @return
     */
    public boolean containsKey(K key){
        for (int i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getKey().equals(key)){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Returns true if this map maps one or more keys to the specified value.
     * @param value
     * @return
     */
    public boolean containsValue(V value){
        for (int i = 0; i < size; i++) {
            if (values[i] != null){
                if (values[i].getValue().equals(value)){
                    return true;
                }
            }
        }
        return false;
    }

}
