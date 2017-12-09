package com.assignments.assgt02;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] queue;
    private int size;

    public RandomizedQueue(){
        size = 0;
        queue = (Item[]) new Object[1];

    }

    private class RandomizedQueueIterator implements Iterator<Item>{

        int n;
        Item[] tempQueue;

        public RandomizedQueueIterator(){
            n = size;
            tempQueue = (Item[]) new Object[n];
            for (int i = 0; i < n; i++)
                tempQueue[i] = queue[i];
            StdRandom.shuffle(tempQueue);
        }

        @Override
        public boolean hasNext(){
            return n > 0;
        }

        @Override
        public Item next(){
            if (n == 0)
                throw new NoSuchElementException();
            return tempQueue[--n];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private void resize(int max){
        // Move queue to a new array of size max
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i ++)
            temp[i] = queue[i];
        queue = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(Item item){
        if (item == null)
            throw new IllegalArgumentException();

        if (size == queue.length)
            resize(2 * queue.length);

        queue[size++] = item;

    }

    public Item deque(){
        if (isEmpty())
            throw new NoSuchElementException();

        int index = StdRandom.uniform(size);
        Item temp = queue[index];

        if (index != size - 1)
            queue[index] = queue[size - 1];
        queue[size - 1] = null;
        size --;

        return temp;
    }

    public Item sample(){
        if (isEmpty())
            throw new NoSuchElementException();

        int index = StdRandom.uniform(size);
        Item temp = queue[index];

        return temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    public static void main (String[] args){

    }
}
