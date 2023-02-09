package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class EquilibrimIndex {
    public static void main(String[] args) {
        ArrayList<Integer> i = new ArrayList<>();
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        for(int k = 0;k<str.length();k++){
                if(!String.valueOf(str.charAt(k)).equals(",")){
                    if(Character.isDigit(str.charAt(k))){
                        i.add(Integer.valueOf(String.valueOf(str.charAt(k))));
                    }else{
                        i.add(Integer.valueOf("-"+(str.charAt(k+1))));
                    }
                }
        }
        for (int j = 0; j < i.size(); j++) {
            if(i.get(j) < 0) i.remove(j+1);
        }
        int[] arr = new int[i.size()];
        for (int j = 0; j < i.size(); j++) {
            arr[j] = i.get(j);
        }
        System.out.println(helper(arr));
    }
    static int helper(int[] arr){
        if(equi(arr) == -1){
            if(sumOfAll(arr,0,arr.length) == 0) return 0;
            if(sumOfAll(arr,0, arr.length-1)==0) return arr[arr.length-1];
        }
        return equi(arr);
    }
    static int equi(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int left = sumOfAll(arr,0,i);
            int right = sumOfAll(arr,i+1,arr.length);
            if(left == right){
                return i;
            }
        }
        return -1;
    }
    static int sumOfAll(int[] arr,int s,int e){
        int sum = 0;
        for(int i = s;i<e;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
