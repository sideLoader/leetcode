
public class Marty {

    static void wordCombination(String input, String soFar) {
        if(input.isEmpty()) {
            System.out.println(soFar);
        } else {
            for(char temp : input.toCharArray()) {
                soFar = soFar.concat(String.valueOf(temp));
                input = input.substring(1);

                wordCombination(input, soFar);

                soFar = soFar.substring(0, soFar.length() -1);
                input = input.concat(String.valueOf(temp));
            }
        }
    }

    public static void main(String args[]) { wordCombination("vdep", ""); }
}

