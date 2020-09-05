package generics;

public interface IAbb<T> {

    public void addNode(Node<T> node);

    public void removeNode(T info);

    public Node<T> searchNode(T info);

}
