import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> requests;

    // Initialize the RecentCounter
    public RecentCounter() {
        requests = new LinkedList<>();
    }

    // Add a new request at time t and return the number of requests in the last 3000ms
    public int ping(int t) {
        // Add the new request
        requests.offer(t);

        // Remove all requests that are older than t - 3000
        while (!requests.isEmpty() && requests.peek() < t - 3000) {
            requests.poll();
        }

        // The remaining requests in the queue are within the 3000ms window
        return requests.size();
    }

    // Example usage
    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();

        System.out.println(recentCounter.ping(1));    // Output: 1
        System.out.println(recentCounter.ping(100));  // Output: 2
        System.out.println(recentCounter.ping(3001)); // Output: 3
        System.out.println(recentCounter.ping(3002)); // Output: 3
    }
}