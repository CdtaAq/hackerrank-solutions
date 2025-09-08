//arraychallenge

import java.util.*;

public class Main {

    public static String ArrayChallenge(String[] strArr) {
        String word = strArr[0];  // first element
        String[] dictArray = strArr[1].split(",");
        Set<String> dict = new HashSet<>(Arrays.asList(dictArray));

        // Try all possible splits
        for (int i = 1; i < word.length(); i++) {
            String left = word.substring(0, i);
            String right = word.substring(i);

            if (dict.contains(left) && dict.contains(right)) {
                return left + "," + right;
            }
        }
        return "not possible";
    }

    public static void main(String[] args) {
        // Example 1
        String[] input1 = {"baseball", "a,all,b,ball,bas,base,cat,code,d,e,quit,z"};
        System.out.println(ArrayChallenge(input1)); // Output: base,ball

        // Example 2
        String[] input2 = {"abcgefd", "a,ab,abc,abcg,b,c,dog,e,efd,zzzz"};
        System.out.println(ArrayChallenge(input2)); // Output: abcg,efd
    }
}
