import java.util.*;

class MakeTheStringGreat {
    public String makeGood(String s) {
        for(int i=0;i<(s.length()-1);i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i+1)) == 32) {
                return makeGood(s.substring(0,i) + s.substring(i+2,s.length()));
            } 
        }
        
        return s;
    }
}