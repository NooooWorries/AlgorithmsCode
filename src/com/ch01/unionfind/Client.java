package com.ch01.unionfind;

import java.util.Scanner;

public class Client {
    public static void main (String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for number of pairs
        int pairs = 0;
        System.out.println("[Union find] How many paris do you want to create?");
        pairs = scanner.nextInt();
        UnionFind unionFind = new UnionFind(pairs);

        // Provide detail information of pairs and union them by calling union function
        for (int i = 0; i < pairs; i ++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            // If not connected, connect them
            if (!unionFind.connected(p, q)) {
                unionFind.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
