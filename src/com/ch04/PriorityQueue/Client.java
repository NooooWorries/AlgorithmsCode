package com.ch04.PriorityQueue;

public class Client {
    public static void main(String[] args){
        MaxPQ<Integer> pq = new MaxPQ<Integer>(10);
        for(int i = 10; i > 0; i--){
            pq.insert(i);
        }
        for(int i = 0; i < 10; i ++){
            System.out.println(pq.delMax());
        }
    }

}
