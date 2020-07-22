import java.util.Scanner;

class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int extra_butts = 0;
            int cur_butts = n;
            while(cur_butts >= k) {
                // Extra butts is how many times k can go into n
                extra_butts += cur_butts / k;
                // Extra created from leftover plus the leftover that isn't used for creating new butt
                cur_butts = (cur_butts / k) + (cur_butts % k);
            }

            System.out.println(n + extra_butts);
        }
    }
}

