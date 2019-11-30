package zy.agr.redblack;

/**
 * Created by kaiser_zhao on 12/24/17.
 * 1. root and leaf are Black
 * 2. for every branch, numbers of Black node should be same.
 * 3. children of red node should be black
 * 4. node is black or red
 * 5. For root, key=0, root is null. For leaf, key=0, root != null.
 */
public class RedBlack {

    // for beginning create a root, it is black, left/parent/right are null. key is 0. value is "empty"
    private static RedBlackNode root = null;

    public static final void main(String... args){
        RedBlackNode node10 = createNode(10,"10");
        RedBlackNode node8 = createNode(8,"8");
        RedBlackNode node11 = createNode(11,"11");
        RedBlackNode node9 = createNode(9,"9");
        intert(node10);
        intert(node8);
        intert(node11);
        intert(node9);
        printNode(root);
    }

    private static boolean isLeaf(RedBlackNode currentNode){
        if(currentNode.getKey()==0 && currentNode.getParent() !=null){
            return true;
        }
        return false;
    }

    private static RedBlackNode getGrandFather(RedBlackNode node){
        if(node == null){
            return null;
        }else if(node.getParent() == null){
            return null;
        }else {
            return node.getParent().getParent();
        }
    }

    private static RedBlackNode getUncle(RedBlackNode node){
        if(node == null){
            return null;
        }else if(node.getParent() == null){
            return null;
        }else if(node.getParent().getParent() == null){
            return null;
        }else{
            RedBlackNode parent = node.getParent();
            if(isLeftChild(parent)){
                return node.getParent().getParent().getRightChild();
            }else {
                return node.getParent().getParent().getLeftChild();
            }
        }
    }

    private static boolean isRoot(RedBlackNode node){
        // if node.parent is null, return true
        if(node==null){
            return false;
        }else if(node.getParent() == null){
            return true;
        }else {
            return false;
        }
    }

    private static RedBlackNode createLeaf(RedBlackNode parent, boolean isLeft){
        RedBlackNode leaf = new RedBlackNode();

        //  key=0;
        leaf.setKey(0);

        // if isLeft parent.left = leaf; else parent.right = leaf
        // leaf.parent = parent
        if(isLeft){
            parent.setLeftChild(leaf);
        }else{
            parent.setRightChild(leaf);
        }
        leaf.setParent(parent);
        return leaf;
    }

    /**
     * Create node, parent/left/right is null. set key/value. Color is RED.
     *
     * @param key
     * @param value
     */
    public static RedBlackNode createNode(int key, String value){

        RedBlackNode node = new RedBlackNode();
        node.setKey(key);
        node.setValue(value);
        node.setRed(true);
        return node;
    }

    private static RedBlackNode getPosition(int key){
        RedBlackNode currentNode = root;
        //1. if root is null, return root.
        if(root == null){
            return null;
        }

        //2. else, until currentNode is leaf,
        //      if key > currentNode.key, currentNode = currentKey.right
        //      else, currentNode = currentKey.left
        while(!isLeaf(currentNode)){
            if(key> currentNode.getKey()){
                currentNode = currentNode.getRightChild();
            }else{
                currentNode = currentNode.getLeftChild();
            }
        }

        return currentNode;
    }

    private static boolean isLeftChild(RedBlackNode child){

        // if child.parent.left == child, return true. else return false
        if(child.getParent() == null){
            return false;
        }

        if(child == child.getParent().getLeftChild()){
            return true;
        }else {
            return false;
        }
    }

    public static void intert(RedBlackNode node){
        // 1. Get position for insert.
        RedBlackNode currentNode = getPosition(node.getKey());

        // 2. Insert new node.
        //      2.1 If is root, just assign it to root.
        // root = currentNode; return;
        // add two leaves.
        // set it as black
        if(root == currentNode){
            root = node;
            createLeaf(root,true);
            createLeaf(root,false);
            root.setRed(false);
            return;
        }

        //      2.2 Cut the leaf, link the node to the parent. Link leaf, and create new leaf.
        // else if isLeftChild() == true. currentNode.parent.left = node, node.parent=currentNode.parent,
        //      node.left = currentNode, currentNode.parent = node. createLeaf(node, right)
        //      else if isLeftChild() == false. currentNode.parent.right = node, node.parent = currentNode.parent,
        //      node.right = currentNode, currentNode.parent = node.createLeaf(node, left)
        if(isLeftChild(currentNode)){
            currentNode.getParent().setLeftChild(node);
            node.setParent(currentNode.getParent());
            node.setLeftChild(currentNode);
            currentNode.setParent(node);
            createLeaf(node, false);
        }else{
            currentNode.getParent().setRightChild(node);
            node.setParent(currentNode.getParent());
            node.setRightChild(currentNode);
            createLeaf(node, true);
        }

        // 3. Adjust node
        adjustNode(node);
    }

