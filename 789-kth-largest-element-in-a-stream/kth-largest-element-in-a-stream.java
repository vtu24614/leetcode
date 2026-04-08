import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        // Add initial elements
        for (int num : nums) {
            add(num); // reuse logic
        }
    }

    public int add(int val) {
        minHeap.add(val);

        // Keep only k elements
        if (minHeap.size() > k) {
            minHeap.poll();
        }

        // kth largest element
        return minHeap.peek();
    }
}