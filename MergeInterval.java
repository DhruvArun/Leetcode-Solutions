import java.util.*;

class MergeInterval {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> ans = new ArrayList<>();
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        ans.add(intervals[0]);
        
        for (int i = 1; i < intervals.length; i++) {
            int curStart = intervals[i][0];
            
            if (curStart <= ans.get(ans.size() - 1)[1]) {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], intervals[i][1]);
            } 
            else {
                ans.add(intervals[i]);
            }
        }
        
        int[][] res = new int[ans.size()][2];
        ans.toArray(res);
        
        return res;
    }
}
