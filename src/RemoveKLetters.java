

public class RemoveKLetters {

    static String combination;
    static int value = Integer.MAX_VALUE;

    void indexCombination(int size, int k) { indexCombination(size, "", k, 0); }

    void indexCombination(int size, String comb, int k, int start) {
        if(k == 0) {
            StringBuilder result = new StringBuilder(combination);
            for (char current : comb.toCharArray())
                result.setCharAt(Integer.parseInt(String.valueOf(current)), '$');
            int num = Integer.parseInt(result.toString().replace("$",""));
            value = Math.min(value, num);
        } else {
            int prev = -1;
            for(int i = start; i < size; i++) {
                if(prev != i) {
                    comb = comb + i;
                    indexCombination(size, comb, k -1, i + 1);
                    comb = comb.substring(0, comb.length() - 1);

                    prev = i;
                }
            }
        }
    }

    public static void main(String args[]) {
        combination = "10200";
        new RemoveKLetters().indexCombination(combination.length(),1 );
        System.out.println(value);
    }
}