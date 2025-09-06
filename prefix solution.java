//prefix hierarchy

import java.util.*;

public class PrefixHierarchy {

    public static List<Integer> findCompletePrefixes(List<String> names, List<String> queries) {
        List<Integer> results = new ArrayList<>();

        for (String q : queries) {
            int count = 0;
            for (String name : names) {
                if (name.startsWith(q) && name.length() > q.length()) {
                    count++;
                }
            }
            results.add(count);
        }
        return results;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList("steve", "stevens", "danny", "steves", "dan",
                                           "john", "johnny", "joe", "alex", "alexander");

        List<String> queries = Arrays.asList("steve", "alex", "joe", "john", "dan");

        List<Integer> result = findCompletePrefixes(names, queries);
        for (int val : result) {
            System.out.println(val);
        }
    }
}
