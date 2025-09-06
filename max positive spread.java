//max positive spread

public class StockSpread {

    public static int maxPositiveSpread(int[] px) {
        if (px == null || px.length < 2) return -1;

        int minPrice = px[0];
        int maxSpread = -1;

        for (int i = 1; i < px.length; i++) {
            int spread = px[i] - minPrice;
            if (spread > 0) {
                maxSpread = Math.max(maxSpread, spread);
            }
            minPrice = Math.min(minPrice, px[i]);
        }

        return maxSpread;
    }

    public static void main(String[] args) {
        int[] px1 = {7, 1, 2, 5};
        System.out.println(maxPositiveSpread(px1)); // Output: 4

        int[] px2 = {7, 5, 3, 1};
        System.out.println(maxPositiveSpread(px2)); // Output: -1
    }
}
