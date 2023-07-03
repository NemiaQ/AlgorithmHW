package org.example;

public class Main {
    public static void main(String[] args) {
//        MyHashMap map = new MyHashMap();
//
//        map.push(-1, 2);
//        map.push(17, 3);
//        map.push(3, 4);
//
//        System.out.println(map.find(-1));
//        System.out.println(map.find(17));
//        System.out.println(map.find(3));
//        System.out.println(map.find(5));
//
//        map.remove(17);
//        System.out.println(map.find(17));
//        Tree tree = new Tree();

        LeftRedBlackTree tree = new LeftRedBlackTree();

        for (int i = 1; i <= 5 ; i++){
            tree.insert(i);
        }
    }
}