package generics;

public interface IAbb<K extends Comparable<K>,V> {

    public void addNode(Node<K,V> node);

    public void removeNode(K key);

    public Node<K,V> searchNode(K key);

    public boolean updateNode(K key, V value);

}