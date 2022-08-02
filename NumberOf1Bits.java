import java.util.*;

class NumberOf1Bits {
    // Treat n as an unsigned value
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        
        char[] sArr = s.toCharArray();
        
        int count = 0;
        
        for(int i = 0; i < sArr.length; i++) {
            if (sArr[i] == '1') {
                count += 1;
            }
        }
        
        return count;
    }
}
