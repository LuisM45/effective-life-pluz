package net.epnmag9.effectivelifepluz.io;

/**
 * This interface is be meant to be used as a bridge between controllers
 * and whichever technology was used to store the information
 * Uses the generic O for the class that is found in the storage
 * and uses K as the key class that is found
 */
public interface Crud<K,O> {
    public void create(K key, O object);
    public O read(K key);
    public void update(K key, O object);
    public void delete(K key);
}
