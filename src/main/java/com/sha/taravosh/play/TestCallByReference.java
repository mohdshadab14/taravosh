package com.sha.taravosh.play;

public class TestCallByReference {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int result = add(a,b); // call by value
        System.out.println(result);
        System.out.println(a);
    }
    public static int add(int a, int b){
        a=30;
        int sum = a+b;
        a=40;
        return sum;
    }
}
