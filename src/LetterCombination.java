
public class LetterCombination {

    void binPerm(String soFar, int size, String input) {
        if(size == 0) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < input.length(); i++) {
                if(soFar.charAt(i) == '1')
                    sb.append(input.charAt(i));
            }
            System.out.println(sb.toString());
        } else {
            binPerm(soFar + "1", size -1, input);
            binPerm(soFar + "0", size -1, input);
        }
    }

    void combination(String soFar, int size, String input, int start) {
        if(size == 0) {
            System.out.println(soFar);
        } else {
            for(int i = start; i < input.length(); i++) {
                soFar = soFar + input.charAt(i);
                combination(soFar, size -1, input, i +1);
                soFar = soFar.substring(0, soFar.length() -1);
            }
        }
    }
    public static void main(String args[]) {
        LetterCombination lc = new LetterCombination();
        String input = "vdep";
        lc.combination("",input.length(), input, 0);
    }
}
