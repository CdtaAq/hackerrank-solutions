//weighted interval scheduling

import java.util.*;

public class PhoneCalls {

    static class Call {
        int start, end, volume;
        Call(int s, int d, int v) {
            this.start = s;
            this.end = s + d;
            this.volume = v;
        }
    }

    public static int phoneCalls(int[] start, int[] duration, int[] volume) {
        int n = start.length;
        Call[] calls = new Call[n];

        for (int i = 0; i < n; i++) {
            calls[i] = new Call(start[i], duration[i], volume[i]);
        }

        // Sort calls by end time
        Arrays.sort(calls, Comparator.comparingInt(c -> c.end));

        // dp[i] = max volume up to i-th call
        int[] dp = new int[n];
        dp[0] = calls[0].volume;

        for (int i = 1; i < n; i++) {
            // Include current call
            int incl = calls[i].volume;

            // Find last non-overlapping call
            int l = binarySearch(calls, i);
            if (l != -1) {
                incl += dp[l];
            }

            // Exclude current call
            dp[i] = Math.max(incl, dp[i - 1]);
        }

        return dp[n - 1];
    }

    // Binary search to find the last call that ends before calls[i].start
    private static int binarySearch(Call[] calls, int i) {
        int lo = 0, hi = i - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (calls[mid].end <= calls[i].start) {
                if (calls[mid + 1].end <= calls[i].start) {
                    lo = mid + 1;
                } else {
                    return mid;
                }
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] start = {10, 5, 15, 18, 30};
        int[] duration = {30, 12, 20, 35, 35};
        int[] volume = {20, 51, 30, 25, 60};

        System.out.println(phoneCalls(start, duration, volume)); // 76
    }
}
