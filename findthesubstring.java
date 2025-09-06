//find the substring

public class SubstringFinder {

    public static int firstOccurrence(String s, String x) {
        int n = s.length();
        int m = x.length();

        // loop through possible start positions
        for (int i = 0; i <= n - m; i++) {
            boolean match = true;
            
            for (int j = 0; j < m; j++) {
                char xc = x.charAt(j);
                char sc = s.charAt(i + j);
                
                // if not wildcard, must match exactly
                if (xc != '*' && xc != sc) {
                    match = false;
                    break;
                }
            }
            
            if (match) {
                return i; // first match found
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        String s = "xabcdey";
        String x = "ab*de";
        
        System.out.println(firstOccurrence(s, x)); // Output: 1
    }
}
