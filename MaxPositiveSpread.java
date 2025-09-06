//max positive spread

import java.util.*;

public class Solution {
    public static int maximumPositiveSpread(int[] prices) {
        if (prices == null || prices.length < 2) {
            return -1; // not enough data
        }

        int minPrice = prices[0];
        int maxSpread = -1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                maxSpread = Math.max(maxSpread, prices[i] - minPrice);
            }
            minPrice = Math.min(minPrice, prices[i]);
        }

        return maxSpread;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maximumPositiveSpread(prices);
        System.out.println(result);
    }
}
