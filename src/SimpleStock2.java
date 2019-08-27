
public class SimpleStock2 {

    public static void main(String args[]) {
        int input[] = new int[]{7,1,5,3,6,4};
        int i = 1, buyIndex = 0, sellIndex = 0;

        while(i <= input.length -1) {

            while(input[i -1] > input[i])
                i++;
            buyIndex = i -1;

            while(input[i]  < input[i -1])
                i++;
            sellIndex = i -1;

            System.out.println("buy : " + buyIndex + " sell : " + sellIndex);
        }
    }
}
