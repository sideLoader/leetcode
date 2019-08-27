import java.util.*;
import java.util.stream.Collectors;



public class KNonRepeatingChar {

    void permute(String str) { permute(str,""); }

    void permute(String str, String soFar) {
        if(str.equals("")) {
            System.out.println(soFar);
        } else {
            for(char curr : str.toCharArray()) {
                soFar += Character.toString(curr);
                str = str.substring(1);

                permute(str, soFar);

                str += Character.toString(curr);
                soFar = soFar.substring(0, soFar.length() -1);
            }
        }
    }


    public static void main(String[] args) {
        String str = "vdep";
        //System.out.println(str.substring(1, str.length()-));
        new KNonRepeatingChar().permute(str);
    }
}