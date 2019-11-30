package zy.agr.redblack;

/**
 * Created by kaiser_zhao on 12/24/17.
 */
public class RedBlackNode {

    // 1. parent. The reference of parent node. If parent is null, then this node is root.
    private RedBlackNode parent;

    // 2. leftChild. The left child
    private RedBlackNode leftChild;

    // 3. rightChild. The right child
    private RedBlackNode rightChild;

    // 4. color. RED or BLACK
    private boolean red;

    // 5. key.
    private int key;

    public RedBlackNode getParent() {
        return parent;
    }

    public void setParent(RedBlackNode parent) {
        this.parent = parent;
    }

    public RedBlackNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(RedBlackNode leftChild) {
        this.leftChild = leftChild;
    }

    public RedBlackNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(RedBlackNode rightChild) {
        this.rightChild = rightChild;
    }

    public boolean isRed() {
        return red;
    }

    public void setRed(boolean red) {
        this.red = red;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {

        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // 6. value
    private String value;
}

