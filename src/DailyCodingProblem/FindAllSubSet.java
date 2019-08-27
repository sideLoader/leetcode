package DailyCodingProblem;


public class FindAllSubSet {

    public static void printSubSet(int input[]) { printSubSet(input, "", 0); }

    private static void printSubSet(int input[], String soFar, int index) {
        if(index >= input.length) {
            System.out.println(soFar);
        } else {
            printSubSet(input, soFar, index +1);
            printSubSet(input, soFar + input[index], index +1);
        }
    }

    public static void main(String args[]) {
        int input[] = {1,7,3,2};
        printSubSet(input);
    }
}
