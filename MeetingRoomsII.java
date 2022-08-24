import java.util.*;

/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval (int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Interval {
    int start, end;
    Interval (int start, int end) {
    this.start = start;
    this.end = end;
    }
}

// Time Complexity - O(n * log(n))
// Space Complexity - O(n)
class MeetingRoomsII {
    public int minMeetingRooms(List<Interval> intervals) {
        int length = intervals.size();
        int[] start = new int[length];
        int[] end = new int[length];

        for (int i = 0; i < length; i++) {
            start[i] = intervals.get(i).start;
            end[i] = intervals.get(i).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int s = 0, e = 0; // Pointers
        int count = 0;
        int res = 0;

        while (s < start.length && e < end.length) {
            if (start[s] < end[e]) {
                count++;
                s++;
            }
            else {
                count--;
                e++;
            }
            res = Math.max(res, count);
        }

       return res;
    }
}