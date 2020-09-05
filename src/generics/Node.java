package generics;

public class Node<K extends Comparable<K>, V> {

    private Node<K, V> father;
    private Node<K, V> right;
    private Node<K, V> left;
    private K key;
    private V value;

    public Node(K key, V value) {
        this.key = key;
        this.value = value;

    }

    public Node<K, V> getFather() {
        return father;
    }

    public void setFather(Node<K, V> father) {
        this.father = father;
    }

    public Node<K, V> getRight() {
        return right;
    }

    public void setRight(Node<K, V> right) {
        this.right = right;
    }

    public Node<K, V> getLeft() {
        return left;
    }

    public void setLeft(Node<K, V> left) {
        this.left = left;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

}