package generics;

public class Abb<T> implements IAbb<T> {

    private Node<T> root;

    public Abb() {

    }

    @Override
    public void addNode(Node node) {

        Node<T> newNode = node;

        if (root == null) {
            root = newNode;
        } else {

            addNode(root, newNode);

        }

    }

    private void addNode(Node<T> current, Node<T> newNode) {

        if (newNode.compareTo(current) <= 0) {
            if (current.getLeft() == null) {
                current.setLeft(newNode);
                current.getLeft().setFather(current);
            } else {
                addNode(current.getLeft(), newNode);
            }

        } else {

            if (current.getRight() == null) {
                current.setRight(newNode);
                current.getRight().setFather(current);
            } else {
                addNode(current.getRight(), newNode);
            }
        }

    }

    @Override
    public void removeNode(T info) {
        // TODO Auto-generated method stub

    }

    @Override
    public Node<T> searchNode(T info) {
        // TODO Auto-generated method stub
        return null;
    }

}
