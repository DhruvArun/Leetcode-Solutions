import java.util.*;

class ReverseBits {
    public int reverseBits(int n) {
        int times = 32;
        List<Integer> lst = new ArrayList<>();
        
        while (times > 0) {
            int temp = n & 1;
            lst.add(temp);
            n >>= 1;
            times--;
        }
        
        int res = 0;
        
        for (int i = 0; i < lst.size(); i++) {
            res <<= 1;
            res |= lst.get(i);
        }
        
        return res;
    }
}
