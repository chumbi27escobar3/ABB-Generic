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

        Node<K, V> nodeToUpdate = searchNode(key);
        if (nodeToUpdate != null) {

            nodeToUpdate.setValue(value);
            return true;

        }

        return false;

    }

    @Override 
    public ArrayList<Node<k,v>> posOrden(Node<k,v> root) {
    	ArrayList<Node<k,v>> list = new ArrayList<>();
    	if(root != null) {
    		list.add(this);
    		if(root.getLeft() = null) {
    			return list.add(this);
    		} else {
    			return posOrden(root.getLeft());
    		}
    		if(root.getRight() = null) {
    			return list.add(this);
    		} else {
    			return posOrden(root.getRight());
    		}
    	}
    }
    
    @Override 
    public ArrayList<Node<k,v>> inOrden(Node<k,v> root) {
    	ArrayList<Node<k,v>> list = new ArrayList<>();
    	if(root != null) {
    		if(root.getLeft() = null) {
    			return list.add(this);
    		} else {
    			return inOrden(root.getLeft());
    		}
    		list.add(this);
    		if(root.getRight() = null) {
    			return list.add(this);
    		} else {
    			return inOrden(root.getRight());
    		}
    	}
    }
    
    @Override 
    public ArrayList<Node<k,v>> preOrden(Nodo<k,v> root) {
    	ArrayList<Node<k,v>> list = new ArrayList<>();
    	if(root != null) {
    		if(root.getLeft() = null) {
    			return list.add(this);
    		} else {
    			return preOrden(root.getLeft());
    		}
    		if(root.getRight() = null) {
    			return list.add(this);
    		} else {
    			return preOrden(root.getRight());
    		}
    		list.add(this);
    	}
    }
    
   public int getHeight(Nodo<k,v> n) {
	   if(nodo = null) {
		   return 0;
	   } else {
		   int result = 1 + Math.max(getHeight(root.getRight()),getHeight(root.getLeft()));
		   return result;
	   }
   }
   
   private int weight(Nodo<k,v> root,int cant) {
	   if (root!=null) {
		   cant++;
           return weight(root.getLeft(),cant);
           return weight(root.getRight(),cant);
       }
   }
   
   
}