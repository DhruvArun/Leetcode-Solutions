import java.util.*;

// Time Complexity - O(n)
// Space Complexity - O(n)
class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<List<Integer>> stack = new Stack<List<Integer>>(); // (index, height)
        
        for (int i = 0; i < heights.length; i++) {
            int start = i, h = heights[i];
            
            while (!stack.isEmpty() && stack.peek().get(1) > h) {
                int index = stack.peek().get(0), height = stack.peek().get(1);
                stack.pop();
                maxArea = Math.max(maxArea, (height * (i - index)));
                start = index;
            }
            
            stack.add(Arrays.asList(start, h));
        }
        
        for (List lst : stack) {
            int i = (int) lst.get(0), h = (int) lst.get(1);
            maxArea = Math.max(maxArea, (h * (heights.length - i)));
        }
        
        return maxArea;
    }
}