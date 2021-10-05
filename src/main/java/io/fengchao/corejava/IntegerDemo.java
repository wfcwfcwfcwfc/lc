package io.fengchao.corejava;

import java.math.BigDecimal;

public class IntegerDemo {
    public static void main(String[] args) {
        // -128 to 127 will reuse existing object.
        Integer integer1 = 100;
        Integer integer2 = 100;
        System.out.println(integer1 == integer2);

        int int1 = 100;
        System.out.println(int1 == integer1);

        BigDecimal bigDecimal = new BigDecimal("0.1");
    }
}
