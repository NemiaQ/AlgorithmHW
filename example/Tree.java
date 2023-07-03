package org.example;

public class Tree {
    private Node root;

    class Node{
        int value;

        Node left; // узел слева меньше
        Node right; // узел справа больше
    }

    public void insert(int value){
        if (root == null){
            root = new Node();
            root.value = value;
        } else {
            insert(root, value);
        }
    }

    private void insert(Node node, int value){
        if (node.value != value){
            if(node.value < value){
                // вставка вправо
                if(node.right == null){
                    node.right = new Node();
                    node.right.value = value;
                } else {
                    insert(node.right, value);
                }
            } else {
                // вставка влево
                if(node.left == null){
                    node.left = new Node();
                    node.left.value = value;
                } else {
                    insert(node.left, value);
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