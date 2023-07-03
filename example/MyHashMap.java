package org.example;

import java.util.HashMap;

public class MyHashMap {
    class Entity{
        int key;
        int value;
    }
    class Basket{
        Node head;
        class Node{
            Entity entity;
            Node next;
        }

        private boolean push(Entity entity){
            Node node = new Node();
            node.entity = entity;

            if (head == null){
                head = node;
            } else {
                Node cur = head;
                while (cur != null){
                    if(cur.entity.key == entity.key){
                        return false;
                    }
                    if (cur.next == null){
                        cur.next = node;
                        return true;
                    }
                    cur = cur.next;
                }
            }
            return true;
        }

        private Integer find(int key){
            Node cur = head;
            while (cur != null){
                if(cur.entity.key == key){
                    return cur.entity.value;
                }
                cur = cur.next;
            }
            return null;
        }

        private boolean remove(int key){
            if (head != null){
                if (head.entity.key == key){
                    head = head.next;
                    return true;
                } else {
                    Node cur = head;
                    while (cur.next != null){
                        if(cur.next.entity.key == key){
                            cur.next = cur.next.next;
                            return true;
                        }
                        cur = cur.next;
                    }
                }
            }
            return false;
        }
    }

    static final int INIT_SIZE = 16;
    Basket[] baskets;

    public MyHashMap(){
        this(INIT_SIZE);
    }
    public MyHashMap(int size){
        baskets = new Basket[size];
    }

    private int getIndex(int key){
        return (key % baskets.length + baskets.length) % baskets.length; // [0, length - 1]
        //key = 22, getIndex(22) = 22 % 16 = 6
    }

    public boolean push(int key, int value){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket == null){
            basket = new Basket();
            baskets[index] = basket;
        }
        Entity entity = new Entity();
        entity.key = key;
        entity.value = value;
        return basket.push(entity);
    }

    public Integer find(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.find(key);
        }
        return null;
    }

    public boolean remove(int key){
        int index = getIndex(key);
        Basket basket = baskets[index];
        if (basket != null){
            return basket.remove(key);
        }
        return false;
    }
}