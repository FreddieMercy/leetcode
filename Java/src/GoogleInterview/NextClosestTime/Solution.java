package GoogleInterview.NextClosestTime;

import java.util.Arrays;

public class Solution {
    public String nextClosestTime(String time) {

        if (time.equals("24:00")) {
            return "00:02";
        }

        char[] arr = time.toCharArray();
        char[] times = time.toCharArray();
        times[2] = times[3];
        times[3] = times[4];
        times[4] = ':';
        Arrays.sort(arr);
        int[] limits = new int[]{2, 9, 5, 9};

        if (times[0] == '2') {
            limits[1] = 4;
        }

        for (int i = 3; i >= 0; --i) {
            for (int j = 0; j <= 3; ++j) {
                int cur = arr[j] - '0';
                if (cur > times[i] - '0' && cur <= limits[i]) {
                    times[i] = arr[j];
                    times[4] = times[3];
                    times[3] = times[2];
                    times[2] = ':';
                    return new String(times);
                }
            }

            times[i] = arr[0];
        }
        times[4] = times[3];
        times[3] = times[2];
        times[2] = ':';
        return new String(times);
    }
}