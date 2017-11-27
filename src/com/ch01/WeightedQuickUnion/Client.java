package com.ch01.WeightedQuickUnion;

import java.util.Scanner;

public class Client {
    public static void main (String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for number of pairs
        int pairs = 0;
        System.out.println("[Weighted quick union] How many paris do you want to create?");
        pairs = scanner.nextInt();
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(pairs);

        // Provide detail information of pairs and union them by calling union function
        for (int i = 0; i < pairs; i ++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            // If not connected, connect them
            if (!weightedQuickUnion.connected(p, q)) {
                weightedQuickUnion.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
