package generics;

import java.util.ArrayList;

public interface IAbb<K extends Comparable<K>, V> {

    public void addNode(Node<K, V> node);

    public void removeNode(K key);

    public Node<K, V> searchNode(K key);

    public boolean updateNode(K key, V value);

    public void posOrden();

    public void inOrden();

    public int getHeight(Node<K, V> n);

    public int weight(Node<K, V> root, int cant);
    public void preOrden();
}