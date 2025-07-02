package HW;

import java.util.ArrayList;

public class BE8Tree {
BE8Node root;
    
    public BE8Tree() {
        this.root = null;
    }
    
    public BE8Tree(BE8Node root) {
        this.root = root;
    }
    
    public BE8Node leftRotate(BE8Node current) {
        BE8Node rightChild = current.right;
        current.right = rightChild.left;
        rightChild.left = current;
        return rightChild;
    }
    
    public BE8Node rightRotate(BE8Node current) {
        BE8Node leftChild = current.left;
        current.left = leftChild.right;
        leftChild.right = current;
        return leftChild;
    }
    
    public void balanceTree() {
        balanceTreeRecursion(null, root);
    }
    
    private int balanceTreeRecursion(BE8Node parent, BE8Node current) {
        if (current == null) return -1;
        
        int leftHeight = balanceTreeRecursion(current, current.left);
        int rightHeight = balanceTreeRecursion(current, current.right);
        
        if ((leftHeight - rightHeight) > 1) {
            BE8Node newParent = current.left;
            current.left = newParent.right;
            newParent.right = current;
            
            if (parent == null) {
                root = newParent;
            } else if (parent.left != null && parent.left.value.equals(current.value)) {
                parent.left = newParent;
            } else {
                parent.right = newParent;
            }
            
            return leftHeight;
        }
        
        if ((rightHeight - leftHeight) > 1) {
            BE8Node newParent = current.right;
            current.right = newParent.left;
            newParent.left = current;
            
            if (parent == null) {
                root = newParent;
            } else if (parent.left != null && parent.left.value.equals(current.value)) {
                parent.left = newParent;
            } else {
                parent.right = newParent;
            }
            
            return rightHeight;
        }
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public BE8Node rightRotate1(BE8Node oldRoot) {
        BE8Node newRoot = oldRoot.left;
        BE8Node temp = newRoot.right;
        
        newRoot.right = oldRoot;
        oldRoot.left = temp;
        
        return newRoot;
    }
    
    public boolean isBalance() {
        return true; 
    }
    
    public boolean isBalanced() {
        return findImbalanceNodes().isEmpty();
    }
    
    public ArrayList<BE8Node> findImbalanceNodes() {
        ArrayList<BE8Node> result = new ArrayList<>();
        checkBalance(root, result);
        return result;
    }
    
    private int checkBalance(BE8Node node, ArrayList<BE8Node> imbalanced) {
        if(node == null) return 0;
        if (node.left == null && node.right == null) return 1;
        
        int leftHeight = checkBalance(node.left, imbalanced);
        int rightHeight = checkBalance(node.right, imbalanced);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public void printInOrder(BE8Node node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.value + " ");
            printInOrder(node.right);
        }
    }
}