    public static void adjustNode(RedBlackNode currentNode){
        // 0. If it is root, check color
        //      0.1 If color is red, turn it to black, return.
        if(currentNode == root){
            if(currentNode.isRed()){
                currentNode.setRed(false);
                return;
            }
        }
        // 1. Check the color of parent
        //      1.1 If parent is black, do nothing.
        RedBlackNode parent = currentNode.getParent();
        if(!parent.isRed()){
            return;
        }
        //      1.2 If parent is RED. And parent is left child of grandfather
        //          isLeftChild(currentNode.parent);
        else {
            //          1.2.1 Check the color of uncle
            RedBlackNode grandFather = parent.getParent();
            RedBlackNode uncle = getUncle(currentNode);

            if(isLeftChild(parent)) {

                //          getUncle()
                //              1.2.1.1 If uncle is red, turn parent to black, turn uncle to black, turn grandfather to red.
                //              set grandfather to current. adjustNode(currentNode)
                //              getGrandFather().
                if(uncle.isRed()){
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandFather.setRed(true);
                    adjustNode(grandFather);
                }
                //              1.2.1.2 If uncle is black
                else{
                    //                      1.2.1.2.3 if current node is left child of parent, parent to black, grandfather to red,
                    //                      using grandfather as axis, right rotate
                    //                      isLeftChild(currentNode)
                    //                      rightRotate(grandfather)
                    if(isLeftChild(currentNode)){
                        parent.setRed(false);
                        grandFather.setRed(true);
                        rightRotate(grandFather);
                    }
                    //                     1.2.1.2.3 if current node is right child of parent, turn parent as current node
                    //                      using parent as axis, left rotate. adjustNode(currentNode).
                    //                      leftRotate(parent)
                    else{
                        leftRotate(parent);
                        adjustNode(parent);
                    }
                }
            }else {
                //      1.3 If parent is RED. And parent is left right of grandfather
                //          Do the same thing in 1.2, left<==>right
                //          getUncle()
                //              1.2.1.1 If uncle is red, turn parent to black, turn uncle to black, turn grandfather to red.
                //              set grandfather to current. adjustNode(currentNode)
                //              getGrandFather().
                if(uncle.isRed()){
                    parent.setRed(false);
                    uncle.setRed(false);
                    grandFather.setRed(true);
                    adjustNode(grandFather);
                }
                //              1.2.1.2 If uncle is black
                else{
                    //                     1.2.1.2.3 if current node is left child of parent, turn parent as current node
                    //                      using parent as axis, left rotate. adjustNode(currentNode).
                    //                      leftRotate(parent)
                    if(isLeftChild(currentNode)){
                        leftRotate(parent);
                        adjustNode(parent);
                    }
                    //                      1.2.1.2.3 if current node is right child of parent, parent to black, grandfather to red,
                    //                      using grandfather as axis, right rotate
                    //                      isLeftChild(currentNode)
                    //                      rightRotate(grandfather)
                    else{
                        parent.setRed(false);
                        grandFather.setRed(true);
                        rightRotate(grandFather);
                    }
                }
            }
        }
    }

    private static void leftRotate(RedBlackNode currentNode){
        // 1. check whether current node is left child of parent
        // isLeftChild = isLeftChild(currentNode)
        boolean isLeftChild = isLeftChild(currentNode);
        // keep reference of parent Node
        RedBlackNode parent = currentNode.getParent();
        // If is left child
        if(isLeftChild){
            //      parent.left = current.right
            //      current.parent = parent.left
            //      current.right = parent.left.left
            //      parent.left.left = current
            //      parent.left.parent = parent
            parent.setLeftChild(currentNode.getRightChild());
            currentNode.setParent(parent.getLeftChild());
            currentNode.setRightChild(parent.getLeftChild().getLeftChild());
            parent.getLeftChild().setLeftChild(currentNode);
            parent.getLeftChild().setParent(parent);
        }
        // Else
        else {
            //      parent.right = current.right
            //      current.parent = parent.right
            //      current.right = parent.right.left
            //      parent.right.left = current
            //      parent.right.parent = parent
            parent.setRightChild(currentNode.getRightChild());
            currentNode.setParent(parent.getRightChild());
            currentNode.setRightChild(parent.getRightChild().getLeftChild());
            parent.getRightChild().setLeftChild(currentNode);
            parent.getRightChild().setParent(parent);
        }
    }

    private static void rightRotate(RedBlackNode currentNode){
        // 1. check whether current node is left child of parent
        // isLeftChild = isLeftChild(currentNode)
        boolean isLeftChild = isLeftChild(currentNode);
        // keep reference of parent Node
        RedBlackNode parent = currentNode.getParent();
        if(isLeftChild){
            // If is left child
            //      parent.left = current.left
            //      current.parent = parent.left
            //      current.left = parent.left.right
            //      parent.left.right = current
            //      parent.left.parent = parent
            parent.setLeftChild(currentNode.getLeftChild());
            currentNode.setParent(parent.getLeftChild());
            currentNode.setLeftChild(parent.getLeftChild().getRightChild());
            parent.getLeftChild().setRightChild(currentNode);
            parent.getLeftChild().setParent(parent);
        }
        // Else
        else {
            //      parent.right = current.left
            //      current.parent = parent.right
            //      current.left = parent.right.left
            //      parent.right.left = current
            //      parent.right.parent = parent
            parent.setRightChild(currentNode.getLeftChild());
            currentNode.setParent(parent.getRightChild());
            currentNode.setLeftChild(parent.getRightChild().getLeftChild());
            parent.getRightChild().setLeftChild(currentNode);
            parent.getRightChild().setParent(parent);
        }
    }

    // 1. if left child is leaf, print.
    // 2. if left child has been printed, print current node.
    // 3. go to print right child
    private static void printNode(RedBlackNode currentNode){
        //    System.out.println(currentNode.getKey());
        if(isLeaf(currentNode)){
            System.out.println("is leaf!");
            return;
        }
        printNode(currentNode.getLeftChild());
        printKeyValue(currentNode);
        printNode(currentNode.getRightChild());
    }

    private static void printKeyValue(RedBlackNode node){
        System.out.println("Key " + node.getKey() + " : " + "Value " + node.getValue());
    }
}
