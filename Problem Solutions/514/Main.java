import java.util.Scanner;
import java.util.Stack;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num_carriages = sc.nextInt();
        while(num_carriages != 0) {        
            // Assumption: For a specified amount of carriages > 0, there will be at least 1 case for the amount of carriages
            
            int first_num = sc.nextInt();
            while(first_num != 0) {
                Stack<Integer> station = new Stack<>();
                int[] targets = new int[num_carriages];
                targets[0] = first_num;
                for(int i = 1; i < targets.length; i++) {
                    targets[i] = sc.nextInt();
                }
                
                // cur_target_index: 0,1,2,...,targets.length
                int cur_target_index = 0;
                // cur_carriage: 1,2,..., num_carriages
                int cur_carriage = 1;
                
                // If we go through all the targets then it is possible
                boolean possible = true;
               
                // When we reach the end of target that means it is possible to rearrange the carriages
                while(cur_target_index < targets.length) {
                    // If stack is empty or current target doesn't equal to top of stack we push the next carriage
                    // Else, we have found the target and we can move on to next target
                    if(station.empty() || targets[cur_target_index] != station.peek()) {
                        // We want to check if the cur_carriage is a valid carriage (in range) because if it's exceeded num_carriages then we can't reach our current target therefore not possible
                        if(cur_carriage > num_carriages) {
                            possible = false;
                            break;
                        }
                        station.push(cur_carriage);
                        cur_carriage += 1;
                    } else {
                        station.pop();
                        cur_target_index += 1;
                    }
                }
                
                String result = (possible) ? "Yes":"No";
                System.out.println(result);

                /* Equivalent

                if(possible) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }

                */

                first_num = sc.nextInt();
            }
            System.out.println();
            num_carriages = sc.nextInt();
        }
    }
}
