package com.ch01.WeightedQuickUnion;

public class WeightedQuickUnion {
    private int[] id;
    private int[] size;

    public WeightedQuickUnion(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int root (int i) {
        while(id[i] != i) {
            // Comprised path
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public boolean connected (int p, int q) {
        return root(p) == root(q);
    }

    public void union (int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if (pRoot == qRoot) return;
        // Left smaller, right larger
        // the root of larger tree (right) is parent
        else if (size[pRoot] < size[qRoot]) {
            id[pRoot] = qRoot;
            size[qRoot] = size[qRoot] + size[pRoot];
        }
        // Left larger, right smaller
        // the root of larger tree (left) is parent
        else {
            id[qRoot] = pRoot;
            size[pRoot] = size[pRoot] + size[qRoot];
        }
    }
}
