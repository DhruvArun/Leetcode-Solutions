import java.util.*;

class RotateImage {
    // Cannot create a new matrix, rotation must be in-place.
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        for (int k = 0; k < matrix.length; k++) {
            reverse(matrix[k]);
        }    
    }
    
    public void transpose(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    //  Reversal by looping through the Array.
    public void reverse(int[] array) {
        for (int i=0; i < array.length / 2; i++) {   
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    //     Reversal using a Stack 
//     public void reverse(int[] array) {
//         Stack<Integer> stack = new Stack<Integer>();
        
//         for (int k = 0; k < array.length; k++) {
//             stack.push(array[k]);        
//         }
        
//         for (int l = 0; l < array.length; l++) {
//             array[l] = stack.pop();
//         }
//     }

}
