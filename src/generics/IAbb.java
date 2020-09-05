package generics;

public interface IAbb<T> {

    public void addNode(Node<T> node);

    public void removeNode(String info);

    public Node<T> searchNode(String info);

}
