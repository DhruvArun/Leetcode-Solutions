import java.util.*;

class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] firstInterval = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            if (firstIntervalWithinSecond(firstInterval, intervals[i])) {
                count++;
                if (firstInterval[1] > intervals[i][1]) {
                    firstInterval = intervals[i];
                }
            }
            else {
                firstInterval = intervals[i];
            }
        }
        
        return count;
    }
    
    public boolean firstIntervalWithinSecond(int[] intervalFirst, int[] intervalSecond) {
        return intervalSecond[0] < intervalFirst[1];
    }
}
