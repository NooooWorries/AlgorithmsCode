package com.assignments.assgt02;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int size;
    private Node first;
    private Node last;

    private class Node{
        public Item item;
        public Node previous;
        public Node next;
    }

    private class DequeIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public Item next(){
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item){
        if (item == null)
            throw new IllegalArgumentException();

        Node temp = first;
        first = new Node();
        first.item = item;
        first.previous = null;
        first.next = temp;

        if (temp != null)
            temp.previous = first;
        if (last == null)
            last = first;
        size++;

        return;
    }

    public void addLast(Item item){
        if (item == null)
            throw new IllegalArgumentException();

        Node temp = last;
        last = new Node();
        last.item = item;
        last.next = null;
        last.previous = temp;
        if(temp != null)
            temp.next = last;
        else
            first = last;
        size++;

        return;
    }

    public Item removeFirst(){
        if (isEmpty())
            throw new NoSuchElementException();

        Node temp = first;
        first = first.next;
        temp.next = null;
        if (first != null) {
            first.previous = null;
        }
        size --;
        if (isEmpty()){
            first = null;
            last = null;
        }

        return temp.item;
    }

    public Item removeLast(){
        if (isEmpty())
            throw new NoSuchElementException();

        Node temp = last;
        last = last.previous;
        temp.previous = null;
        if (last != null) {
            last.next = null;
        }
        size --;
        if (isEmpty()){
            first = null;
            last = null;
        }

        return last.item;
    }

    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    public static void main(String[] args) {

    }
}
