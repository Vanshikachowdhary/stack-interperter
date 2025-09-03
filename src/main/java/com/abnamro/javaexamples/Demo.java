package com.abnamro.javaexamples;

public class Demo {
    public int fibonacci(int n){
        if(n<2){
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static int add(int a, int b){
        return a+b;
    }

    public static void main(String[] args) {
        add(2,4);

    }


//    public int fibonacci2(int n){
//        if(n<2){ return n;}
//        int a=0;
//        int b=1;
//        for(int i=2;i<=n;i++){
//            int temp=a+b;
//            a=b;
//            b=temp;
//        }
//        return b;
//    }
//
//    public int sum(int a) {
//        var sum = 0;
//        for (int i = 1; i <= a; i++) {
//            sum += i;
//        }
//        return sum;
//    }

}
