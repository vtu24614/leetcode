import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Step 1: Count the frequency of each task
        int[] freq = new int[26];
        for (char t : tasks) {
            freq[t - 'A']++;
        }

        // Step 2: Sort frequencies in ascending order
        Arrays.sort(freq);

        // Step 3: Find the maximum frequency
        int maxFreq = freq[25];

        // Step 4: Count how many tasks have the maximum frequency
        int countMax = 0;
        for (int i = 25; i >= 0; i--) {
            if (freq[i] == maxFreq) countMax++;
            else break;
        }

        // Step 5: Calculate minimum intervals
        int minTime = (maxFreq - 1) * (n + 1) + countMax;

        // Step 6: Return the maximum between total tasks and the calculated minTime
        return Math.max(minTime, tasks.length);
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        char[] tasks1 = {'A','A','A','B','B','B'};
        System.out.println(sol.leastInterval(tasks1, 2)); // Output: 8

        char[] tasks2 = {'A','C','A','B','D','B'};
        System.out.println(sol.leastInterval(tasks2, 1)); // Output: 6

        char[] tasks3 = {'A','A','A','B','B','B'};
        System.out.println(sol.leastInterval(tasks3, 3)); // Output: 10
    }
}