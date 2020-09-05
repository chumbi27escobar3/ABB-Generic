package generics;

import java.util.ArrayList;

public class Abb<K extends Comparable<K>, V> implements IAbb<K, V> {

    private Node<K, V> root;
    private ArrayList<Node<K, V>> list;

    public Abb() {
        list = new ArrayList<>();
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

                if (toRemove.getRight() != null) {

                    if (toRemove.getFather().getRight() == toRemove) {

                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setRight(toRemove.getRight());

                    } else {

                        toRemove.getRight().setFather(toRemove.getFather());
                        toRemove.getFather().setLeft(toRemove.getRight());

                    }

                } else {

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

        Node<K, V> nodeToUpdate = searchNode(key);
        if (nodeToUpdate != null) {

            nodeToUpdate.setValue(value);
            return true;

        }

        return false;

    }

    @Override
    public void posOrden() {
        list.clear();
        posOrden(root);
    }

    private void posOrden(Node<K, V> root) {

        if (root != null) {
            list.add(root);

            if (root.getLeft() != null) {
                posOrden(root.getLeft());
            } else {
                list.add(root.getLeft());
            }
            if (root.getRight() != null) {
                posOrden(root.getRight());
            } else {
                list.add(root.getRight());
            }
        }
    }

    @Override
    public void inOrden() {
        list.clear();
        inOrden(root);
    }

    private void inOrden(Node<K, V> root) {

        if (root != null) {

            if (root.getLeft() != null) {
                inOrden(root.getLeft());
            } else {
                list.add(root.getLeft());
            }
            list.add(root);
            if (root.getRight() != null) {
                inOrden(root.getRight());
            } else {
                list.add(root.getRight());
            }
        }
    }

    @Override
    public void preOrden() {
        list.clear();
        preOrden(root);
    }

    private void preOrden(Node<K, V> root) {

        if (root != null) {
            if (root.getLeft() != null) {
                preOrden(root.getLeft());
            } else {
                list.add(root.getLeft());
            }
            if (root.getRight() != null) {
                preOrden(root.getRight());
            } else {
                list.add(root.getRight());
            }
            list.add(root);
        }
    }

    @Override
    public int getHeight(Node<K, V> n) {

        if (n == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(n.getLeft()), getHeight(n.getRight()));
        }
    }

    @Override
    public int weight(Node<K, V> root, int cant) {
        if (root != null) {
            cant++;
            return weight(root.getLeft(), cant) + weight(root.getRight(), cant);

        } else {
            return 0;
        }
    }

}