package io.fengchao.corejava;

public class Fibonacci {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.nthFibonacci(43));
    }

    private long nthFibonacci(int n) {
        long a = 1;
        long b = 1;
        if(n == 0) {
            return 0;
        }
        if(n < 3) {
            return 1;
        }

        n -= 2;
        while(n > 0) {
            long newVal = a + b;
            a = b;
            b = newVal;
            n -= 1;
        }
        return b;
    }
}
