package com.ch01.QuickUnion;

import java.util.Scanner;

public class Client {
    public static void main (String[] args) {
        // Scanner
        Scanner scanner = new Scanner(System.in);

        // Ask for number of pairs
        int pairs = 0;
        System.out.println("[Quick union] How many paris do you want to create?");
        pairs = scanner.nextInt();
        QuickUnion quickUnion = new QuickUnion(pairs);

        // Provide detail information of pairs and union them by calling union function
        for (int i = 0; i < pairs; i ++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            // If not connected, connect them
            if (!quickUnion.connected(p, q)) {
                quickUnion.union(p, q);
                System.out.println(p + " " + q);
            }
        }
    }
}
