package com.gmail.yeritsyankoryun;

import java.util.Arrays;

public class Calculator {
    CalcService calcService;

    public Calculator(CalcService calcService) {
        this.calcService = calcService;
    }

    public int doStaff(int a, int b) {
        return calcService.add(calcService.multiply(a, b), calcService.multiply(a, b));
    }

    public int division(int a, int b) {
        if(b==0)throw new ArithmeticException();
        return a/b;
    }
    public int myAdd(int a,int b){
        if(a>0 && b>Integer.MAX_VALUE-a){
            throw new RuntimeException();
        }
        if(a<0 && b<Integer.MIN_VALUE-a){
            throw new RuntimeException();
        }
        return a+b;
    }
    public int sumAll(int... ints){
        return Arrays.stream(ints).sum();
    }
    public int square(int x){
        return x*x;
    }
}