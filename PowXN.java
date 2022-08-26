import java.util.*;

// Time Complexity - O(log(n) / log(2)) => O(log(n) / 0.301029996) => O(log(n))
// Divide & Conquer - Recursion
class PowXN {
    public double myPow(double x, int n) {
        if (x == -1.0) {
            return n % 2 == 0 ? 1.0 : -1.0;
        }
        if (n == Integer.MIN_VALUE) {
            return x == 1.0 ? 1.0 : 0.0;
        }
        if (x == 1.0 || n == 0) {
            return 1.0;
        }
        
        double res = helper(x, Math.abs(n));        
        return n > 0 ? res : (1.0 / res);
    }
    
    public double helper(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        double res = helper(x, n / 2);
        res *= res;
        
        return n % 2 == 0 ? res : (x * res);
    }
}

// Time Complexity - O(n)
class AlternateSolution {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }
        if (x == 1.0) {
            return 1.0;
        }
        if (x == -1.0) {
            if (n % 2 == 0) {
                return 1.0;
            }
            else {
                return -1.0;
            }
        }
        if (n == Integer.MIN_VALUE) {
            return 0.0;
        }
        
        double temp = x;
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                x *= temp;
            }
            
            return x;
        }
        else {
            for (int i = 1; i < (-1 * n); i++) {
                x *= temp;
            }
            
            return (1.0 / x);
        }
    }
}