import java.util.*;

class CountingBits {
    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        
        int i = 0;
        
        while(i <= n) {
            String s = Integer.toBinaryString(i);
            
            int count = 0;
            char[] sArr = s.toCharArray();
                for (int j = 0; j < sArr.length; j++) {
                    if (sArr[j] == '1') {
                        count++;
                    }
                }
            result[i] = count;
            i++;
        }
        
        return result;
    }
}
