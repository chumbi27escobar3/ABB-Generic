package generics;

public class Abb<T> implements IAbb<T> {

    private Node<T> root;

    public Abb() {

    }

    @Override
    public void addNode(Node<T> node) {

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
    public Node<T> searchNode(String info) {

        if (root.getInfo().equals(info)) {
            return root;
        }

        return search(root, info);

    }

    private Node<T> search(Node<T> current, String info) {

        if (current == null) {

            return null;

        } else if (current.getInfo().equals(info)) {

            return current;

        } else if (current.getInfo().compareTo(info) > 0) {

            if (current.getLeft() == null) {

                return null;

            } else {

                return search(current.getLeft(), info);

            }

        } else {

            if (current.getInfo().equals(info)) {

                return current;

            } else {

                return search(current.getRight(), info);

            }
        }

    }

    @Override
    public void removeNode(String info) {

        Node<T> toRemove = searchNode(info);

        if (toRemove != null) {

            if (toRemove.getRight() == null && toRemove.getLeft() == null) {
                if (toRemove.getFather().getLeft() == toRemove) {
                    toRemove.getFather().setLeft(null);
                } else {
                    toRemove.getFather().setRight(null);
                }
            } else if (toRemove.getRight() == null ^ toRemove.getLeft() == null) {

                if (toRemove.getRight() != null) { // derecho es unico hijo del difunto
                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getRight());
                    } else {
                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getRight());
                    }

                } else { // izquierdo es unico hijo del difunto

                    if (toRemove.getFather().getRight() == toRemove) {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getLeft());
                    } else {
                        toRemove.getLeft().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getLeft());
                    }

                }

            } else if (toRemove.getLeft() != null && toRemove.getRight() != null) {

                Node<T> current = toRemove.getLeft();

                while (current.getRight() != null) {

                    current = current.getRight();

                }

                if (current.getFather().getRight() == current) {
                    current.getFather().setRight(null);

                } else {
                    current.getFather().setLeft(null);
                }

                current.setFather(toRemove.getFather());
                current.setLeft(toRemove.getLeft());
                current.setRight(toRemove.getRight());
                current.getRight().setFather(current);
                current.getLeft().setFather(current);

                if (toRemove.getFather().getRight() == toRemove) {
                    current.getFather().setRight(current);

                } else {
                    current.getFather().setLeft(current);
                }

                current = null;

            }
        }
    }

}