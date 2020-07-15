import java.util.Scanner;
import java.util.PriorityQueue;

/*
 * Find the minimal cost by only adding the minimal possible cost until the sum of the list is found.
 */
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n != 0) {
            PriorityQueue<Integer> q = new PriorityQueue<>();

            for(int i = 0; i < n; i++) {
                q.add(sc.nextInt());
            }

            int total_cost = 0;
            
            // Keep adding till we have no more to add together
            while(q.size() > 1) {
                // Add the two smallest numbers in the queue and add back to the queue
                int temp_sum = q.poll() + q.poll();
                q.add(temp_sum);
                // The sum will be the cost of the addition operation
                total_cost += temp_sum;
            }

            System.out.println(total_cost);

            n = sc.nextInt();
        }
    }
}
