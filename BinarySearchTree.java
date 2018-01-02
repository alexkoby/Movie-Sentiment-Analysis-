//-------------------------------------------------------------------------
/**
 * Implements an unbalanced binary search tree. Note that all "matching" is
 * based on the compareTo() method.
 *
 * @param <T>
 *            The type of data element contained in the node.
 *
 * @author Mark Allen Weiss (with modifications by John Lewis)
 * @author Alexander Koby
 * @version 2017.11.24
 */
public class BinarySearchTree<T extends Comparable<? super T>> {
    // ~ Instance/static variables .............................................

    private BinaryNode<T> root;

    // ~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Constructs an empty tree.
     */
    public BinarySearchTree() {
        root = null;
    }

    // ~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Insert into the tree.
     * 
     * @param x
     *            the item to insert.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    public void insert(T x) {
        if (root == null) {
            root = new BinaryNode<T>(x);
            return;
        } 
        else if (root.getElement().compareTo(x) == 0) {
            throw new DuplicateItemException(x.toString() +
                    " is already present");
        } 
        else {
            insert(x, root);
        }
    }

    // ----------------------------------------------------------
    /**
     * Remove the specified value from the tree.
     * 
     * @param x
     *            the item to remove.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    public void remove(T x) {
        if (root == null) {
            throw new ItemNotFoundException();
        } 
        else {
            this.remove(x, root);
        }
    }

    // ----------------------------------------------------------
    /**
     * Find the smallest item in the tree.
     * 
     * @return The smallest item, or null if the tree is empty.
     */
    public T findMin() {
        return elementAt(findMin(root));
    }

    // ----------------------------------------------------------
    /**
     * Find the largest item in the tree.
     * 
     * @return The largest item in the tree, or null if the tree is empty.
     */
    public T findMax() {
        return elementAt(findMax(root));
        
    }

    // ----------------------------------------------------------
    /**
     * Find an item in the tree.
     * 
     * @param x
     *            the item to search for.
     * @return the matching item or null if not found.
     */
    public T find(T x) {
        return elementAt(find(x, root));
    }

    // ----------------------------------------------------------
    /**
     * Make the tree logically empty.
     */
    public void makeEmpty() {
        root = null;
    }

    // ----------------------------------------------------------
    /**
     * Test if the tree is logically empty.
     * 
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    // ----------------------------------------------------------
    /**
     * Internal method to get element value stored in a tree node, with safe
     * handling of null nodes.
     * 
     * @param node
     *            the node.
     * @return the element field or null if node is null.
     */
    private T elementAt(BinaryNode<T> node) {
        return (node == null) ? null : node.getElement();
    }

    // ----------------------------------------------------------
    /**
     * Internal method to insert a value into a subtree.
     * 
     * @param x
     *            the item to insert.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws DuplicateItemException
     *             if x is already present.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node) {
        if (node.getElement().compareTo(x) == 0) {
            throw new DuplicateItemException();    
        }
        if (node.getElement().compareTo(x) > 0 && node.getLeft() == null) { 
        //x is smaller than element && left is null
            BinaryNode<T> newNode = new BinaryNode<T>(x);
            node.setLeft(newNode);
            
            return newNode;
        } 
        else if (node.getElement().compareTo(x) > 0 
                && node.getLeft().getElement().compareTo(x) == 0) { 
        // x is smaller than element && left element is value
            throw new DuplicateItemException(x.toString() +
                    " is already present");

        } 
        else if (node.getElement().compareTo(x) > 0) { 
        // x is smaller than element && left element is not value
            return insert(x, node.getLeft());
        } 
        else if (node.getRight() == null) { 
        // x is bigger than element && right is null
            BinaryNode<T> newNode = new BinaryNode<T>(x);
            node.setRight(newNode);
            return newNode;
        
        } 
        else {
            return insert(x, node.getRight());
        }
    }

    // ----------------------------------------------------------
    /**
     * Internal method to remove a specified item from a subtree.
     * 
     * @param x
     *            the item to remove.
     * @param node
     *            the node that roots the subtree.
     * @return the new root of the subtree.
     * @throws ItemNotFoundException
     *             if x is not found.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> node) {
        // This local variable will contain the new root of the subtree,
        // if the root needs to change.
        BinaryNode<T> result = node;

        // If there's no more subtree to examine
        if (node == null) {
            throw new ItemNotFoundException(x.toString());
        }

        // if value should be to the left of the root
        if (x.compareTo(node.getElement()) < 0) {
            node.setLeft(remove(x, node.getLeft()));
        }
        // if value should be to the right of the root
        else if (x.compareTo(node.getElement()) > 0) {
            node.setRight(remove(x, node.getRight()));
        }
        // If value is on the current node
        else {
            // If there are two children
            if (node.getLeft() != null && node.getRight() != null) {
                System.out.println("here once");
                BinaryNode<T> value = this.findMax(node.getLeft());
                node.setElement(value.getElement());
                this.remove(value.getElement(), value); 
                //might not return the proper shit
            }
            // If there is only one child on the left
            else if (node.getLeft() != null) {
                result = node.getLeft();
            }
            // If there is only one child on the right
            else {
                result = node.getRight();
            }
        }
        return result;
    }

    // ----------------------------------------------------------
    /**
     * Internal method to find the smallest item in a subtree.
     * 
     * @param node
     *            the node that roots the tree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> node) {
        if (node == null) {
            return node;
        } 
        else if (node.getLeft() == null) {
            return node;
        } 
        else {
            return findMin(node.getLeft());
        }
    }

    // ----------------------------------------------------------
    /**
     * Internal method to find the largest item in a subtree.
     * 
     * @param node
     *            the node that roots the tree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> node) {
        if (node == null) {
            return node;
        } 
        else if (node.getRight() == null) {
            return node;
        } 
        else {
            return findMax(node.getRight());
        }
    }

    // ----------------------------------------------------------
    /**
     * Internal method to find an item in a subtree.
     * 
     * @param x
     *            is item to search for.
     * @param node
     *            the node that roots the tree.
     * @return node containing the matched item.
     */
    private BinaryNode<T> find(T x, BinaryNode<T> node) {
        if (node == null) {
            return null; // Not found
        } 
        else if (x.compareTo(node.getElement()) < 0) {
            // Search in the left subtree
            return find(x, node.getLeft());
        } 
        else if (x.compareTo(node.getElement()) > 0) {
            // Search in the right subtree
            return find(x, node.getRight());
        } 
        else {
            return node; // Match
        }
    }
}
