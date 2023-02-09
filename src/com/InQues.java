package com;

public class InQues {
    public static void main(String[] args) {
        System.out.println("For n = 2 (expected: 0): "+numberOfRotates(2));
        System.out.println("For n = 3 (expected: -1): "+numberOfRotates(3));
        System.out.println("For n = 431 (expected: 2): "+numberOfRotates(431));
        System.out.println("For n = 13 (expected: -1): "+numberOfRotates(13));
        System.out.println("For n = 41 (expected: 1): "+numberOfRotates(41));
        System.out.println("For n = 441 (expected: 1): "+numberOfRotates(441));
        System.out.println("For n = 2231 (expected: 2): "+numberOfRotates(2231));
        System.out.println("For n = 2001 (expected: 1): "+numberOfRotates(2001));
        System.out.println("For n = 2331 (expected: 3): "+numberOfRotates(2331));
    }
    public static int numberOfRotates(int n){
        if(n % 2 == 0) return 0;
        int count = 0;
        while(n != 0){
            if((n%10) % 2 != 0){
                count++;
            }else{
                return count;
            }
            n /= 10;
        }
        return -1;
    }
}
