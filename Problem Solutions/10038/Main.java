import java.util.Scanner;
import java.util.HashSet;

/*
 * Find that the mathematical set of differences for the list of numbers given consists of the numbers 1 - n exist.
 */
class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNext()) {
            int num_elements = sc.nextInt();

            if(num_elements == 1) {
                System.out.println("Jolly");
                sc.nextInt();
                continue;
            }

            HashSet<Integer> diffs = new HashSet<>();

            int cur_element = 0;
            int next_element = sc.nextInt();
            
            // Skip last element
            for(int i = 0; i < num_elements - 1; i++) {
                cur_element = next_element;
                next_element = sc.nextInt();
                
                int diff = Math.abs(cur_element - next_element);
                // Diff must be less than n and not equal 0
                if(diff < num_elements && diff != 0) {
                    diffs.add(diff);
                }
            }

            // Check if the diff set has expected output (1,2,...,num_elements-1)
            // Since it's a set we can just compare the length
            if(num_elements - 1 == diffs.size()) {
                System.out.println("Jolly");
            } else {
                System.out.println("Not jolly");
            }
        }
    }
}
