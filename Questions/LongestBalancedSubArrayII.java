import java.util.*;

class Solution {

    static class Node {
        int min, max, lazy;
    }

    Node[] seg;
    int n;

    void apply(int node, int val) {
        seg[node].min += val;
        seg[node].max += val;
        seg[node].lazy += val;
    }

    void push(int node) {
        if (seg[node].lazy != 0) {
            apply(node * 2, seg[node].lazy);
            apply(node * 2 + 1, seg[node].lazy);
            seg[node].lazy = 0;
        }
    }

    void pull(int node) {
        seg[node].min = Math.min(seg[node * 2].min, seg[node * 2 + 1].min);
        seg[node].max = Math.max(seg[node * 2].max, seg[node * 2 + 1].max);
    }

    void update(int node, int l, int r, int ql, int qr, int val) {
        if (ql > r || qr < l) return;

        if (ql <= l && r <= qr) {
            apply(node, val);
            return;
        }

        push(node);
        int mid = (l + r) / 2;

        update(node * 2, l, mid, ql, qr, val);
        update(node * 2 + 1, mid + 1, r, ql, qr, val);

        pull(node);
    }

    int findFirst(int node, int l, int r, int limit) {
        if (l > limit || seg[node].min > 0 || seg[node].max < 0)
            return -1;

        if (l == r)
            return l;

        push(node);
        int mid = (l + r) / 2;

        int res = findFirst(node * 2, l, mid, limit);
        if (res != -1) return res;

        return findFirst(node * 2 + 1, mid + 1, r, limit);
    }

    public int longestBalanced(int[] nums) {

        n = nums.length;
        seg = new Node[4 * n];
        for (int i = 0; i < seg.length; i++)
            seg[i] = new Node();

        int[] last = new int[100001];
        Arrays.fill(last, -1);

        int ans = 0;

        for (int i = 0; i < n; i++) {

            int val = nums[i];
            int prev = last[val];

            int diff = (val % 2 == 0) ? 1 : -1;

            update(1, 0, n - 1, prev + 1, i, diff);

            last[val] = i;

            int start = findFirst(1, 0, n - 1, i);

            if (start != -1)
                ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}