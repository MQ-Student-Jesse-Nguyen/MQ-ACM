import java.util.Scanner;

/*
 * Continue scanning until there are no more ints.
 */
class ContiniousIntScan {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextInt()) {
            int curNum = sc.nextInt();
            System.out.println(curNum);
        }
    }
}

/*
 * Scan until specified String is inputted (word by word).
 * - Note that sc.next() will also include the newline character (\n) as it's own word.
 *     - Hence why I use "print" instead of "println" as "println" adds a newline character.
 */
class SpecifiedEndWord {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        String end = "Stop";
        
        String curWord = sc.next();
        while(!curWord.equals(end)) {
            System.out.print(curWord);
        }
    }
}

/*
 * Scan until specified String is inputted (line by line).
 * - Recommend this for when having multiple inputs for a single line
 */
class SpecifiedEndLine {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String end = "Stop";

        String curLine = sc.nextLine();
        while(!curLine.equals(end)) {
            System.out.println(curLine);
        }
    }
}

/*
 * Scan multiple inputs on a single line
 *
 * Problem:
 * Add two numbers on a single line and output the result.
 */
class MultipleInputsLine {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            String curLine = sc.nextLine();
            String[] stringNums = curLine.split(" ");
            int[] intNums = new int[2];
            for(int i = 0; i < stringNums.length; i++) {
                // Convert String to int
                intNums[i] = Integer.parseInt(stringNums[i]);
            }

            /* Can be shorten to (will still perform the same):
            int[] intNums = Stream.of(curLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            */

            System.out.println(intNums[0] + intNums[1]);
        }
    }
}
