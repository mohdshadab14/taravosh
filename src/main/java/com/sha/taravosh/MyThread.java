package com.sha.taravosh;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(
                "Running on: " +
                        Thread.currentThread().getName()
        );
    }

    public static void main(String[] args) {
        MyThread t0 = new MyThread();
        MyThread t1 = new MyThread();

        System.out.println(
                "Running on: " +
                        Thread.currentThread().getName());

        t0.start();

        System.out.println(
                "Running on: " +
                        Thread.currentThread().getName());


        t1.start();

        System.out.println(
                "Running on: " +
                        Thread.currentThread().getName());

    }

   /* public static void main(String[] args) {

        System.out.println(
                "Running on 1 : " +
                        Thread.currentThread().getName()
        );

        System.out.println(
                "Running on 2: " +
                        Thread.currentThread().getName()
        );

    }*/



}
