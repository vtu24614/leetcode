import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> maxDeque = new ArrayDeque<>();
                    Deque<Integer> minDeque = new ArrayDeque<>();

                            int left = 0;
                                    int result = 0;

                                            for (int right = 0; right < nums.length; right++) {

                                                        // Maintain maxDeque (decreasing)
                                                                    while (!maxDeque.isEmpty() && nums[right] > maxDeque.peekLast()) {
                                                                                    maxDeque.pollLast();
                                                                                                }
                                                                                                            maxDeque.addLast(nums[right]);

                                                                                                                        // Maintain minDeque (increasing)
                                                                                                                                    while (!minDeque.isEmpty() && nums[right] < minDeque.peekLast()) {
                                                                                                                                                    minDeque.pollLast();
                                                                                                                                                                }
                                                                                                                                                                            minDeque.addLast(nums[right]);

                                                                                                                                                                                        // Shrink window if invalid
                                                                                                                                                                                                    while (maxDeque.peekFirst() - minDeque.peekFirst() > limit) {
                                                                                                                                                                                                                    if (nums[left] == maxDeque.peekFirst()) {
                                                                                                                                                                                                                                        maxDeque.pollFirst();
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                                        if (nums[left] == minDeque.peekFirst()) {
                                                                                                                                                                                                                                                                                            minDeque.pollFirst();
                                                                                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                                                                                                            left++;
                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                    // Update result
                                                                                                                                                                                                                                                                                                                                                                result = Math.max(result, right - left + 1);
                                                                                                                                                                                                                                                                                                                                                                        }

                                                                                                                                                                                                                                                                                                                                                                                return result;
                                                                                                                                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                                                                                                                        // Main method for testing
                                                                                                                                                                                                                                                                                                                                                                                            public static void main(String[] args) {
                                                                                                                                                                                                                                                                                                                                                                                                    Solution obj = new Solution();

                                                                                                                                                                                                                                                                                                                                                                                                            int[] nums = {8, 2, 4, 7};
                                                                                                                                                                                                                                                                                                                                                                                                                    int limit = 4;

                                                                                                                                                                                                                                                                                                                                                                                                                            System.out.println(obj.longestSubarray(nums, limit)); // Output: 2
                                                                                                                                                                                                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                                                                                                                                                                                                                }

        
    
