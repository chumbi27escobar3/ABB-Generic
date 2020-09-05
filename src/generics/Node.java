package generics;

public class Node<P> {

    private Node<P> father;
    private Node<P> right;
    private Node<P> left;
    private String info;

    public Node(String info) {
        this.info = info;
    }

    public int compareTo(Node<P> h) {

        if (this.info.compareTo(h.getInfo()) < 0) {

            return -1;

        } else if (this.info.compareTo(h.getInfo()) > 0) {

            return 1;

        }

        return 0;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Node<P> getFather() {
        return father;
    }

    public void setFather(Node<P> father) {
        this.father = father;
    }

    public Node<P> getRight() {
        return right;
    }

    public void setRight(Node<P> right) {
        this.right = right;
    }

    public Node<P> getLeft() {
        return left;
    }

    public void setLeft(Node<P> left) {
        this.left = left;
    }

}
