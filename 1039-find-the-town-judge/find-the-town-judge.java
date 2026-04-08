class Solution {
    public int findJudge(int n, int[][] trust) {
        if (n == 1 && trust.length == 0) return 1; // edge case

        int[] in = new int[n + 1];  // number of people who trust i
        int[] out = new int[n + 1]; // number of people i trusts

        for (int[] t : trust) {
            int a = t[0], b = t[1];
            out[a]++;
            in[b]++;
        }

        for (int i = 1; i <= n; i++) {
            if (out[i] == 0 && in[i] == n - 1) {
                return i; // found the judge
            }
        }

        return -1; // no judge
    }
}