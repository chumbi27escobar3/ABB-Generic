package generics;

public class Abb<K extends Comparable<K>, V> implements IAbb<K, V> {

    private Node<K, V> root;

    public Abb() {

    }

    @Override
    public void addNode(Node<K, V> node) {

        Node<K, V> newNode = node;

        if (root == null) {

            root = newNode;

        } else {

            addNode(root, newNode);

        }

    }

    private void addNode(Node<K, V> current, Node<K, V> newNode) {

        if (newNode.getKey().compareTo(current.getKey()) <= 0) {

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
    public Node<K, V> searchNode(K key) {

        if (root.getKey().equals(key)) {

            return root;
        }

        return search(root, key);

    }

    private Node<K, V> search(Node<K, V> current, K key) {

        if (current == null) {

            return null;

        } else if (current.getKey().equals(key)) {

            return current;

        } else if (current.getKey().compareTo(key) > 0) {

            if (current.getLeft() == null) {

                return null;

            } else {

                return search(current.getLeft(), key);

            }

        } else {

            if (current.getKey().equals(key)) {

                return current;

            } else {

                return search(current.getRight(), key);

            }
        }

    }

    @Override
    public void removeNode(K key) {

        Node<K, V> toRemove = searchNode(key);

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

                Node<K, V> current = toRemove.getLeft();

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

    @Override
    public boolean updateNode(K key, V value) {

        if (searchNode(key) != null) {

            searchNode(key).setValue(value);
            return true;

        }

        return false;
    
    }

}