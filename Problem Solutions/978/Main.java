import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int num_cases = sc.nextInt();
        
        // Iterate through cases
        for(int i = 0; i < num_cases; i++) {
            int battlefields = sc.nextInt();
            int num_green = sc.nextInt();
            int num_blue = sc.nextInt();
            
            PriorityQueue<Integer> green_team = new PriorityQueue<>(num_green,Collections.reverseOrder());
            PriorityQueue<Integer> blue_team = new PriorityQueue<>(num_blue,Collections.reverseOrder());
            
            // Initialise the teams
            for(int j = 0; j < num_green; j++) {
                green_team.add(sc.nextInt());
            }

            for(int j = 0; j < num_blue; j++) {
                blue_team.add(sc.nextInt());
            }

            // Simulate battles
            while(green_team.size() != 0 && blue_team.size() != 0) {
                ArrayList<Integer> green_survivors = new ArrayList<>();
                ArrayList<Integer> blue_survivors = new ArrayList<>();

                for(int battle = 0; battle < battlefields; battle++) {
                    // Break if team is empty
                    if(green_team.size() == 0 || blue_team.size() == 0) {
                        break;
                    }

                    // Pop the strongest soldiers
                    int green_soldier = green_team.poll();
                    int blue_soldier = blue_team.poll();

                    // Check who is stronger
                    if(green_soldier > blue_soldier) {
                        green_survivors.add(green_soldier - blue_soldier);
                    } else if(blue_soldier > green_soldier) {
                        blue_survivors.add(blue_soldier - green_soldier);
                    }

                    // Otherwise there is no survivors
                }

                // After the battles we put the survivors back into the teams
                for(Integer survivor:green_survivors) {
                    green_team.add(survivor);
                }
                for(Integer survivor:blue_survivors) {
                    blue_team.add(survivor);
                }
            }
            
            if(green_team.size() == 0 && blue_team.size() == 0) {
                System.out.println("green and blue died");
            } else if(green_team.size() == 0) { 
                System.out.println("blue wins");
                while(blue_team.size() != 0) {
                    System.out.println(blue_team.poll());
                }
            } else {
                System.out.println("green wins");
                while(green_team.size() != 0) {
                    System.out.println(green_team.poll());
                }
            }

            if(i != num_cases - 1) {
                System.out.println();
            }
        }
    }
}
