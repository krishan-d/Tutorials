package com.learning._2_basics_and_oops.oops;

public class StaticAndInstanceBlock {

    int i;
    static int j;
    {
        System.out.println(" Instance Block 1. Value of i = "+i);
    }
    static{
        System.out.println(" Static Block 1. Value of j = "+j);
        method_2();
    }
    {
        i = 5;
    }
    static{
        j = 10;
    }
    StaticAndInstanceBlock(){
        System.out.println(" Welcome to InterviewBit ");
    }
    public static void main(String[] args){
        StaticAndInstanceBlock ib = new StaticAndInstanceBlock();
    }
    public void method_1(){
        System.out.println(" Instance method. ");
    }
    static{
        System.out.println(" Static Block 2. Value of j = "+j);
    }
    {
        System.out.println(" Instance Block 2. Value of i = "+i);
        method_1();
    }
    public static void method_2(){
        System.out.println(" Static method. ");
    }
}
