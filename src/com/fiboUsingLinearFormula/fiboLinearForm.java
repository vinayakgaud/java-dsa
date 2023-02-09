package com.fiboUsingLinearFormula;

public class fiboLinearForm {
    public static void main(String[] args) {
        //printing fibonnaci till n number
        int n = 11;
        for (int i = 0; i <= n; i++) {
            System.out.print(fib(i)+" ");
        }
    }

    static int fib(int n){
        return (int)((Math.pow(((1+Math.sqrt(5))/2),n) - Math.pow(((1-Math.sqrt(5))/2),n)) / Math.sqrt(5));
        //removing less dominating term will not give accurate results
    }
}
