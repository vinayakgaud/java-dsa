package com.oops.AbstractandInheritance;

public class ASER {
    // nested interface
    public interface Nestedlnterface {
        boolean isOdd(int num) ; }
}

class B extends ASER implements ASER.Nestedlnterface {
    B o = new B();

    @Override
    public boolean isOdd(int num) {
        return false;
    }
}
