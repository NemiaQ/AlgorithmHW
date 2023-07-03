package org.example;
public class LeftRedBlackTree {
    private Node root;

    private enum Color {
        RED, BLACK
    }

    class Node{
        int value;
        Node left; // узел слева меньше
        Node right; // узел справа больше
        private Color color;
    }

    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    private Node rebalnce(Node node){
        Node result =node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED &&
                    (result.left == null || result.left.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.left.left != null && result.left.left.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED &&
                    result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        }
        while (needRebalance);
        return result;
    }

    private Node rightSwap(Node node){
        Node rightChild = node.right;
        Node betweenChild = rightChild.left;
        rightChild.left = node;
        node.right = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node){
        Node leftChild = node.left;
        Node betweenChild = leftChild.right;
        leftChild.right = node;
        node.left = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    public void insert(int value){
        if (root == null){
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
        } else {
            insert(root, value);
            root = rebalnce(root);
            root.color = Color.BLACK;
        }
    }

    private void insert(Node node, int value){
        if (node.value != value){
            if(node.value < value){
                // вставка вправо
                if(node.right == null){
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                } else {
                    insert(node.right, value);
                    node.right = rebalnce(node.right);
                }
            } else {
                // вставка влево
                if(node.left == null){
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                } else {
                    insert(node.left, value);
                    node.left = rebalnce(node.left);
                }
            }
        }
    }

    public Node find (int value){
        return find(root, value);
    }

    private Node find (Node node, int value){
        if (node == null){
            return null;
        }
        if (node.value == value){
            return node;
        }
        if (node.value < value){
            return find(node.right, value);
        } else {
            return find(node.left, value);
        }
    }
}