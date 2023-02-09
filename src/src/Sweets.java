package src;

import java.util.Arrays;

public class Sweets {
    public static void main(String[] args) {
        int numberOfStudents = 6;
        int[][] arr = {{3,6},{1,6},{7,11},{2,15},{5,8},{1,2},{2,11},{2,10},{2,7},{2,6}};
        System.out.println(Arrays.toString(sweets(arr)));

    }
    static int[] sweets(int[][] arr){
        int[] res = new int[2];
        int sweetN = min(arr);
        while (sweetN  < max(arr)){
            int c = 0;
            for (int i = 0; i < arr.length; i++) {
                if (sweetN >= arr[i][0] && sweetN <= arr[i][1]){
                    c = c+1;
                }
            }

            if(c > res[1]){
                res[0] = sweetN;
                res[1] = c;
            }
            sweetN = sweetN+1;
        }
        return res;
    }
    static int min(int[][] arr){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                min = Math.min(min,arr[i][j]);
            }
        }
        return min;
    }
    static int max(int[][] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                max = Math.max(max,arr[i][j]) ;
            }
        }
        return max;
    }
}
