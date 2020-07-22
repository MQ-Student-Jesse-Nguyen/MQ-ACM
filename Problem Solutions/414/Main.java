import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        while(n != 0) {
            // Total amount of blanks - ((smallest amount of blanks for a line)*n)
            
            int total_blanks = 0;
            int min_blanks_line = -1;

            for(int i = 0; i < n; i++) {
                String line = sc.nextLine();

                int cur_num_blanks = line.lastIndexOf(" ") - line.indexOf(" ");
                
                total_blanks += cur_num_blanks;

                // Check if min
                if(min_blanks_line == -1 || min_blanks_line > cur_num_blanks) {
                    min_blanks_line = cur_num_blanks;
                }
            }

            System.out.println(total_blanks - (min_blanks_line*n));
            
            n = sc.nextInt();
            sc.nextLine();
        }
    }
}

