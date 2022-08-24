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
class MeetingRooms {
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

       for (int i=0; i + 1 < intervals.size(); i++) {
           if (intervals.get(i).end > intervals.get(i + 1).start) {
               return false;
           }
       }

       return true;
    }
}