//website pagination

import java.util.*;

class Result {

    public static List<String> fetchItemsToDisplay(
            List<List<String>> items, 
            int sortParameter, 
            int sortOrder, 
            int itemsPerPage, 
            int pageNumber) {

        // Step 1: Sort items
        items.sort((a, b) -> {
            String val1 = a.get(sortParameter);
            String val2 = b.get(sortParameter);

            int cmp;
            if (sortParameter == 0) { // name: string compare
                cmp = val1.compareTo(val2);
            } else { // relevance or price: numeric compare
                cmp = Integer.compare(Integer.parseInt(val1), Integer.parseInt(val2));
            }

            return sortOrder == 0 ? cmp : -cmp; // ascending or descending
        });

        // Step 2: Pagination
        int start = pageNumber * itemsPerPage;
        int end = Math.min(start + itemsPerPage, items.size());

        List<String> result = new ArrayList<>();
        for (int i = start; i < end; i++) {
            result.add(items.get(i).get(0)); // only name
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) {
        List<List<String>> items = new ArrayList<>();
        items.add(Arrays.asList("item1", "10", "15"));
        items.add(Arrays.asList("item2", "3", "4"));
        items.add(Arrays.asList("item3", "17", "8"));

        int sortParameter = 1;  // relevance
        int sortOrder = 0;      // ascending
        int itemsPerPage = 2;
        int pageNumber = 1;

        List<String> output = Result.fetchItemsToDisplay(items, sortParameter, sortOrder, itemsPerPage, pageNumber);
        System.out.println(output); // Expected: [item3]
    }
}
